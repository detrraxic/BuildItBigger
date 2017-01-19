/*
 * Created by Dusan Stankovic on 1/18/17 10:40 AM
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 1/18/17 10:40 AM
 */

package com.udacity.gradle.builditbigger;

import android.support.test.annotation.UiThreadTest;
import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class AsyncTaskTest extends AndroidTestCase implements OnTaskCompleted {

    private JokeDownloader mJokeDownloader;
    private CountDownLatch signal;
    private String joke = "";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
        mJokeDownloader = new JokeDownloader(this, null);
    }

    @UiThreadTest
    public void testDownload() throws InterruptedException {
        mJokeDownloader.getJokes();
        signal.await(30, TimeUnit.SECONDS);

        assertTrue("Joke retrieval error!", joke != null);
    }

    @Override
    public void onTaskCompleted(String response) {
        joke = response;
        signal.countDown();
    }
}
