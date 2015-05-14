package com.parsons.iou;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class HomePage extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    };
//
//    protected void onCreate() {
//        setContentView(R.layout.activity_home_page);
//
//
//    }

    public void openFriendsTab(View view){
      // This adds the "listener" to make the button go from one activity to another. The button in the xml must have an onClick methed.
        Intent intent = new Intent(this, FriendsTab.class);
        startActivity(intent);
    }

    public void openWidgets(View view){
        //Intent intent = new Intent(this, FriendsTab.class);
    }
    public void openAccountManagement(View view){
        //Intent intent = new Intent(this, FriendsTab.class);
    }
}
