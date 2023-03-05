package domain.player;

import domain.card.Card;
import domain.card.Cards;

import java.util.List;

public abstract class Player {

    private final Name name;
    private final Cards cards;

    Player(final Name name, final Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    public final List<Card> getCards() {
        return cards.getCards();
    }

    public final void takeCard(final Card card) {
        cards.takeCard(card);
    }

    public final int getScore() {
        return cards.getScore();
    }

    public final String getName() {
        return name.getName();
    }
}