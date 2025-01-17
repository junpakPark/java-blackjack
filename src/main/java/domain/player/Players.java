package domain.player;

import domain.card.Deck;
import util.HitOrStay;
import util.Notice;

import java.util.List;

public class Players {

    private final Dealer dealer;
    private final Participants participants;

    private Players(final Dealer dealer, final Participants participants) {
        this.dealer = dealer;
        this.participants = participants;
    }

    public static Players of(final List<Participant> participants) {
        return new Players(Dealer.create(), Participants.of(participants));
    }

    public void drawCards(final Deck deck) {
        dealer.takeCard(deck.dealCard());
        dealer.takeCard(deck.dealCard());

        participants.takeCard(deck);
        participants.takeCard(deck);
    }

    public void playParticipantsTurn(final Deck deck, final HitOrStay hitOrStay, final Notice<Participant> participantNotice, final Notice<Boolean> dealerNotice) {
        participants.playParticipantsTurn(deck, hitOrStay, participantNotice);
        dealer.playDealerTurn(deck, dealerNotice);
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Participant> getParticipants() {
        return participants.getParticipants();
    }
}
