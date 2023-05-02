
package com.argus.ems.common.dto.iface;

/**
 * This Interface is provides contract for RichTextInfo.
 */
public interface RichText {

    /**
     * Plain text version of the rich text with all the special formatting
     * stripped out.
     *
     * @return Plain Text
     */
    public String getPlain();

    /**
     * Formatted version of the rich text with all the formatting included.
     *
     * @return Formatted Text
     */
    public String getFormatted();

}
