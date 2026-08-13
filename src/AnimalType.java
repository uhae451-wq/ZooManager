public enum AnimalType {
    DOG("개"),
    CAT("고양이"),
    BIRD("새");

    private final String displayName;

    AnimalType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
