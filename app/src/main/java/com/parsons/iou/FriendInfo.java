package com.parsons.iou;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Edward on 5/21/2015.
 */
public class FriendInfo extends Activity{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_friend_info);
            setNameField();
        };

        public void setNameField(){
            String name;
            String chit;
        //Work in Progress

            // Overrides the text views to establish (Persons name) and display the correct owed total.
            TextView fullName = (TextView) findViewById(R.id.textView);
            TextView total = (TextView) findViewById(R.id.textView2);
           // fullName.setText(name);
           // total.setText(chit);
        }
    }

