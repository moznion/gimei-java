package net.moznion.gimei.name;

import java.util.List;
import java.util.Random;

public class Male implements NameDispenser {
    private final NameUnit firstName;
    private final NameUnit lastName;
    private final static boolean isMale = true;
    private final static boolean isFemale = false;

    public Male() {
        NameData.NameYAML nameYAML = NameData.nameYAML;

        Random rand = new Random();

        // Randomly pickup a first name
        final List<NameUnit> firstNames = nameYAML.getFirstName().getMale();
        firstName = firstNames.get(rand.nextInt(firstNames.size()));

        // Randomly pickup a last name
        final List<NameUnit> lastNames = nameYAML.getLastName();
        lastName = lastNames.get(rand.nextInt(lastNames.size()));
    }

    public String kanji() {
        return lastName.kanji() + " " + firstName.kanji();
    }

    public String hiragana() {
        return lastName.hiragana() + " " + firstName.hiragana();
    }

    public String katakana() {
        return lastName.katakana() + " " + firstName.katakana();
    }

    public NameUnit last() {
        return lastName;
    }

    public NameUnit first() {
        return firstName;
    }

    public boolean isMale() {
        return isMale;
    }

    public boolean isFemale() {
        return isFemale;
    }
}
