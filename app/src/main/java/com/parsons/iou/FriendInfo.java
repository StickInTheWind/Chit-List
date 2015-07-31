package com.parsons.iou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edward on 5/21/2015.
 */
public class FriendInfo extends Activity{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_friend_info);

            Intent intent = getIntent();
            String objectID = intent.getStringExtra("objectsID");

            setNameField(objectID);
        };

        public void setNameField(String objectID){
            ParseUser currentUser = ParseUser.getCurrentUser();

            ParseQuery<ParseObject> thisFriend = ParseQuery.getQuery("friends");
            thisFriend.whereEqualTo("parent", currentUser.getObjectId().toString());
            thisFriend.whereEqualTo("objectId", objectID);
            thisFriend.findInBackground(new FindCallback<ParseObject>() {
                public void done(List<ParseObject> friend, ParseException e) {
                    if (e == null) {

                        for (int i = 0; i < friend.size(); i++) {
                            ParseObject u = friend.get(i);
                            String name = u.getString("name").toString();
                            Double chit = u.getDouble("totalAmount");

                            // Overrides the text views to establish (Persons name) and display the correct owed total.
                            TextView fullName = (TextView) findViewById(R.id.textView);
                            fullName.setText(name);
                            TextView total = (TextView) findViewById(R.id.textView2);
                            total.setText(String.valueOf(chit));
                        }
                    } else {

                    }
                }
            });

        }
    }

