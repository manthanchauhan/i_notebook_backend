package com.example.i_notebook_backend.utils.errorHandling;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ApiErrorSerializer extends StdSerializer<ApiError> {
    public ApiErrorSerializer(Class<ApiError> t) {
        super(t);
    }

    @Override
    public void serialize(ApiError apiError, JsonGenerator jgen, SerializerProvider provider) throws IOException {

        jgen.writeStartObject();
        jgen.writeStringField("message", apiError.getMessage());
        jgen.writeEndObject();
    }
}