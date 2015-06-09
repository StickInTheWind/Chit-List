package com.parsons.iou;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.ui.ParseLoginBuilder;

import java.text.DecimalFormat;


public class HomePage extends Activity{

    //Overrides the back button so people can't access the homepage with out being logged on.
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
    //===================================================================
    // Gets called once startActivityForResult finishes. Has to be called because of multithreading.


    protected void onActivityResult(int requestCode, int resultCode,
                                  Intent data) {
         isLoggedOn();
    }


    public void isLoggedOn(){
        ParseUser currentUser = ParseUser.getCurrentUser();

        if (currentUser == null) {
            // show the signup or login screen
            ParseLoginBuilder builder = new ParseLoginBuilder(HomePage.this);
            startActivityForResult(builder.build(), 0);

        } else {
            //Sets screen values

            String firstName = (String) currentUser.get("name");
            Double totalAmount = currentUser.getDouble("total");
            // Prepare format to apply for Total
            DecimalFormat format = new DecimalFormat("#.00");
            // Formats the number
            String formattedText = format.format(totalAmount);

            // Overrides the text views to establish Welcome, (Persons name) and display the correct owed total.
            TextView name = (TextView) findViewById(R.id.Name);
            TextView total = (TextView) findViewById(R.id.Total);
            name.append(firstName);
            total.append(String.valueOf(totalAmountColor(formattedText, total))); //Gets called to set color
        }


    }

    //Sets color green or red depending on amount owed.
   //=================================================================
    public String totalAmountColor(String totalAmount, TextView total){
        if(Double.parseDouble(totalAmount) >=0){
            (total).setTextColor(Color.parseColor("#228b22")); //Shows green if people owe you.
            return totalAmount;
        }
            (total).setTextColor(Color.RED); //Shows red if you are in debt to people.
            return totalAmount;

    }

    //Button Declarations and functions.
    //================================================================

    //Opens the Friends List
    public void openFriendsTab(View view){
      // This adds the "listener" to make the button go from one activity to another. The button in the xml must have an onClick method.
        Intent intent = new Intent(this, FriendsTab.class);
        startActivity(intent);
    }

    // Opens the soon to be widgets for different applications.
    public void openWidgets(View view){
        //Intent intent = new Intent(this, FriendsTab.class);
    }

    // Logs out user.
    public void logOut(View view){
        ParseUser.logOut();
        //Recalls this calls after the user is logged out which then makes the login builder start
        Intent i = new Intent(HomePage.this,HomePage.class);
        startActivity(i);
        finish();;
    }
}