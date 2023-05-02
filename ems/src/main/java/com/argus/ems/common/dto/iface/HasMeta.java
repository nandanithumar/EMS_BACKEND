
package com.argus.ems.common.dto.iface;

import com.argus.ems.common.dto.info.MetaInfo;


public interface HasMeta {

    /**
     * Create and last update and created info for the structure.
     *
     * @return Meta
     * @readOnly
     * @required on updates
     */
    public MetaInfo getMeta();
}
    