package net.moznion.gimei.address;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import net.moznion.gimei.GimeiSuppliable;
import net.moznion.gimei.NameUnit;

import java.util.List;
import java.util.Random;

/**
 * ランダムな住所を供給するクラス.
 */
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class Address implements GimeiSuppliable {
    private final NameUnit prefecture;
    private final NameUnit city;
    private final NameUnit town;

    /**
     * ランダムな住所を生成する.
     */
    public Address() {
        this(new Random());
    }

    /**
     * シードに基いてランダムな住所を生成する.
     *
     * @param seed 乱数を生成する為に使うシード
     */
    public Address(long seed) {
        this(new Random(seed));
    }

    /**
     * {@link Random}に基いてランダムな住所を生成する.
     *
     * @param rand 乱数生成器
     */
    public Address(Random rand) {
        AddressDataSupplier.AddressData addressData = AddressDataSupplier.ADDRESS_DATA;

        List<NameUnit> prefectures = addressData.getPrefectures();
        prefecture = prefectures.get(rand.nextInt(prefectures.size()));
        List<NameUnit> cities = addressData.getCities();
        city = cities.get(rand.nextInt(cities.size()));
        List<NameUnit> towns = addressData.getTowns();
        town = towns.get(rand.nextInt(towns.size()));
    }

    @Override
    public String kanji() {
        return prefecture.kanji() + city.kanji() + town.kanji();
    }

    @Override
    public String hiragana() {
        return prefecture.hiragana() + city.hiragana() + town.hiragana();
    }

    @Override
    public String katakana() {
        return prefecture.katakana() + city.katakana() + town.katakana();
    }
}
