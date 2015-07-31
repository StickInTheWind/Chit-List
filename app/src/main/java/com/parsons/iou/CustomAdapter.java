package com.parsons.iou;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

import java.text.DecimalFormat;

/**
 * Created by Larry Parsons on 7/30/2015.
 */


public class CustomAdapter extends ParseQueryAdapter<ParseObject> {



    public CustomAdapter(Context context) {
        // Use the QueryFactory to construct a PQA that will only show
        // Todos marked as high-pri

        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseUser currentUser = ParseUser.getCurrentUser();  //Grabs the current user
                final ParseQuery<ParseObject> query = ParseQuery.getQuery("friends"); //starts a query for the friends class only.
                query.whereEqualTo("parent", currentUser.getObjectId().toString());  //looks for the owner of the class being the current user

                return query;
            }
        });
    }

    // Customize the layout by overriding getItemView
    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if (v == null) {
            v = View.inflate(getContext(), R.layout.list_items, null);
        }

        super.getItemView(object, v, parent);
        // Add and download the image
        ParseImageView Image = (ParseImageView) v.findViewById(R.id.item_icon);
        ParseFile imageFile = object.getParseFile("photo");
        if (imageFile != null) {
            Image.setParseFile(imageFile);
            Image.loadInBackground();
        }else if (imageFile == null){
            Image.setImageResource(R.drawable.iconuser);
        }


        // Add the title view
        TextView titleTextView = (TextView) v.findViewById(R.id.item_title);
        titleTextView.setText(object.getString("name"));
        Double totalAmount = object.getDouble("totalAmount");
        // Prepare format to apply for Total
        DecimalFormat format = new DecimalFormat("#0.00");
        // Formats the number
        String formattedText = format.format(totalAmount);

        TextView totalTextView = (TextView) v.findViewById(R.id.item_total);
        totalTextView.setText("$" + String.valueOf(totalAmountColor(formattedText, totalTextView)));
        String objectsID = object.getObjectId();
        return v;
    }

    public String totalAmountColor(String totalAmount, TextView total){
        if(Double.parseDouble(totalAmount) >=0){
            (total).setTextColor(Color.parseColor("#228b22")); //Shows green if people owe you.
            return totalAmount;
        }
        (total).setTextColor(Color.RED); //Shows red if you are in debt to people.
        return totalAmount;

    }

}
