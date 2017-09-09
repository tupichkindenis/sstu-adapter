package com.thewhite.sstuapp.importing.support;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

/**
 * Created by tupichkindenis on 30.08.17.
 */
public class HttpEntityBuilder<T> {
    private MultiValueMap<String, String> headers = new HttpHeaders();
    private T body;

    public HttpEntityBuilder() {
    }

    public HttpEntityBuilder<T> body(T body) {
        this.body = body;
        return this;
    }

    public HttpEntityBuilder<T> header(String name, String value) {
        this.headers.add(name, value);
        return this;
    }

    public HttpEntity<T> build() {
        return new HttpEntity(this.body, this.headers);
    }
}