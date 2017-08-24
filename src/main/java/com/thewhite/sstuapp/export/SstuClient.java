package com.thewhite.sstuapp.export;

import com.thewhite.sstuapp.export.dto.SstuRequest;
import feign.Headers;
import feign.RequestLine;

@SuppressWarnings("unused")
public interface SstuClient {
    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void upload(final SstuRequest question);
}
