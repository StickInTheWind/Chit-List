package com.parsons.iou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;
import com.parse.SaveCallback;

/**
 * Created by Edward on 6/2/2015.
 */
public class AddFriend extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

    };

    public void AddButton(View view){

        ParseUser currentUser = ParseUser.getCurrentUser();
        ParseObject data = new ParseObject("friends");
        String name;
        String number;
        EditText nameInput = (EditText) findViewById(R.id.editText);
        name = nameInput.getText().toString();
        EditText numberInput = (EditText) findViewById(R.id.editText2);
        number = numberInput.getText().toString();

        data.put("name", name);
        data.put("phoneNumber", Double.parseDouble(number));
        data.put("totalAmount", 0.00);

        data.put("parent", currentUser.getObjectId());
        data.saveInBackground();


        Intent intent = new Intent(this, FriendsTab.class);
        startActivity(intent);

    }
}
