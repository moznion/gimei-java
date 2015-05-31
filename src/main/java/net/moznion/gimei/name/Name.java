package net.moznion.gimei.name;

import java.util.Random;

public class Name implements NameSuppliable {
    private final NameSuppliable nameSuppliable;

    public Name() {
        Random rand = new Random();

        // Branch male or female
        if (rand.nextBoolean()) {
            nameSuppliable = new Male();
        } else {
            nameSuppliable = new Female();
        }
    }

    public String kanji() {
        return nameSuppliable.kanji();
    }

    public String hiragana() {
        return nameSuppliable.hiragana();
    }

    public String katakana() {
        return nameSuppliable.katakana();
    }

    public NameUnit last() {
        return nameSuppliable.last();
    }

    public NameUnit first() {
        return nameSuppliable.first();
    }

    public boolean isMale() {
        return nameSuppliable.isMale();
    }

    public boolean isFemale() {
        return nameSuppliable.isFemale();
    }
}
