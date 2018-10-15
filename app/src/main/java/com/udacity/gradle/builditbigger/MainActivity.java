package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.htdwps.jokescreatorlibrary.DisplayJokes;
import com.htdwps.lib.Jokes;


public class MainActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void tellJoke(View view) {
//        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();

        // Get a joke from Jokes class
        Jokes jokes = new Jokes();
//        Toast.makeText(this, jokes.getJoke(), Toast.LENGTH_SHORT).show();

        Intent jokeIntent = new Intent(this, DisplayJokes.class);

        // Add the joke as a string
        jokeIntent.putExtra(getString(R.string.jokes_private_key), jokes.getJoke());

        startActivity(jokeIntent);

    }


}
