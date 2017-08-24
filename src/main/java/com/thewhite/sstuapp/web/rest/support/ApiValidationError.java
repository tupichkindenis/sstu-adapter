package com.thewhite.sstuapp.web.rest.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by tupichkindenis on 24.08.17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@SuppressWarnings("unused")
class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}