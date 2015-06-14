package net.moznion.gimei;

/**
 * 漢字・ひらがな読み・カタカナ読み情報を提供する.
 */
public interface GimeiSuppliable {
    /**
     * 漢字の情報を返す.
     *
     * @return 漢字の情報
     */
    String kanji();

    /**
     * ひらがなの読みの情報を返す.
     *
     * @return ひらがな読みの情報
     */
    String hiragana();

    /**
     * カタカナの読みの情報を返す.
     *
     * @return カタカナ読みの情報
     */
    String katakana();
}
