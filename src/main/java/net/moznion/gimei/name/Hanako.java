package net.moznion.gimei.name;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.moznion.gimei.NameUnit;
import net.moznion.gimei.NounDataSupplier;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * {@code <ランダムな名詞>} + "花子" を女性名として供給するクラス.
 */
@EqualsAndHashCode
@ToString
public class Hanako implements NameSuppliable {
    private final static NameUnit FIRST_NAME = new NameUnit(Arrays.asList("花子", "はなこ", "ハナコ"));
    private final static Gender GENDER = Gender.FEMALE;
    private final NameUnit lastName;

    /**
     * ランダムな花子を生成する.
     */
    public Hanako() {
        this(new Random());
    }

    /**
     * シードに基づいてランダムな花子を生成する.
     *
     * @param seed 乱数を生成する為に使うシード
     */
    public Hanako(long seed) {
        this(new Random(seed));
    }

    /**
     * {@link Random}に基いてランダムな花子を生成する.
     *
     * @param rand 乱数生成器
     */
    public Hanako(Random rand) {
        List<NameUnit> nouns = NounDataSupplier.getNounData().getNouns();
        lastName = nouns.get(rand.nextInt(nouns.size()));
    }

    @Override
    public String kanji() {
        return lastName.kanji() + " " + FIRST_NAME.kanji();
    }

    @Override
    public String hiragana() {
        return lastName.hiragana() + " " + FIRST_NAME.hiragana();
    }

    @Override
    public String katakana() {
        return lastName.katakana() + " " + FIRST_NAME.katakana();
    }

    @Override
    public NameUnit last() {
        return lastName;
    }

    @Override
    public NameUnit first() {
        return FIRST_NAME;
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
