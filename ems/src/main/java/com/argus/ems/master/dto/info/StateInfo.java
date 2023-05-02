
package com.argus.ems.master.dto.info;


import com.argus.ems.common.dto.info.TemporalTypeStatelessEntityInfo;
import com.argus.ems.master.dto.infc.State;
import java.io.Serializable;

/**
 * This info is for state DTO that contains all the state model's data.
 *
 */
public class StateInfo
        extends TemporalTypeStatelessEntityInfo
        implements State, Serializable {

    
    private String refObjectUri;

   
    private boolean isInitialState;

    public StateInfo() {
    }

    /**
     * This is copy constructor that make deep copy of the State.
     *
     * @param state
     */
    public StateInfo(State state) {
        super(state);
        if (state != null) {
            this.refObjectUri = state.getRefObjectUri();
            this.isInitialState = state.getIsInitialState();
        }
    }

    @Override
    public String getRefObjectUri() {
        return refObjectUri;
    }

    public void setRefObjUri(String refObjUri) {
        this.refObjectUri = refObjUri;
    }

    @Override
    public boolean getIsInitialState() {
        return isInitialState;
    }

    public void setIsInitialState(boolean isInitialState) {
        this.isInitialState = isInitialState;
    }

    @Override
    public String toString() {
        return "StateInfo{"
                + "id=" + this.getId()
                + ", name=" + this.getName()
                + ", refObjectUri=" + refObjectUri
                + ", isInitialState=" + isInitialState
                + ", effectiveDate" + this.getEffectiveDate()
                + ", expirationDate" + this.getExpirationDate()
                + ", meta=" + this.getMeta()
                + ", description=" + this.getDescription()
                + '}';
    }

}
