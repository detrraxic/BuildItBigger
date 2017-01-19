/*
 * Created by Dusan Stankovic on 1/10/17 12:03 PM
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 1/10/17 12:03 PM
 */

package com.detrraxic.android.backend;

/**
 * The object model for the data we are sending through endpoints
 */
class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}