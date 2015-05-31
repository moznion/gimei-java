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

    @Override
    public String kanji() {
        return nameSuppliable.kanji();
    }

    @Override
    public String hiragana() {
        return nameSuppliable.hiragana();
    }

    @Override
    public String katakana() {
        return nameSuppliable.katakana();
    }

    @Override
    public NameUnit last() {
        return nameSuppliable.last();
    }

    @Override
    public NameUnit first() {
        return nameSuppliable.first();
    }

    @Override
    public boolean isMale() {
        return nameSuppliable.isMale();
    }

    @Override
    public boolean isFemale() {
        return nameSuppliable.isFemale();
    }
}
