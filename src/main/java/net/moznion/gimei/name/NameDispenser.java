package net.moznion.gimei.name;

public interface NameDispenser {
    String kanji();

    String hiragana();

    String katakana();

    NameUnit last();

    NameUnit first();

    boolean isMale();

    boolean isFemale();
}
