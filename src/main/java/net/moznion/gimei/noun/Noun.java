package net.moznion.gimei.noun;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.moznion.gimei.GimeiSuppliable;
import net.moznion.gimei.NameUnit;
import net.moznion.gimei.NounDataSupplier;

import java.util.List;
import java.util.Random;

@Getter
@Accessors(fluent = true)
public class Noun implements GimeiSuppliable {
	private final NameUnit noun;

	public Noun() {
		Random rand = new Random();

		NounDataSupplier.NounData nounData = NounDataSupplier.getNounData();

		List<NameUnit> nouns = nounData.getNouns();
		noun = nouns.get(rand.nextInt(nouns.size()));
	}

	@Override
	public String kanji() {
		return noun.kanji();
	}

	@Override
	public String hiragana() {
		return noun.hiragana();
	}

	@Override
	public String katakana() {
		return noun.katakana();
	}
}
