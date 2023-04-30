package com.example.i_notebook_backend.config.errorHandling;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ApiErrorSerializer extends JsonSerializer<ApiError> {
    // https://www.baeldung.com/spring-boot-jsoncomponent
    @Override
    public void serialize(ApiError apiError, JsonGenerator jgen, SerializerProvider provider) throws IOException {

        jgen.writeStartObject();
        jgen.writeStringField("message", apiError.getMessage());
        jgen.writeEndObject();
    }
}