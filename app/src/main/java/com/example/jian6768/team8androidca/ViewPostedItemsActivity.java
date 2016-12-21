package com.example.jian6768.team8androidca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewPostedItemsActivity extends Activity implements AdapterView.OnItemClickListener {

    private Intent intent;
    private String userID;
    private List<Item> items;

    //temporary to get some test data
    private void getData(){
        items = new ArrayList<Item>();
        items.add(new Item("11", "Samsung Note 5", "Exploding device", 1000.00, "Available", "1", "mobile"));
        items.add(new Item("12", "Adventure Vacation", "book exciting very", 234.60, "Available", "2", "Book"));
        items.add(new Item("13", "Face Shop Brush", "makeup brush", 67.30, "Sold", "3", "Beauty"));
        items.add(new Item("14", "Red Skirt", "ladies skirt", 867.60, "Available", "4", "Women Fashion"));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        //intent = getIntent();
        //userID = intent.getExtras().getString("userID");
        //items = (List<String>)JianWaiYanMethod(userID)

        getData(); //temporary to get some test data

        ListView list = (ListView) findViewById(R.id.listView1);

        list.setAdapter(new SimpleAdapter(this, items, R.layout.row, new String[]{"itemName"}, new int[]{R.id.textView1}));
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id) {
//        Item itemSelected = (Item) av.getAdapter().getItem(position);
//        String itemID = itemSelected.get("itemID");
//
//        Intent newIntent = new Intent(this, AnotherActivity.class);
//        newIntent.putExtra("userID", "123"); //temporary replace userID with "123" for testing
//        newIntent.putExtra("itemID", itemID);
//        startActivity(newIntent);
    }

}

