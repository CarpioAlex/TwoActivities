package com.acarpio.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    // onCreate callback, Important, set the view!!!

    // Must override the method.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Calling the father's onCreate method.
        super.onCreate(savedInstanceState);
        // Important! Setting the view.
        setContentView(R.layout.second_activity);

        // Fetching the button (como en CSS)
        Button returnButton = findViewById(R.id.returnButton);
        // Creating the listener
        View.OnClickListener returnButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
                finish();

            }
        };
        // Assigning the listener to the button
        returnButton.setOnClickListener(returnButtonListener);

        // Retrieving the extra:

        Intent intent = getIntent();
        // Uses the key from the extra.
        String extraValue = intent.getStringExtra("mySuperExtra");

        // Getting the view that holds the text
        TextView extraOutput = findViewById(R.id.extraOutput);
        // Seting the text
        extraOutput.setText(extraValue);



    }

    // Returning the result

    public void backToActivityWithResult(View v) {
        // Getting the text first
        EditText resultText = findViewById(R.id.resultText);
        String result = String.valueOf(resultText.getText());

        // Creating the intent
        Intent backIntent = getIntent();
        backIntent.putExtra("result", result);
        setResult(1, backIntent);

        finish();


    }







}
