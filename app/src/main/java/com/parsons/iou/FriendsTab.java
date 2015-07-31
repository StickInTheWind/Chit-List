package com.parsons.iou;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FriendsTab extends Activity {

    private ParseQueryAdapter<ParseObject> mainAdapter;
    private CustomAdapter myAdapter;
    private ListView listView;

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

        //Adds a new element to the list view. This builds the entire list.
        addElement();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                listSetUp(view, i);

            }
        });

    };
    public void addElement() {

        // Initialize main ParseQueryAdapter
        mainAdapter = new ParseQueryAdapter<ParseObject>(this, "friends");
        mainAdapter.setTextKey("name");
        mainAdapter.setTextKey("totalAmount");
        mainAdapter.setImageKey("photo");

        myAdapter = new CustomAdapter(this);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myAdapter);
        myAdapter.loadObjects();

    }
    public void listSetUp(final View view, final int position){
        ParseUser currentUser = ParseUser.getCurrentUser();  //Grabs the current user

        final ParseQuery<ParseObject> query = ParseQuery.getQuery("friends"); //starts a query for the friends class only.

        query.whereEqualTo("parent", currentUser.getObjectId().toString());  //looks for the owner of the class being the current user
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    ArrayList<String> listOfObjectIDs = new ArrayList<>();

                    for (int i = 0; i < objects.size(); i++) {
                        ParseObject u = objects.get(i);
                        String objectIDS = u.getObjectId();
                        listOfObjectIDs.add(objectIDS);

                    }
                    getObjectID(view, listOfObjectIDs, position);

                } else {

                }
            }

        });

    }
    public void getObjectID(View view, ArrayList<String> listOfObjectIDs, final int position){
        String objectID = listOfObjectIDs.get(position);
        openFriendInfo(view, objectID);

    }


    public void openFriendInfo(View view, String ObjectID){
        // This adds the "listener" to make the button go from one activity to another. The button in the xml must have an onClick methed.
        Intent intent = new Intent(getApplicationContext(), FriendInfo.class);
        intent.putExtra("objectsID",ObjectID);
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