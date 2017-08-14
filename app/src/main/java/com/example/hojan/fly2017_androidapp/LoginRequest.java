package com.example.hojan.fly2017_androidapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hojan on 2017-08-13.
 */

public class LoginRequest extends StringRequest {

    final  static private String URL = "http://jisung0920.cafe24.com/ftpLogin.php";
    private Map<String, String> parameters;

    public LoginRequest(String userID, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userPassword",userPassword);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
