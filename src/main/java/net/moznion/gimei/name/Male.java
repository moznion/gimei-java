package net.moznion.gimei.name;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.moznion.gimei.NameUnit;

import java.util.List;
import java.util.Random;

/**
 * ランダムな男性名を供給するクラス.
 */
@EqualsAndHashCode
@ToString
public class Male implements NameSuppliable {
    private final NameUnit firstName;
    private final NameUnit lastName;
    private final static Gender GENDER = Gender.MALE;

    /**
     * ランダムな男性名を生成する.
     */
    public Male() {
        this(new Random());
    }

    /**
     * シードに基いてランダムな男性名を生成する.
     *
     * @param seed 乱数を生成する為に使うシード
     */
    public Male(long seed) {
        this(new Random(seed));
    }

    /**
     * {@link Random}に基いてランダムな男性名を生成する.
     *
     * @param rand 乱数生成器
     */
    public Male(Random rand) {
        NameDataSupplier.NameData nameData = NameDataSupplier.getNameData();

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
