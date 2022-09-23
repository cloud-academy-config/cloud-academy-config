package com.cloudlab.mvpuserservice.provider.rest.error;

import feign.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorDecoder implements feign.codec.ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                break;
            case 404:
                if (methodKey.contains("getOrders")) {
                    return new ResponseStatusException(HttpStatus.valueOf(response.status()),
                            "User's order is empty");
                }
            default:
                return new Exception(response.reason());
        }
        return null;
    }
}
