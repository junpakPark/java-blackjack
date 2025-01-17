package domain.card;

public enum Suit {

    SPADE("스페이드"),
    DIAMOND("다이아몬드"),
    HEARTS("하트"),
    CLUBS("클로버");

    private final String name;

    Suit(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
