/*
 * Created by Dusan Stankovic on 1/17/17 11:40 AM
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 1/17/17 11:40 AM
 */

package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.detrraxic.android.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

class JokeDownloader {

    private final OnTaskCompleted listener;
    private final ProgressBar progressBar;
    private MyApi myApiService = null;

    public JokeDownloader(OnTaskCompleted listener, ProgressBar progressBar) {
        this.listener = listener;
        this.progressBar = progressBar;
    }

    public void getJokes() {
        new EndpointsAsyncTask().execute();
    }

    private class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

        private Context context;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected String doInBackground(Void... params) {
            if (myApiService == null) {
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("https://builditbigger-155412.appspot.com/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                myApiService = builder.build();
            }

            try {
                return myApiService.tellJoke().execute().getJoke();
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            listener.onTaskCompleted(result);
            //progressBar.setVisibility(View.GONE);
        }
    }
}