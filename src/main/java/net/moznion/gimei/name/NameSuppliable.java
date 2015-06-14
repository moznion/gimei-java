package net.moznion.gimei.name;

import net.moznion.gimei.GimeiSuppliable;
import net.moznion.gimei.NameUnit;

/**
 * 基本的な人名情報を供給する.
 */
public interface NameSuppliable extends GimeiSuppliable {
    /**
     * 名を返す.
     *
     * @return 名
     */
    NameUnit last();

    /**
     * 姓を返す.
     *
     * @return 姓
     */
    NameUnit first();

    /**
     * 男性かどうかを返す.
     *
     * @return 男性かどうか
     */
    boolean isMale();

    /**
     * 女性かどうかを返す.
     *
     * @return 女性かどうか
     */
    boolean isFemale();
}
