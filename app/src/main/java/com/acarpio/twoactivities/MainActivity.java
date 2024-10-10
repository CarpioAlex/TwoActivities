package com.acarpio.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    static final String TAG = "ONLOGGING";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Entered OnCreate");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);



            return insets;
        });

    }

    // Fetching my text input

;

    // Method that will send you to another activity with an extra

    public void goToActivity(View myView) {
        EditText extraInput = findViewById(R.id.extraInput);
        // The .getText() doesn't get a String so you have to cast it.
        String extra = String.valueOf(extraInput.getText());
        Intent intent = new Intent(this, SecondActivity.class);
        // Ading the extra to the intent:
        // The key will be used to retrieve it in the second activity, and extra is the actual text.
        intent.putExtra("mySuperExtra", extra);
        startActivity(intent);
        finish();
    }


    // https://stackoverflow.com/questions/920306/sending-data-back-to-the-main-activity-in-android/40969871#40969871
    // Method that goes to second activity for result
    public void goToActivityForResult(View myView) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 1);
    }

    // Overriding the onActivityResult callback method

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        String returnString = intent.getStringExtra("result");

        TextView resultText = findViewById(R.id.resultText);
        resultText.setText(returnString);


    }







    // OnStart callback

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, "Entered onStart");

    }

    // OnPause callback

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "Entered onPause");

    }


    //onRestart callback

    @Override
    public void onRestart() {
        super.onRestart();

        Log.d(TAG, "Entered onRestart");

    }


    //onResume callback

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "Entered onResume");

    }

    //onStop callback

    @Override
    public void onStop() {
        super.onStop();

        Log.d(TAG, "Entered onStop");

    }

    //onDestroy callback

    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "Entered on Destroy");
    }


}