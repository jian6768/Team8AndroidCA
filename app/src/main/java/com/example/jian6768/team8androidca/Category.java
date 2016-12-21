package com.example.jian6768.team8androidca;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by User on 21/12/2016.
 */

public class Category extends java.util.HashMap<String,String> {

    //you can try out local host first

    //if it doesnt work, change ip address to your comp ip address

    final static String host = "http://192.168.20.172:8090/Item/Service.svc";

    public Category(String categoryName) {

        put("categoryName",categoryName);

    }

    public Category(){}

    public static List<String> listCategory(){
        List<String> list = new ArrayList<String>();
        list.add("Baby");
        list.add("Beauty");
        list.add("Book");
        list.add("Computer");
        list.add("Electronics");
        list.add("Furniture");
        list.add("Health");
        list.add("Kitchen");
        list.add("Men Fashion");
        list.add("Mobile");
        list.add("Sport");
        list.add("Women Fashion");




        return list;
    }






}