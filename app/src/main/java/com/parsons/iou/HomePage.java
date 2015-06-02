package com.parsons.iou;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.ui.ParseLoginBuilder;




public class HomePage extends Activity{


    @Override
    public void onBackPressed() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        isLoggedOn();
    }
    // Checks to see if use is logged on then continues with application.
    //===================================================================
    public void isLoggedOn(){
        ParseUser currentUser = ParseUser.getCurrentUser();

        if (currentUser == null) {
            // show the signup or login screen
            ParseLoginBuilder builder = new ParseLoginBuilder(HomePage.this);
            startActivityForResult(builder.build(), 0);
        } else {

        }
            // do stuff with the user
            //Basic Query to access the current user so we can pull data and then later save to local
            ParseQuery<ParseObject> query = ParseQuery.getQuery("User");
            query.getInBackground(currentUser.getObjectId(), new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    if (e == null) {
                        // object will be your User
                    } else {
                        // something went wrong
                    }
                }
            });
            // do stuff with the user


            String firstName = (String) currentUser.get("name");
            Double totalAmount = 4.00;

            // Overrides the text views to establish Welcome, (Persons name) and display the correct owed total.
            TextView name = (TextView) findViewById(R.id.Name);
            TextView total = (TextView) findViewById(R.id.Total);
            name.append(firstName);
            total.append(String.valueOf(totalAmountColor(totalAmount, total)));

    }

    //Sets color green or red depending on amount owed.
   //=================================================================
    public double totalAmountColor(double totalAmount, TextView total){
        if(totalAmount >=0){
            (total).setTextColor(Color.parseColor("#228b22")); //Shows green if people owe you.
            return totalAmount;
        }
            (total).setTextColor(Color.RED); //Shows red if you are in debt to people.
            return totalAmount;

    }

    //Button Declarations and functions.
    //================================================================

    public void openFriendsTab(View view){
      // This adds the "listener" to make the button go from one activity to another. The button in the xml must have an onClick methed.
        Intent intent = new Intent(this, FriendsTab.class);
        startActivity(intent);
    }

    public void openWidgets(View view){
        //Intent intent = new Intent(this, FriendsTab.class);
    }
    public void logOut(View view){
        ParseUser.logOut();
        Intent i = new Intent(HomePage.this,HomePage.class);
        startActivity(i);
        finish();;
    }

}
