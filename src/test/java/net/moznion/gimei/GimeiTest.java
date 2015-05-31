package net.moznion.gimei;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
import net.moznion.gimei.name.Female;
import net.moznion.gimei.name.Male;
import net.moznion.gimei.name.Name;
import net.moznion.gimei.name.NameUnit;
import org.junit.Test;

@Slf4j
public class GimeiTest {
    @Test
    public void testForName() {
        final Name name = Gimei.generateName();

        final boolean isMale = name.isMale();
        log.info("isMale: {}", isMale);
        assertEquals(!isMale, name.isFemale());

        final NameUnit first = name.first();
        final NameUnit last = name.last();

        String kanji = name.kanji();
        assertEquals(last.kanji() + " " + first.kanji(), kanji);
        log.info(kanji);

        String hiragana = name.hiragana();
        assertEquals(last.hiragana() + " " + first.hiragana(), hiragana);
        log.info(hiragana);

        String katakana = name.katakana();
        assertEquals(last.katakana() + " " + first.katakana(), katakana);
        log.info(katakana);
    }

    @Test
    public void testForMale() {
        final Male male = Gimei.generateMale();

        assertEquals(male.isMale(), true);
        assertEquals(male.isFemale(), false);

        final NameUnit first = male.first();
        final NameUnit last = male.last();

        String kanji = male.kanji();
        assertEquals(last.kanji() + " " + first.kanji(), kanji);
        log.info(kanji);

        String hiragana = male.hiragana();
        assertEquals(last.hiragana() + " " + first.hiragana(), hiragana);
        log.info(hiragana);

        String katakana = male.katakana();
        assertEquals(last.katakana() + " " + first.katakana(), katakana);
        log.info(katakana);
    }

    @Test
    public void testForFemale() {
        final Female female = Gimei.generateFemale();

        assertEquals(female.isMale(), false);
        assertEquals(female.isFemale(), true);

        final NameUnit first = female.first();
        final NameUnit last = female.last();

        String kanji = female.kanji();
        assertEquals(last.kanji() + " " + first.kanji(), kanji);
        log.info(kanji);

        String hiragana = female.hiragana();
        assertEquals(last.hiragana() + " " + first.hiragana(), hiragana);
        log.info(hiragana);

        String katakana = female.katakana();
        assertEquals(last.katakana() + " " + first.katakana(), katakana);
        log.info(katakana);
    }
}

