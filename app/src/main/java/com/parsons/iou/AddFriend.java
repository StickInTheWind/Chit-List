package com.parsons.iou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
       /* WORKING ON IT
        String name;
        String number;
        EditText nameInput = (EditText) findViewById(R.id.editText);
        name = nameInput.getText().toString();
        EditText numberInput = (EditText) findViewById(R.id.editText2);
        number = numberInput.getText().toString();

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, FriendsTab.class);
        bundle.putParcelable();
        intent.putExtras(bundle);



        startActivity(intent);
        onDestroy();
        */
    }
}
