package com.thewhite.sstuapp.importing.support;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Common identifier for remote entities.
 */
@Data
public class RemoteEntityIdentifier implements Serializable {
    @JacksonXmlProperty(localName = "ID")
    private long id;
}
