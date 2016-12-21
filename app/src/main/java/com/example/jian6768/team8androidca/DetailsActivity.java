package com.example.jian6768.team8androidca;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{
    Item item=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
        final String itemid = i.getStringExtra("itemid");

        new AsyncTask<String, Void,Item>() {
            @Override
            protected Item doInBackground(String... params) {
//                item = Item.getItem("123") ;

                item = Item.getItem(itemid);
                return item;

            }
            @Override
            protected void onPostExecute(Item result) {
                show(result);
            }
        }.execute(itemid);

        Button buy=(Button)findViewById(R.id.button1);
        buy.setOnClickListener(this);
    }

    void show(final Item item) {
        int []ids = {R.id.textView5, R.id.textView6, R.id.textView7, R.id.textView8};
        String []keys = {"itemName", "description", "price", "status"};
        for (int i=0; i<keys.length; i++) {
            TextView tv = (TextView) findViewById(ids[i]);
            tv.setText(item.get(keys[i]));
        }
    }

    @Override
    public void onClick(View v) {
        item.put("status","Unavaliable");
        Log.i("tes",item.get("status"));
        Item.updateItem(item);
        Toast t=Toast.makeText(this,"Congratulations! You've bought it!",Toast.LENGTH_SHORT);
        t.show();
    }
}
