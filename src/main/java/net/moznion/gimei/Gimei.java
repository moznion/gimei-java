package net.moznion.gimei;

import net.moznion.gimei.address.Address;
import net.moznion.gimei.name.Female;
import net.moznion.gimei.name.Hanako;
import net.moznion.gimei.name.Male;
import net.moznion.gimei.name.Name;
import net.moznion.gimei.name.Taro;
import net.moznion.gimei.noun.Noun;

public class Gimei {
    public static Name generateName() {
        return new Name();
    }

    public static Name generateName(long seed) {
        return new Name(seed);
    }

    public static Male generateMale() {
        return new Male();
    }

    public static Male generateMale(long seed) {
        return new Male(seed);
    }

    public static Female generateFemale() {
        return new Female();
    }

    public static Female generateFemale(long seed) {
        return new Female(seed);
    }

    public static Taro generateTaro() {
        return new Taro();
    }

    public static Taro generateTaro(long seed) {
        return new Taro(seed);
    }

    public static Hanako generateHanako() {
        return new Hanako();
    }

    public static Hanako generateHanako(long seed) {
        return new Hanako(seed);
    }

    public static Address generateAddress() {
        return new Address();
    }

    public static Address generateAddress(long seed) {
        return new Address(seed);
    }

    public static Noun generateNoun() {
        return new Noun();
    }

    public static Noun generateNoun(long seed) {
        return new Noun(seed);
    }
}
