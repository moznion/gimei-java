package net.moznion.gimei;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Accessors(fluent = true)
public class NameUnit {
    private final String kanji;
    private final String hiragana;
    private final String katakana;

    public NameUnit(List<String> data) {
        kanji = data.get(0);
        hiragana = data.get(1);
        katakana = data.get(2);
    }
}
