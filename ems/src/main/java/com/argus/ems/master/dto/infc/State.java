
package com.argus.ems.master.dto.infc;

import com.argus.ems.common.dto.iface.TemporalTypeStatelessEntity;


public interface State extends TemporalTypeStatelessEntity {

    public String getRefObjectUri();

    public boolean getIsInitialState();

}
