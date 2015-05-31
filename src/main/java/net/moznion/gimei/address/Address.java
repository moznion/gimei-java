package net.moznion.gimei.address;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.moznion.gimei.NameUnit;

import java.util.List;
import java.util.Random;

@Getter
@Accessors(fluent = true)
public class Address {
    private final NameUnit prefecture;
    private final NameUnit city;
    private final NameUnit town;

    public Address() {
        Random rand = new Random();

        AddressDataSupplier.AddressData addressData = AddressDataSupplier.ADDRESS_DATA;

        List<NameUnit> prefectures = addressData.getPrefectures();
        prefecture = prefectures.get(rand.nextInt(prefectures.size()));
        List<NameUnit> cities = addressData.getCities();
        city = cities.get(rand.nextInt(cities.size()));
        List<NameUnit> towns = addressData.getTowns();
        town = towns.get(rand.nextInt(towns.size()));
    }

    public String kanji() {
        return prefecture.kanji() + city.kanji() + town.kanji();
    }

    public String hiragana() {
        return prefecture.hiragana() + city.hiragana() + town.hiragana();
    }

    public String katakana() {
        return prefecture.katakana() + city.katakana() + town.katakana();
    }
}
