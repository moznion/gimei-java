package net.moznion.gimei;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 漢字・ひらがなの読み・カタカナの読みを持ったクラス.
 */
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class NameUnit implements GimeiSuppliable {
    private final String kanji;
    private final String hiragana;
    private final String katakana;

    public NameUnit(List<String> data) {
        kanji = data.get(0);
        hiragana = data.get(1);
        katakana = data.get(2);
    }
}
