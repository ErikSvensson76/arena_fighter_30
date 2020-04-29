package se.lexicon.util;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerator {
    public static int generateInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
