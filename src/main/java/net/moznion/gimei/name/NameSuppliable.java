package net.moznion.gimei.name;

import net.moznion.gimei.GimeiSuppliable;
import net.moznion.gimei.NameUnit;

public interface NameSuppliable extends GimeiSuppliable {
	NameUnit last();

	NameUnit first();

	boolean isMale();

	boolean isFemale();
}
