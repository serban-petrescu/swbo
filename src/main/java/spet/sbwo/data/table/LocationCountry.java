package spet.sbwo.data.table;

import spet.sbwo.data.base.BaseEntity;
import spet.sbwo.data.base.ICodifiedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "T_LOCATION_COUNTRY")
public class LocationCountry extends BaseEntity implements ICodifiedEntity<String> {
    @Column(name = "C_NAME")
    private String name;

    @Column(name = "C_CODE")
    private String code;

    @OneToMany(mappedBy = "country")
    private List<LocationRegion> regions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<LocationRegion> getRegions() {
        return regions;
    }

    public void setRegions(List<LocationRegion> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "LocationCountry [name=" + name + ", code=" + code + ", id=" + id + "]";
    }

}
