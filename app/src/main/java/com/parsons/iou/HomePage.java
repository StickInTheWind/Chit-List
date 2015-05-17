package com.parsons.iou;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends Activity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_page);
        TextView name = (TextView) findViewById(R.id.Name);
        TextView total = (TextView) findViewById(R.id.Total);

        // Need to define these variables later once User class is created.
        String firstName = "YO";
        Double totalAmount = 4.00;

       // Overrides the text views to establish Welcome, (Persons name) and display the correct owed total.
        name.append(firstName);
        ;
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
    public void openAccountManagement(View view){
        //Intent intent = new Intent(this, FriendsTab.class);
    }
}
