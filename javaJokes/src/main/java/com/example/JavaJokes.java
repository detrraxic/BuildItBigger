/*
 * Created by Dusan Stankovic on 1/10/17 11:29 AM
 * Copyright (c) 2017. All rights reserved.
 *
 * Last modified 1/10/17 11:29 AM
 */

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaJokes {

    private final Random randomJokeGenerator;
    private final List<String> jokes;
    private String joke;

    public JavaJokes() {

        jokes = new ArrayList<>();
        randomJokeGenerator = new Random();

        jokes.add("Q: What happens to a frog's car when it breaks down?\n" +
                "A: It gets toad away.");
        jokes.add("Q: What did the duck say when he bought lipstick?\n" +
                "A: \"Put it on my bill.\"");
        jokes.add("Q: Why was six scared of seven? \n" +
                "A: Because seven \"ate\" nine.");
        jokes.add("Q: Is Google male or female? \n" +
                "A: Female, because it doesn't let you finish a sentence before making a suggestion.");
        jokes.add("Q: Why did the witches' team lose the baseball game? \n" +
                "A: Their bats flew away.");
        jokes.add("Q: Did your hear about the man with a broken left arm and broken left leg?\n" +
                "A: Don't worry he's \"ALRIGHT\" now!");
        jokes.add("Q: What is the tallest building in the entire world? \n" +
                "A: The library, because it has so many stories.");
        jokes.add("Q: Why can't you trust an atom? \n" +
                "A: Because they make up everything.");
        jokes.add("Q: How do trees access the internet? \n" +
                "A: They log in.");
        jokes.add("Q: What did the big chimney say to the little chimney? \n" +
                "A: \"You're too young to smoke.\"");
    }

    public void setJoke() {
        int index = randomJokeGenerator.nextInt(jokes.size());
        joke = jokes.get(index);
    }

    public String getJoke() {
        return joke;
    }
}
