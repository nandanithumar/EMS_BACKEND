package com.argus.ems.master.model;

import com.argus.ems.common.model.TemporalTypeStatelessEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "ems_state")
@Inheritance(strategy=InheritanceType.JOINED)
public class StateEntity extends TemporalTypeStatelessEntity implements Serializable{
    

    @Id
    @Column(name = "id")
    private String id;
    

    @Column(name = "ref_obj_uri")
    private String refObjectUri;
    
    @Column(name = "effective_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Column(name = "is_initial_state")
    private boolean isInitialState;
    
   
    @Column(name="state_name")
    private String name;
    
    
    @Column(name="description_plain")
    private String descriptionPlain;
    
    @Column(name="description_formatted")
    private String descriptionFormatted;
    
    

    @Override
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    @Override
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    
 
    
    public String getRefObjectUri() {
        return refObjectUri;
    }

    public void setRefObjectUri(String refObjectUri) {
        this.refObjectUri = refObjectUri;
    }

    public boolean getIsInitialState() {
        return isInitialState;
    }

    public void setIsInitialState(boolean isInitialState) {
        this.isInitialState = isInitialState;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescriptionPlain() {
        return descriptionPlain;
    }

    @Override
    public void setDescriptionPlain(String descriptionPlain) {
        this.descriptionPlain = descriptionPlain;
    }

    @Override
    public String getDescriptionFormatted() {
        return descriptionFormatted;
    }

    @Override
    public void setDescriptionFormatted(String descriptionFormatted) {
        this.descriptionFormatted = descriptionFormatted;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "State{" + "id=" + this.getId()
                + ", name=" + this.getName()
                + ", refObjectUri=" + this.getRefObjectUri()
                + ", isInitialState=" + this.getIsInitialState()
                + ", effectiveDate=" + this.getEffectiveDate()
                + ", expirationDate=" + this.getExpirationDate()
                + ", descriptionPlain=" + this.getDescriptionPlain()
                + ", descriptionFormatted=" + this.getDescriptionFormatted()
                + ", createdAt=" + this.getCreatedAt()
                + ", createdBy=" + this.getCreatedBy()
                + ", updatedAt=" + this.getUpdatedAt()
                + ", updatedBy=" + this.getUpdatedBy()+ '}';
    }

}