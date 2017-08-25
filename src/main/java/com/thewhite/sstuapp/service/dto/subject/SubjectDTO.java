package com.thewhite.sstuapp.service.dto.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * Created by tupichkindenis on 16.08.17.
 */
@Data
@Builder
public class SubjectDTO {
    @JsonIgnore
    private UUID uuid;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
}
