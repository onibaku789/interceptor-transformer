package com.example.interceptor;

import org.json.JSONObject;
import com.example.model.DataObject;


public class JsonToDataObjectInterceptor implements DataInterceptor<JSONObject, DataObject> {
    @Override
    public DataObject intercept(JSONObject input) {
        return DataObject.fromJson(input);
    }
}
