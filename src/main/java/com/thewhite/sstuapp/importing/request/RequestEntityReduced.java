package com.thewhite.sstuapp.importing.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * Reduced projection of Request entity.
 *
 */
@Data
@SuppressWarnings("unused")
public final class RequestEntityReduced {
    @JacksonXmlProperty(localName = "ID")
    private Long id;
}
