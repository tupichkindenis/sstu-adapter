package com.thewhite.sstuapp.export.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@SuppressWarnings("unused")
public @Data class SstuAttachment {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "content")
    private byte[] content;
}
