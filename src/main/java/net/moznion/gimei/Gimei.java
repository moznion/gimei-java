package net.moznion.gimei;

import net.moznion.gimei.name.Female;
import net.moznion.gimei.name.Male;
import net.moznion.gimei.name.Name;

public class Gimei {
    public static Name generateName() {
        return new Name();
    }

    public static Male generateMale() {
        return new Male();
    }

    public static Female generateFemale() {
        return new Female();
    }
}
