
package com.argus.ems.common.dto.iface;

public interface HasId extends HasPrimaryKey {

    /**
     * The system assigned unique id to identify this Object. Could be
     * implemented as as sequence number or as a UUID.
     *
     * @return Unique Id
     * @required on updates
     */
    public String getId();
}
