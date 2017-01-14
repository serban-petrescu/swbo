sap.ui.define([
	"./Base",
	"sap/ui/core/routing/HashChanger"
], function(Base, HashChanger) {
	"use strict";
	
	return Base.extend("spet.sbwo.web.controller.Root", {
		onInit: function() {
			var sClass = this.getOwnerComponent().getContentDensityClass(),
				oHash = HashChanger.getInstance(),
				fnUpdateModel = this.updateFavoriteModel.bind(this),
				oModel;
			this.buildViewModel({
				menu: false,
				edit: false,
				favourites: [],
				isFavourite: false,
				hash: oHash.getHash()
			});
			
			this.getView().addStyleClass(sClass);
			this.byId("sedGlobalSearch").addStyleClass(sClass);
			
			oModel = this.getModel("view");
			oHash.attachEvent("hashChanged", function(oEvent) {
				oModel.setProperty("/hash", oEvent.getParameter("newHash"));
				fnUpdateModel();
			});
			oHash.attachEvent("hashReplaced", function(oEvent) {
				oModel.setProperty("/hash", oEvent.getParameter("sHash"));
				fnUpdateModel();
			});
			oHash.attachEvent("hashSet", function(oEvent) {
				oModel.setProperty("/hash", oEvent.getParameter("sHash"));
				fnUpdateModel();
			});
		},
		
		onShowFavourites: function() {
			var oModel = this.getModel("view"),
				bOpen,
				fnUpdateModel = this.updateFavoriteModel.bind(this);
				
			if (this.getModel("device").getProperty("/system/phone")) {
				oModel.setProperty("/menu", true);
				this.byId("dlgFavourites").open();
				bOpen = true;
			}
			else {
				bOpen = !oModel.getProperty("/menu");
				oModel.setProperty("/menu", bOpen);
			}
			
			if (bOpen) {
				jQuery.ajax({
					method: "GET",
					url: "/private/api/rest/user/favourites/read",
					success: fnUpdateModel
				});
			}
		},
		
		onToggleEdit: function(oEvent) {
			if (!oEvent.getSource().getPressed()) {
				jQuery.ajax({
					method: "PUT",
					url: "/private/api/rest/user/favourites/update",
					dataType: "json",
					contentType: "application/json",
					data: JSON.stringify(this.getModel("view").getProperty("/favourites")),
					success: this.updateFavoriteModel.bind(this)
				});
			}
		},
		
		updateFavoriteModel: function(aFavData) {
			var oModel = this.getModel("view"),
				sHash = oModel.getProperty("/hash"),
				aFavs = aFavData === undefined ? oModel.getProperty("/favourites") : aFavData,
				i,
				bFound = false;
			for (i = 0; i < aFavs.length; ++i) {
				if (aFavs[i].hash === sHash) {
					bFound = true;
					break;
				}
			}
			aFavs.sort(function(a, b) {
				var sTitleA = a.title.toUpperCase(); 
				var sTitleB = b.title.toUpperCase(); 
				if (sTitleA < sTitleB) {
					return -1;
				}
				if (sTitleA > sTitleB) {
					return 1;
				}
				return 0;
			});
			oModel.setProperty("/favourites", aFavs);
			oModel.setProperty("/isFavourite", bFound);
		},
		
		onToggleFavourite: function(oEvent) {
			var oModel = this.getModel("view"),
				aFavs = oModel.getProperty("/favourites"),
				sHash = oModel.getProperty("/hash"),
				i,
				fnUpdateModel = this.updateFavoriteModel.bind(this);
				
			if (oEvent.getSource().getPressed()) {
				jQuery.ajax({
					method: "POST",
					url: "/private/api/rest/user/favourites/create",
					headers: {"X-CSRF-TOKEN": this.getModel().getSecurityToken()},
					dataType: "json",
					contentType: "application/json",
					data: JSON.stringify({
						hash: sHash,
						title: window.document.title
					}),
					success: function(oData) {
						aFavs.push(oData);
						fnUpdateModel(aFavs);
					}
				});
			}
			else {
				for (i = 0; i < aFavs.length; ++i) {
					if (aFavs[i].hash === sHash) {
						break;
					}
				}
				if (i < aFavs.length) {
					jQuery.ajax({
						method: "DELETE",
						url: "/private/api/rest/user/favourites/delete/" + aFavs[i].id
					}).always(function() {
						aFavs.splice(i, 1);
						fnUpdateModel(aFavs);
					});
				}
			}
		},
		
		onDeleteFavouriteEdit: function(oEvent) {
			var oItem = oEvent.getParameter("listItem"),
				sPath = oItem.getBindingContext("view").getPath(),
				iIndex = parseInt(sPath.substring(sPath.lastIndexOf("/") + 1), 10),
				aFavs = this.getModel("view").getProperty("/favourites");
			aFavs.splice(iIndex, 1);
			this.updateFavoriteModel(aFavs);
		},
		
		onCloseFavourites: function() {
			this.getModel("view").setProperty("/menu", false);
			this.byId("dlgFavourites").close();
		},
		
		onNavigateToFavourite: function(oEvent) {
			var sHash = oEvent.getSource().getBindingContext("view").getProperty("hash");
			HashChanger.getInstance().setHash(sHash);
		},
		
		onPressHome: function() {
			this.getRouter().navTo("home", {});
		},
		
		onOpenGlobalSearch: function() {
			this.byId("sedGlobalSearch").open("");
		},
		
		onSuggestGlobal: function(oEvent) {
			var oControl = oEvent.getSource(),
				oBinding = oControl.getBinding("suggestionItems");
			this.applySearchFilter(oEvent.getParameter("suggestValue"), "Search", oBinding);
			oBinding.attachEventOnce("dataReceived", function() {
				oControl.suggest(true);
			});
		},
		
		onSearchField: function(oEvent) {
			var oItem = oEvent.getParameter("suggestionItem"),
				oContext;
			if (oItem) {
				oContext = oItem.getBindingContext();
				this.navigateToEntity(oContext.getProperty("Type"), oContext.getProperty("Id"));
			}
		},
		
		onSearchDialog: function(oEvent) {
			this.applySearchFilter(oEvent.getParameter("value"), "Search", oEvent.getParameter("itemsBinding"));
		},
		
		onSelectSearchDialog: function(oEvent) {
			var oContext = oEvent.getParameter("selectedItem").getBindingContext();
			this.navigateToEntity(oContext.getProperty("Type"), oContext.getProperty("Id"));
		}
	});

});