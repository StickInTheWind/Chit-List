package com.parsons.iou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class FriendsTab extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_tab);
        ListView friendsList = (ListView)findViewById(R.id.listView);
        friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openFriendInfo(view);
            }
        });

    };

    public void openFriendInfo(View view){
        // This adds the "listener" to make the button go from one activity to another. The button in the xml must have an onClick methed.
        Intent intent = new Intent(this, FriendInfo.class);
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