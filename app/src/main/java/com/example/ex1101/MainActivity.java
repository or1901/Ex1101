package com.example.ex1101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Ori Roitzaid <or1901 @ bs.amalnet.k12.il>
 * @version	1
 * @since 31/10/2023
 * The main activity:
 * Displays a counter and a text field, allows the user to change the both of them with buttons.
 * Saves the data when the user exits the app, and loads it again when the app runs.
 */
public class MainActivity extends AppCompatActivity {
    int counter;
    TextView counterTv;
    EditText eT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTv = (TextView) findViewById(R.id.counterTv);
        eT = (EditText) findViewById(R.id.eT);

        counter = 0;
        counterTv.setText("" + counter);
    }

    /**
     * This function increases the counter by one.
     * <p>
     *
     * @param view The button clicked to increment the counter.
     */
    public void count(View view) {
        counter++;
        counterTv.setText("" + counter);

    }

    /**
     * This function resets the counter.
     * <p>
     *
     * @param view The button clicked to reset the counter.
     */
    public void reset(View view) {
        counter = 0;
        counterTv.setText("" + counter);
    }

    public void exit(View view) {
    }
}