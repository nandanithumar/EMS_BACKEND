package com.argus.ems.master.model;

import com.argus.ems.common.model.TemporalStateEntity;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ems_type")
@Inheritance(strategy = InheritanceType.JOINED)
public class TypeEntity extends TemporalStateEntity implements Serializable{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ref_obj_uri")
    private String refObjectUri;

    @Column(name = "type_name")
    private String name;
    
    @Column(name="state_id")
    private String stateId;

    @Column(name="description_plain")
    private String descriptionPlain;
    
    @Column(name="description_formatted")
    private String descriptionFormatted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    public String getStateId() {
        return stateId;
    }

    public void setStateId(String StateId) {
        this.stateId = StateId;
    }
    

    @Override
    public String toString() {
        return "Type{" + "id=" + this.getId()
                + ", name=" + this.getName()
                + ", refObjectUri=" + this.getRefObjectUri()
                + ", effectiveDate=" + this.getEffectiveDate()
                + ", stateId =" + this.getStateId()
                + ", expirationDate=" + this.getExpirationDate()
                + ", descriptionPlain=" + this.getDescriptionPlain()
                + ", descriptionFormatted=" + this.getDescriptionFormatted()
                + ", createdAt=" + this.getCreatedAt()
                + ", createdBy=" + this.getCreatedBy()
                + ", updatedAt=" + this.getUpdatedAt()
                + ", updatedBy=" + this.getUpdatedBy()+ '}';
    }

}
