package net.moznion.gimei.name;

import net.moznion.gimei.NameUnit;

import java.util.List;
import java.util.Random;

public class Male implements NameSuppliable {
    private final NameUnit firstName;
    private final NameUnit lastName;
    private final static Gender GENDER = Gender.MALE;

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

    @Override
    public String kanji() {
        return lastName.kanji() + " " + firstName.kanji();
    }

    @Override
    public String hiragana() {
        return lastName.hiragana() + " " + firstName.hiragana();
    }

    @Override
    public String katakana() {
        return lastName.katakana() + " " + firstName.katakana();
    }

    @Override
    public NameUnit last() {
        return lastName;
    }

    @Override
    public NameUnit first() {
        return firstName;
    }

    @Override
    public boolean isMale() {
        return GENDER.isMale();
    }

    @Override
    public boolean isFemale() {
        return GENDER.isFemale();
    }
}
