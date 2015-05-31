package net.moznion.gimei.name;

import java.util.Random;

public class Name implements NameDispenser {
    private final NameDispenser nameDispenser;

    public Name() {
        Random rand = new Random();

        // Branch male or female
        if (rand.nextBoolean()) {
            nameDispenser = new Male();
        } else {
            nameDispenser = new Female();
        }
    }

    public String kanji() {
        return nameDispenser.kanji();
    }

    public String hiragana() {
        return nameDispenser.hiragana();
    }

    public String katakana() {
        return nameDispenser.katakana();
    }

    public NameUnit last() {
        return nameDispenser.last();
    }

    public NameUnit first() {
        return nameDispenser.first();
    }

    public boolean isMale() {
        return nameDispenser.isMale();
    }

    public boolean isFemale() {
        return nameDispenser.isFemale();
    }
}
