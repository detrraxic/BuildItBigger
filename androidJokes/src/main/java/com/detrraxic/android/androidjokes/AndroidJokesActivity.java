/*
 * Created by Dusan Stankovic on 1/10/17 11:42 AM
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 1/10/17 11:42 AM
 */

package com.detrraxic.android.androidjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidJokesActivity extends AppCompatActivity {

    public static final String JOKE_TAG = AndroidJokesActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_joke_activity_main);

        Intent jokeIntent = getIntent();
        String joke = jokeIntent.getStringExtra(JOKE_TAG);
        TextView jokeTextView = (TextView) findViewById(R.id.joke_textview);
        jokeTextView.setText(joke);
    }
}
