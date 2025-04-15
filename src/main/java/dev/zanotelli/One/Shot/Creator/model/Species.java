package dev.zanotelli.One.Shot.Creator.model;

public enum Species {
    HUMAN("human"),
    ORC("orc"),
    DWARF("dwarf"),
    ELF("elf"),
    HALFLING("halfling"),
    DRAGONBORN("dragonborn");

    private final String species;

    Species(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }
}
