package org.example.springframe.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "Joey");
        hashMap.put("10002", "Admin");
        hashMap.put("10003", "Guest");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}