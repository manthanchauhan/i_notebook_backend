package com.example.i_notebook_backend.config.constants;

import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.Map;

@UtilityClass
public class RequestResponseConst {
    public static final Map<String, String> successResponseMap = Collections.singletonMap("message", "Success");
}
