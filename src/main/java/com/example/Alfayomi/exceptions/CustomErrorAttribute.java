package com.example.Alfayomi.exceptions;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Map;

@Component
public class CustomErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String , Object> errorAttribute = super.getErrorAttributes(webRequest , options);

        errorAttribute.put("success" , Boolean.FALSE );
        errorAttribute.put("status" , errorAttribute.get("error") );
        errorAttribute.put("exception" , errorAttribute.get("message") );
        errorAttribute.put("details" , Arrays.asList(errorAttribute.get("message")));
        errorAttribute.remove("path");
//        errorAttribute.remove("error");

        return errorAttribute;


    }
}
