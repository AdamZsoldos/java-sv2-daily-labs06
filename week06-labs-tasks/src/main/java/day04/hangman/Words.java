package day04.hangman;

import java.util.Random;

public enum Words {
    APPLE,
    PEARS,
    ORANGE,
    YELLOW,
    JACKET,
    WASPS,
    ORANGUTAN,
    CHIMPANZEE,
    LENGTH,
    WIDTH,
    DEPTH;

    public static String getRandomWord(Random random) {
        return Words.values()[random.nextInt(Words.values().length)].name().toLowerCase();
    }
}
