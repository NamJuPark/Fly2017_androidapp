package com.example.hojan.fly2017_androidapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hojan on 2017-08-13.
 */

public class checkRequest extends StringRequest {

    final  static private String URL = "http://jisung0920.cafe24.com/ftpCheck.php";
    private Map<String, String> parameters;

    public checkRequest(String userID, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
