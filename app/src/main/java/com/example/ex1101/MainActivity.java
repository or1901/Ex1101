package com.example.ex1101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * @author Ori Roitzaid <or1901 @ bs.amalnet.k12.il>
 * @version	1
 * @since 31/10/2023
 * The main activity:
 * Displays a counter and a text field, allows the user to change the both of them with buttons.
 * Saves the data when the user exits the app, and loads it again when the app runs.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}