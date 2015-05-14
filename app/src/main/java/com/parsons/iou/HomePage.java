package com.parsons.iou;



import android.app.Activity;
import android.content.Intent;
import android.R.layout;
import android.view.View;



public class HomePage extends Activity{
    protected void onCreate() {
        setContentView(R.layout.activity_home_page);

        final View controlsView = findViewById(R.id.fullscreen_content_controls);
        final View contentView = findViewById(R.id.fullscreen_content);

    }
    public void openFriendsTab(View view){
        Intent intent = new Intent(this, FriendsTab.class);
    }
    public void openWidgets(View view){
        //Intent intent = new Intent(this, FriendsTab.class);
    }
    public void openAccountManagement(View view){
        //Intent intent = new Intent(this, FriendsTab.class);
    }
}
