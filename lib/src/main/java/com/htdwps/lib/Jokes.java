package com.htdwps.lib;

import java.util.Random;

public class Jokes {

    private Random random = new Random();

    // Jokes were pulled from http://redtri.com/best-jokes-for-kids/slide/2
    private String[] jokesArray = {

            "What do you call a dinosaur that is sleeping?\n" + "\n" + "A dino-snore!",
            "What is fast, loud and crunchy?\n" + "\n" + "A rocket chip!",
            "Why did the teddy bear say no to dessert?\n" + "\n" + "Because she was stuffed.",
            "What did the left eye say to the right eye?\n" + "\n" + "Between us, something smells!",
            "What did one plate say to the other plate?\n" + "\n" + "Dinner is on me!",
            "What is brown, hairy and wears sunglasses?\n" + "\n" + "A coconut on vacation.",
            "What did the Dalmatian say after lunch?\n" + "\n" + "That hit the spot!",
            "Two pickles fell out of a jar onto the floor. What did one say to the other?\n" + "\n" + "Dill with it.",
            "How do you stop an astronaut’s baby from crying?\n" + "\n" + "You rocket!",
            "What is a witch’s favorite subject in school?\n" + "\n" + "Spelling!",
            "How do you make a lemon drop?\n" + "\n" + "Just let it fall.",
            "What kind of water cannot freeze?\n" + "\n" + "Hot water.",
            "Why does a seagull fly over the sea?\n" + "\n" + "Because if it flew over the bay, it would be a baygull.",
            "What did the limestone say to the geologist?\n" + "\n" + "Don’t take me for granite!",
            "What did the little corn say to the mama corn?\n" + "\n" + "Where is pop corn?",
            "What is worse than raining cats and dogs?\n" + "\n" + "Hailing taxis!"

    };

    public String getJoke() {

        return jokesArray[random.nextInt(jokesArray.length)];

    }
}
