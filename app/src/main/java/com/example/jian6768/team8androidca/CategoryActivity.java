package com.example.jian6768.team8androidca;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_category2);
        List<String> cat= Category.listCategory();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,cat);
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id){

        String category =(String) getListAdapter().getItem(position);
        Intent intent=new Intent(this,ItemActivity.class);
        intent.putExtra("cid",category);
        startActivity(intent);
    }



}