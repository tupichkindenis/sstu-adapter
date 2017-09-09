package com.thewhite.sstuapp.importing.office;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * Reduced office entity from EDM.
 */
@Data
@SuppressWarnings("unused")
public final class OfficeEntityReduced {
    @JacksonXmlProperty(localName = "ID")
    private long id;
}
