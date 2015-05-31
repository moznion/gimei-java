package net.moznion.gimei.name;

import java.util.List;
import java.util.Random;

public class Male implements NameSuppliable {
    private final NameUnit firstName;
    private final NameUnit lastName;
    private final static boolean IS_MALE = true;
    private final static boolean IS_FEMALE = false;

    public Male() {
        NameDataSupplier.NameData nameData = NameDataSupplier.NAME_DATA;

        Random rand = new Random();

        // Randomly pickup a first name
        final List<NameUnit> firstNames = nameData.getFirstName().getMale();
        firstName = firstNames.get(rand.nextInt(firstNames.size()));

        // Randomly pickup a last name
        final List<NameUnit> lastNames = nameData.getLastName();
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
        return IS_MALE;
    }

    public boolean isFemale() {
        return IS_FEMALE;
    }
}
