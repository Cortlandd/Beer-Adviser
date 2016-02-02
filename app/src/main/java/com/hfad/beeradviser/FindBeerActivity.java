package com.hfad.beeradviser;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // If method doesn't have this button, the button won't respond when the user touches it.
    public void onClickFindBeer(View view) {
        // R._._ is a Java file and it keeps track of the resources used within the app.

        // Get reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        // Get reference to Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        // Get the selected item
        // Retrieve the currently selected item in the spinner.
        String beerType = String.valueOf(color.getSelectedItem());

        // Display the selected item
        // brands.setText(beerType);

        // Get recommendations from the BeerExpert class
        List<String> brandList = expert.getBrands(beerType); // Get a list of brands

        StringBuilder brandsFormatted = new StringBuilder(); // Build a string using the values in the list

        for (String brand : brandList) {
            brandsFormatted.append(brand).append('\n'); // Display each brand on a new line
        }

        // Display the beers
        brands.setText(brandsFormatted); // Display the results in the text view
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_find_beer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
