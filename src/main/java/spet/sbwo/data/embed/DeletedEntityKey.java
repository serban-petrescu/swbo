package spet.sbwo.data.embed;

import spet.sbwo.data.domain.EntityType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class DeletedEntityKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "C_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private EntityType type;

    @Column(name = "C_ID")
    private int id;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + type.ordinal();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeletedEntityKey other = (DeletedEntityKey) obj;
        return id == other.id && type == other.type;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
