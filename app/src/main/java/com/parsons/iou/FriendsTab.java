package com.parsons.iou;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FriendsTab extends Activity {

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_tab);
        ListView friendsList = (ListView)findViewById(R.id.listView);

        //Adds a new element to the list view. This builds the entire list.
        addElement();


        friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                openFriendInfo(view);
            }
        });

    };
    public void addElement() {

        ParseUser currentUser = ParseUser.getCurrentUser();  //Grabs the current user

        final ListView friendsList = (ListView)findViewById(R.id.listView); // establishes the listview to use to set values.
        final ParseQuery<ParseObject> query = ParseQuery.getQuery("friends"); //starts a query for the friends class only.
        query.whereEqualTo("parent", currentUser.getObjectId().toString());  //looks for the owner of the class being the current user
        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);
        friendsList.setAdapter(listAdapter);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    //Toast.makeText(getApplicationContext(), objects.toString(), Toast.LENGTH_LONG)
                    //       .show();
                    for (int i = 0; i < objects.size(); i++) {
                        ParseObject u = objects.get(i);
                        String name = u.getString("name").toString();
                        listAdapter.add(name);

                    }
                } else {
                    // Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    public void openFriendInfo(View view){
        // This adds the "listener" to make the button go from one activity to another. The button in the xml must have an onClick methed.
        Intent intent = new Intent(getApplicationContext(), FriendInfo.class);
        startActivity(intent);
    }

    public void openAddFriend(View view){
        // This adds the "listener" to make the button go from one activity to another. The button in the xml must have an onClick methed.
        Intent intent = new Intent(this, AddFriend.class);
        startActivity(intent);
    }
    public void openAddChitFriend(View view){
        // This adds the "listener" to make the button go from one activity to another. The button in the xml must have an onClick methed.
        Intent intent = new Intent(this, AddChitFriend.class);
        startActivity(intent);
    }
}