package com.scheffer.erik.androidjokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA_ID = "joke-id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        ((TextView) findViewById(R.id.joke_text)).setText(getIntent().getStringExtra(JOKE_EXTRA_ID));
    }
}
