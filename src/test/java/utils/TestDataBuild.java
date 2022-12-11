package utils;

import pojo.AddUserInfo;

import java.util.HashMap;

public class TestDataBuild {


    public AddUserInfo addUserInfoObj(HashMap<Object,Object> map)

    {
        AddUserInfo a= new AddUserInfo();
        a.setFirstName(((HashMap)map.get("name")).get("first").toString());
        a.setLastName(((HashMap)map.get("name")).get("last").toString());
        a.setAddress((((HashMap)((HashMap)map.get("location")).get("street")).get("number")+" "+((HashMap)((HashMap)map.get("location")).get("street")).get("name")).toString());
        a.setCity((((HashMap)map.get("location")).get("city")).toString());
        a.setState((((HashMap)map.get("location")).get("state")).toString());
        a.setZipCode((((HashMap)map.get("location")).get("postcode")).toString());
        a.setPhoneNumber(map.get("phone").toString());
        a.setSsn("2838383");
        a.setUsername(((HashMap)map.get("login")).get("username").toString());
        a.setPassword(((HashMap)map.get("login")).get("password").toString());
        a.setConfirm(((HashMap)map.get("login")).get("password").toString());
        return a;
    }



}