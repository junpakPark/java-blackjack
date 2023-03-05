package view;

import domain.card.Card;
import domain.game.Results;
import domain.player.Participant;

import java.util.List;

import static java.util.stream.Collectors.*;

public final class OutputView {

    private static final String DELIMITER = ", ";

    public void printSetupGame(final List<String> names) {
        final String participants = String.join(DELIMITER, names);
        System.out.printf("%n딜러와 %s에게 2장을 나누었습니다.%n", participants);
    }

    public void printDealerCard(Card card) {
        System.out.printf("딜러 : %s%s%n", card.getRank().getSymbol(), card.getSuit());
    }

    public void printPlayerCards(final List<Participant> participants) {
        participants.forEach(
                participant -> System.out.printf(
                        "%s 카드: %s%n", participant.getName(), convertCardsFormat(participant.getCards())
                ));
    }

    public void printPlayerCard(final Participant participant) {
        System.out.printf(
                "%s 카드: %s%n", participant.getName(), convertCardsFormat(participant.getCards())
        );
    }

    public void printHitOrStay(final boolean isHit) {
        System.out.println(hitOrStay(isHit));
    }

    public void printPlayerScore(final String name, final List<Card> cards, final int playerScore) {
        final String playerCards = convertCardsFormat(cards);
        System.out.printf("%s 카드: %s - 결과: %d%n", name, playerCards, playerScore);

    }
//
//    public static void printGameResult(final Results results) {
//        System.out.println("## 최종 승패");
//        System.out.printf("딜러: %d승 %d패%n", results.countLosers(), results.countWinners());
//
//        results.getWinners().forEach(winner -> System.out.printf("%s: 승%n", winner));
//        results.getLosers().forEach(loser -> System.out.printf("%s: 패%n", loser));
//    }

    public void printExceptionMessage(final String message) {
        System.out.println(message);
    }

    private String convertCardsFormat(final List<Card> cards) {
        return cards.stream().map(card -> String.format("%s%s", card.getRank().getSymbol(), card.getSuit())).collect(joining(DELIMITER));
    }

    private String hitOrStay(final boolean isHit) {
        if (isHit) {
            return "딜러의 총점은 16 이하라 한장의 카드를 더 받았습니다.";
        }
        return "딜러의 총점은 17 이상입니다. 게임을 종료합니다." + System.lineSeparator();
    }
}
