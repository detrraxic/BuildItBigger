package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.detrraxic.android.androidjokes.AndroidJokesActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnTaskCompleted {

    private String mResult;
    private Button jokeButton;
    private ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        jokeButton = (Button) root.findViewById(R.id.joke_button);
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                loadData();
                launchJokeActivity();
            }
        });

        return root;
    }

    public void loadData() {
        mResult = null;
        JokeDownloader jokeDownloader = new JokeDownloader(this, progressBar);
        jokeDownloader.getJokes();
    }

    @Override
    public void onTaskCompleted(String response) {
        mResult = response;
        launchJokeActivity();
    }

    public void launchJokeActivity() {
        if (mResult != null) {
            Intent intent = new Intent(getActivity(), AndroidJokesActivity.class);
            intent.putExtra(AndroidJokesActivity.JOKE_TAG, mResult);
            startActivity(intent);
        }
    }
}