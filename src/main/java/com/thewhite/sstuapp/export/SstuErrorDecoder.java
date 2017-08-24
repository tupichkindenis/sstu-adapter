package com.thewhite.sstuapp.export;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Created by tupichkindenis on 23.08.17.
 */
@SuppressWarnings("unused")
public class SstuErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        return null;
    }
}
