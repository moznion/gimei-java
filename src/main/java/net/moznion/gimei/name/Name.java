package net.moznion.gimei.name;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.moznion.gimei.NameUnit;

import java.util.Random;

/**
 * ランダムな人名を供給するクラス.
 */
@EqualsAndHashCode
@ToString
public class Name implements NameSuppliable {
    private final NameSuppliable nameSuppliable;

    /**
     * ランダムな人名を生成する.
     */
    public Name() {
        this(new Random());
    }

    /**
     * シードに基いてランダムな人名を生成する.
     *
     * @param seed 乱数を生成する為に使うシード
     */
    public Name(long seed) {
        this(new Random(seed));
    }

    /**
     * {@link Random}に基いてランダムな人名を生成する.
     *
     * @param rand 乱数生成器
     */
    public Name(Random rand) {
        // Branch male or female
        if (rand.nextBoolean()) {
            nameSuppliable = new Male(rand);
        } else {
            nameSuppliable = new Female(rand);
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
