package com.htdwps.jokescreatorlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokes extends AppCompatActivity {

    Intent intent;
    TextView tvJokeView;
    String jokesText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);

        tvJokeView = findViewById(R.id.tv_jokes_text);

        intent = getIntent();

        jokesText = intent.getStringExtra(getResources().getString(R.string.jokes_private_key));

        if (jokesText != null) {
            tvJokeView.setText(jokesText);
        } else {
            tvJokeView.setText("The default joke is a silly one");
        }

    }
}
