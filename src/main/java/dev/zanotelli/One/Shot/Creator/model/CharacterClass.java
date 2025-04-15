package dev.zanotelli.One.Shot.Creator.model;

public enum CharacterClass {
    BARBARIAN("barbarian"),
    BARD("bard"),
    CLERIC("cleric"),
    DRUID("druid"),
    FIGHTER("fighter"),
    MONK("monk"),
    PALADIN("paladin"),
    RANGER("ranger"),
    ROGUE("rogue"),
    SORCERER("sorcerer"),
    WARLOCK("warlock"),
    WIZARD("wizard"),
    ;

    private final String characterClass;

    CharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getCharacterClass() {
        return characterClass;
    }
}
