package spet.sbwo.api.service.misc;

import spet.sbwo.api.service.base.BaseService;
import spet.sbwo.api.service.base.IPrivate;
import spet.sbwo.control.channel.misc.CountChannel;
import spet.sbwo.control.controller.misc.CountController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/utility")
public class CountService extends BaseService implements IPrivate {
    private final CountController controller;

    public CountService(CountController utilityController) {
        this.controller = utilityController;
    }

    @GET
    @Path("/count")
    @Produces("application/json")
    public CountChannel count() {
        try {
            return controller.readCounts();
        } catch (Exception e) {
            throw mapException(e);
        }
    }

}
