package com.example.jian6768.team8androidca;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jian6768 on 21/12/2016.
 */

public class Item extends java.util.HashMap<String,String> {


    final static String host = "http://10.10.24.108/Team8/Service.svc";



    public Item(){}


    //Remember to change

    public static List<Item> listItem(String categoryName) {
        List<Item> list = new ArrayList<Item>();
        try {
            String s = host+"/Item/Category/"+categoryName;
            Log.i("sdfa",s);
            JSONArray a = JSONParser.getJSONArrayFromUrl(s);

            for (int i=0; i<a.length(); i++) {
                JSONObject b = a.getJSONObject(i);
                list.add(new Item(b.getString("ItemID"),b.getString("ItemName"),
                        b.getString("Description"),Double.parseDouble(b.getString("Price")),b.getString("Status"),b.getString("UserID"),
                        b.getString("CategoryName")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Item i: list){
            Log.i("itemID",i.get("itemID"));
        }



        return list;


    }


    public static Item tempgetItem(String itemID){

        if(itemID.equals("MangoDress")){
            return new Item("3","MangoDress","Red Color. Midi Length. Short sleeve. M Size",
                    15,"Available","8","Women Fashion");

        } else if(itemID.equals("Samsung Note 5")){
            return new Item("5","Samsung Note 5","Fr peopel who have shoe fetish",
                    20,"Available","9","Mobile");
        } else {
            return new Item("4","Pedro Shoes","Fr peopel who have shoe fetish",
                    20,"Available","9","Men Fashion");
        }

    }

    public static List<Item> tempListItem(String category){
        List<Item> list = new ArrayList<Item>();

        list.add(new Item("3","MangoDress","Red Color. Midi Length. Short sleeve. M Size",
                15,"Available","8","Women Fashion"));
        list.add(new Item("3","MangoDress","Red Color. Midi Length. Short sleeve. M Size",
                15,"Available","8","Women Fashion"));
        list.add(new Item("3","MangoDress","Red Color. Midi Length. Short sleeve. M Size",
                15,"Available","8","Women Fashion"));

        return list;
    }


    public Item(String itemID, String itemName, String description, double price, String status,String userID,String categoryName) {
        put("itemID",itemID);
        put("itemName",itemName);
        put("description",description);
        put("price",Double.toString(price));
        put("status",status);
        put("userID",userID);
        put("categoryName",categoryName);

    }


    public static Item getItem(String itemID) {
        Item cus = null;

        try {
            String s =host+"/Item/"+itemID;
            Log.i("getItem",s);
            JSONObject c = JSONParser.getJSONFromUrl(s);
            cus = new Item(c.getString("itemID"),c.getString("itemName"),
                    c.getString("description"),Double.parseDouble(c.getString("price")),c.getString("status"),
                    c.getString("userID"),c.getString("categoryName"));
        } catch (Exception e) {
        }
        return cus;
    }


    public static void updateItem(Item item) {
        JSONObject jcustomer = new JSONObject();
        try {
            jcustomer.put("itemID",item.get("itemID"));
            jcustomer.put("itemName",item.get("itemName"));
            jcustomer.put("description",item.get("description"));
            jcustomer.put("price",item.get("price"));
            jcustomer.put("status",item.get("status"));
            jcustomer.put("userID",item.get("userID"));
            jcustomer.put("categoryName",item.get("categoryName"));

        } catch (Exception e) {
        }
        String result = JSONParser.postStream(host+"/Update", jcustomer.toString());
    }




}
