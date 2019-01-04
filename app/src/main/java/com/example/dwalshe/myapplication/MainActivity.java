package com.example.dwalshe.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// Author:  David Walshe
// Date:    04/01/2019
// Simple Training app to learn basics in android layout and java code.
// App contents user input via text entry and button clicks, data display, bundle saving and
// restoration.


public class MainActivity extends AppCompatActivity {

    // Log Tag
    private static final String TAG = "MainActivity";
    // CONSTANTS
    private static final String TEXT_CONTENTS = "TextContents";
    private static final String COUNTER_CONTENTS = "CounterContents";
    // Layout Variable Declaration
    private EditText userInput;
    private TextView textView;
    private TextView counterView;
    // Global Variable Declaration
    private Integer numTimesClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Layout Variable Assignment
        userInput = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        counterView = findViewById(R.id.counterView);


        // Global Variable init
        numTimesClicked = 0;
        textView.setText("");


        textView.setMovementMethod(new ScrollingMovementMethod());      //Add scroll to textView

        // Button Click Listener
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numTimesClicked++;
                counterView.setText(numTimesClicked.toString());
                String result = userInput.getText().toString() + "\n";
                userInput.setText("");
                textView.append(result);
            }
        };
        button.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out");
    }


    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        numTimesClicked = savedInstanceState.getInt(COUNTER_CONTENTS);
        counterView.setText(numTimesClicked.toString());
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, "onDestroy: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        outState.putInt(COUNTER_CONTENTS, numTimesClicked);
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }
}
