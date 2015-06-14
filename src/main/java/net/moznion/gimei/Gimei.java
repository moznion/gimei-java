package net.moznion.gimei;

import net.moznion.gimei.address.Address;
import net.moznion.gimei.name.Female;
import net.moznion.gimei.name.Hanako;
import net.moznion.gimei.name.Male;
import net.moznion.gimei.name.Name;
import net.moznion.gimei.name.Taro;
import net.moznion.gimei.noun.Noun;

/**
 * 各種インスタンスを供給するクラス.
 */
public class Gimei {
    /**
     * {@link Name}のインスタンスを返す.
     *
     * @return {@link Name}のインスタンス
     */
    public static Name generateName() {
        return new Name();
    }

    /**
     * {@link Name}のインスタンスを返す.
     *
     * @param seed 乱数生成の為のseed
     * @return {@link Name}のインスタンス
     */
    public static Name generateName(long seed) {
        return new Name(seed);
    }

    /**
     * {@link Male}のインスタンスを返す.
     *
     * @return {@link Male}のインスタンス
     */
    public static Male generateMale() {
        return new Male();
    }

    /**
     * {@link Male}のインスタンスを返す.
     *
     * @param seed 乱数生成の為のseed
     * @return {@link Male}のインスタンス
     */
    public static Male generateMale(long seed) {
        return new Male(seed);
    }

    /**
     * {@link Female}のインスタンスを返す.
     *
     * @return {@link Female}のインスタンス
     */
    public static Female generateFemale() {
        return new Female();
    }

    /**
     * {@link Female}のインスタンスを返す.
     *
     * @param seed 乱数生成の為のseed
     * @return {@link Female}のインスタンス
     */
    public static Female generateFemale(long seed) {
        return new Female(seed);
    }

    /**
     * {@link Taro}のインスタンスを返す.
     *
     * @return {@link Taro}のインスタンス
     */
    public static Taro generateTaro() {
        return new Taro();
    }

    /**
     * {@link Taro}のインスタンスを返す.
     *
     * @param seed 乱数生成の為のseed
     * @return {@link Taro}のインスタンス
     */
    public static Taro generateTaro(long seed) {
        return new Taro(seed);
    }

    /**
     * {@link Hanako}のインスタンスを返す.
     *
     * @return {@link Hanako}のインスタンス
     */
    public static Hanako generateHanako() {
        return new Hanako();
    }

    /**
     * {@link Hanako}のインスタンスを返す.
     *
     * @param seed 乱数生成の為のseed
     * @return {@link Hanako}のインスタンス
     */
    public static Hanako generateHanako(long seed) {
        return new Hanako(seed);
    }

    /**
     * {@link Address}のインスタンスを返す.
     *
     * @return {@link Address}のインスタンス
     */
    public static Address generateAddress() {
        return new Address();
    }

    /**
     * {@link Address}のインスタンスを返す.
     *
     * @param seed 乱数生成の為のseed
     * @return {@link Address}のインスタンス
     */
    public static Address generateAddress(long seed) {
        return new Address(seed);
    }

    /**
     * {@link Noun}のインスタンスを返す.
     *
     * @return {@link Noun}のインスタンス
     */
    public static Noun generateNoun() {
        return new Noun();
    }

    /**
     * {@link Noun}のインスタンスを返す.
     *
     * @param seed 乱数生成の為のseed
     * @return {@link Noun}のインスタンス
     */
    public static Noun generateNoun(long seed) {
        return new Noun(seed);
    }
}
