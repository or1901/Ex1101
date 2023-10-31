package com.example.ex1101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    String text;
    int counter;
    TextView counterTv;
    EditText eT;
    SharedPreferences savedData;
    SharedPreferences.Editor editor;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTv = (TextView) findViewById(R.id.counterTv);
        eT = (EditText) findViewById(R.id.eT);

        savedData = (SharedPreferences) getSharedPreferences("PREFS_DATA", MODE_PRIVATE);
        editor = savedData.edit();

        // Reads from the file the saved values and displays them
        text = savedData.getString("userText", "");
        eT.setText(text);
        counter = savedData.getInt("counterValue", 0);
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

    /**
     * This function saves the text data and the counter value to the shared preferences file and
     * exits the app.
     * <p>
     *
     * @param view The button clicked to save and exit the app.
     */
    public void exit(View view) {
        text = eT.getText().toString();

        editor.putString("userText", text);
        editor.putInt("counterValue", counter);
        editor.commit();

        finish();
    }

    /**
     * This function presents the options menu for moving between activities.
     * <p>
     *
     * @param menu The options menu in which you place your items.
     * @return true in order to show the menu, otherwise false.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This function reacts to the user choice in the options menu - it moves to the chosen
     * activity from the menu.
     * <p>
     *
     * @param item The menu item that was selected.
     * @return Must return true for the menu to react.
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();

        if(id == R.id.menuCredits){
            si = new Intent(this, CreditsActivity.class);
            startActivity(si);
        }

        return super.onOptionsItemSelected(item);
    }
}