package net.moznion.gimei.name;

enum Gender {
    MALE,
    FEMALE;

    public boolean isMale() {
        return this.equals(Gender.MALE);
    }

    public boolean isFemale() {
        return this.equals(Gender.FEMALE);
    }
}
