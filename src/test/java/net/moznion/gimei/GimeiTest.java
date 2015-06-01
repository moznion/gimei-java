package net.moznion.gimei;

import lombok.extern.slf4j.Slf4j;
import net.moznion.gimei.address.Address;
import net.moznion.gimei.name.Female;
import net.moznion.gimei.name.Hanako;
import net.moznion.gimei.name.Male;
import net.moznion.gimei.name.Name;
import net.moznion.gimei.name.Taro;
import net.moznion.gimei.noun.Noun;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class GimeiTest {
	@Test
	public void testForName() {
		final Name name = Gimei.generateName();

		final boolean isMale = name.isMale();
		assertEquals(!isMale, name.isFemale());

		final NameUnit first = name.first();
		final NameUnit last = name.last();

		final String kanji = name.kanji();
		assertEquals(last.kanji() + " " + first.kanji(), kanji);
		log.info(kanji);

		final String hiragana = name.hiragana();
		assertEquals(last.hiragana() + " " + first.hiragana(), hiragana);
		log.info(hiragana);

		final String katakana = name.katakana();
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

		final String kanji = male.kanji();
		assertEquals(last.kanji() + " " + first.kanji(), kanji);
		log.info(kanji);

		final String hiragana = male.hiragana();
		assertEquals(last.hiragana() + " " + first.hiragana(), hiragana);
		log.info(hiragana);

		final String katakana = male.katakana();
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

		final String kanji = female.kanji();
		assertEquals(last.kanji() + " " + first.kanji(), kanji);
		log.info(kanji);

		final String hiragana = female.hiragana();
		assertEquals(last.hiragana() + " " + first.hiragana(), hiragana);
		log.info(hiragana);

		final String katakana = female.katakana();
		assertEquals(last.katakana() + " " + first.katakana(), katakana);
		log.info(katakana);
	}

	@Test
	public void testForTaro() {
		final Taro taro = Gimei.generateTaro();

		assertEquals(taro.isMale(), true);
		assertEquals(taro.isFemale(), false);

		final NameUnit first = taro.first();
		final NameUnit last = taro.last();

		assertEquals("太郎", first.kanji());
		assertEquals("たろう", first.hiragana());
		assertEquals("タロウ", first.katakana());

		final String kanji = taro.kanji();
		assertEquals(last.kanji() + " 太郎", kanji);
		log.info(kanji);

		final String hiragana = taro.hiragana();
		assertEquals(last.hiragana() + " たろう", hiragana);
		log.info(hiragana);

		final String katakana = taro.katakana();
		assertEquals(last.katakana() + " タロウ", katakana);
		log.info(katakana);
	}

	@Test
	public void testForHanako() {
		final Hanako hanako = Gimei.generateHanako();

		assertEquals(hanako.isMale(), false);
		assertEquals(hanako.isFemale(), true);

		final NameUnit first = hanako.first();
		final NameUnit last = hanako.last();

		assertEquals("花子", first.kanji());
		assertEquals("はなこ", first.hiragana());
		assertEquals("ハナコ", first.katakana());

		final String kanji = hanako.kanji();
		assertEquals(last.kanji() + " 花子", kanji);
		log.info(kanji);

		final String hiragana = hanako.hiragana();
		assertEquals(last.hiragana() + " はなこ", hiragana);
		log.info(hiragana);

		final String katakana = hanako.katakana();
		assertEquals(last.katakana() + " ハナコ", katakana);
		log.info(katakana);
	}

	@Test
	public void testForAddress() {
		final Address address = Gimei.generateAddress();

		final NameUnit prefecture = address.prefecture();
		final NameUnit city = address.city();
		final NameUnit town = address.town();

		final String kanji = address.kanji();
		log.info(kanji);
		assertEquals(prefecture.kanji() + city.kanji() + town.kanji(), kanji);

		final String hiragana = address.hiragana();
		log.info(hiragana);
		assertEquals(prefecture.hiragana() + city.hiragana() + town.hiragana(), hiragana);

		final String katakana = address.katakana();
		log.info(katakana);
		assertEquals(prefecture.katakana() + city.katakana() + town.katakana(), katakana);
	}

	@Test
	public void testForNoun() {
		final Noun noun = Gimei.generateNoun();
		log.info(noun.kanji());
		log.info(noun.hiragana());
		log.info(noun.katakana());
		assertTrue(true); // XXX
	}
}
