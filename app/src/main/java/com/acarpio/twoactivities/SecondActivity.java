package com.acarpio.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    static final String TAG = "ONLOGGING";
    // onCreate callback, Important, set the view!!!

    // Must override the method.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Entered OnCreate of SecondActivity");
        // Calling the father's onCreate method.
        super.onCreate(savedInstanceState);
        // Important! Setting the view.
        setContentView(R.layout.second_activity);

        // Making it fullscreen
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);



            return insets;
        });

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

        // Retrieving the extras:

        // String extra
        Intent intent = getIntent();
        // Uses the key from the extra.
        String extraValue = intent.getStringExtra("mySuperExtra");

        // Boolean extra
        boolean isForResult = intent.getBooleanExtra("forResultBool", false);
        if (!isForResult) {
            Button resultBack = findViewById(R.id.resultBack);
            resultBack.setVisibility(View.GONE);
        }


        // Getting the view that holds the text
        TextView extraOutput = findViewById(R.id.extraOutput);
        // Seting the text
        extraOutput.setText(extraValue);

        // Trying also a toast

        Toast.makeText(this, "Your extra message is: " + extraValue, Toast.LENGTH_LONG).show();



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
        Log.d(TAG, "Finishing SecondActivity with result: " + result);
        finish();


    }

    // OnStart callback

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, "Entered onStart of SecondActivity");

    }

    // OnPause callback

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "Entered onPause of SecondActivity");

    }


    //onRestart callback

    @Override
    public void onRestart() {
        super.onRestart();

        Log.d(TAG, "Entered onRestart of SecondActivity");

    }


    //onResume callback

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "Entered onResume of SecondActivity");

    }

    //onStop callback

    @Override
    public void onStop() {
        super.onStop();

        Log.d(TAG, "Entered onStop of SecondActivity");

    }

    //onDestroy callback

    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "Entered on Destroy of SecondActivity");
    }







}
