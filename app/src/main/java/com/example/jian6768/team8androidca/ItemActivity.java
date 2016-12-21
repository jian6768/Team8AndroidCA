package com.example.jian6768.team8androidca;

import android.app.ListActivity;
import android.content.ClipData;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends ListActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//             Intent i = getIntent();
        Bundle extras = getIntent().getExtras();
        final String category = extras.getString("cid");

        Log.i("asdada",category);
        //remember to change here**********

        new AsyncTask<String, Void,List<Item>>() {
            @Override
            protected List<Item> doInBackground(String... params) {
                List<Item> list = Item.listItem(category);
//                List<String> itemNames = new ArrayList<String>();
//
//                for(Item i : list){
//                    itemNames.add(i.get("itemName"));
//
//                }
//                return itemNames;
                return list;
            }
            @Override
            protected void onPostExecute(List<Item> result) {
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ItemActivity.this,
//                        android.R.layout.simple_list_item_1, result);
                setListAdapter(new SimpleAdapter(ItemActivity.this, result, R.layout.row, new String[]{"itemName"}, new int[]{R.id.textView1}));
            }
        }.execute(category);









//Backup
//        List<Item> list = Item.listItem(category);
//        List<String> itemNames = new ArrayList<String>();
//        for(Item i : list){
//            itemNames.add(i.get("itemName"));
//
//        }
//
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, itemNames);
//        setListAdapter(adapter);
    }




    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        Item item = (Item) getListAdapter().getItem(position);

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("itemid", item);
        startActivity(intent);
    }
}