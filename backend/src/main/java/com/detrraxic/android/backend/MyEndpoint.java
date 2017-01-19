/*
 * Created by Dusan Stankovic on 1/10/17 12:03 PM
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 1/10/17 12:03 PM
 */

/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.detrraxic.android.backend;

import com.example.JavaJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.android.detrraxic.com",
                ownerName = "backend.android.detrraxic.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and tells a joke
     */
    @ApiMethod(name = "tellJoke")
    public JavaJokes tellJoke() {
        JavaJokes response = new JavaJokes();
        response.setJoke();
        return response;
    }

}
