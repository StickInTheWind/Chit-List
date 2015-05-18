package com.parsons.iou;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
/**
 * Created by Larry Parsons on 5/16/2015.
 */

public class ParseApplication extends Application {
    public static final String MY_APPLICATION_ID = "zEwSr1Reo2HJcUT4q5y5zBLmG4T1CwdQgqGe7Rt1";
    public static final String MY_CLIENT_KEY = "D8u4QbkwHs8B5nX2DUbNJsKKzG3Mw0odiplYBPlQ";

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, MY_APPLICATION_ID, MY_CLIENT_KEY);
        ParseFacebookUtils.initialize(this);
        /*
        // Test creation of object
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        */
    }
}
