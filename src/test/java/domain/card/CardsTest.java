package domain.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CardsTest {
    @Test
    @DisplayName("getCards하면 입력받은 카드 전부를 리스트로 반환한다.")
    void getCardsTest() {
        //given
        final Cards cards = Cards.from(0);

        final List<Rank> ranks = List.of(Rank.EIGHT, Rank.SIX, Rank.SEVEN);
        final Deck deck = Deck.from(TestCardGenerator.from(ranks));

        //when
        ranks.forEach(i -> cards.takeCard(deck.dealCard()));
        final List<Card> result =
                List.of(Card.of(Suit.CLUBS, Rank.EIGHT), Card.of(Suit.CLUBS, Rank.SIX), Card.of(Suit.CLUBS, Rank.SEVEN));

        //then
        assertThat(cards.getCards()).isEqualTo(result);
    }

    @Test
    @DisplayName("한장의 카드가 주어지면 카드 랭크만큼의 스코어를 리턴한다.")
    void givenCard_thenSumScore() {
        //given
        final Cards cards = Cards.from(0);

        //when
        final Card spadeEight = Card.of(Suit.SPADE, Rank.EIGHT);
        cards.takeCard(spadeEight);

        //then
        assertThat(cards.getScore())
                .isEqualTo(Score.from(8));
    }

    @Test
    @DisplayName("여러장의 카드를 받으면, 카드 랭크만큼의 합만큼 스코어를 리턴한다")
    void takeCards_thenAddSum() {
        //given
        final Cards cards = Cards.from(0);

        final List<Rank> ranks = List.of(Rank.FIVE, Rank.SIX, Rank.SEVEN);
        final Deck deck = Deck.from(TestCardGenerator.from(ranks));

        //when
        ranks.forEach(i -> cards.takeCard(deck.dealCard()));

        //then
        assertThat(cards.getScore()).isEqualTo(Score.from(5 + 6 + 7));
    }


    @Nested
    @DisplayName("ace를 뽑았을 때,")
    class IsSoftTest {
        @Test
        @DisplayName("점수 총합이 11이하면 ace의 값을 11로 계산한다")
        void givenAceAndUnderElevenScore_thenAceScoreEleven() {
            //given
            final Cards cards = Cards.from(0);

            //when
            final List<Rank> ranks = List.of(Rank.ACE, Rank.TWO, Rank.THREE);
            final Deck deck = Deck.from(TestCardGenerator.from(ranks));

            ranks.forEach(i -> cards.takeCard(deck.dealCard()));


            //then
            assertThat(cards.getScore())
                    .isEqualTo(Score.from(11 + 2 + 3));
        }

        @Test
        @DisplayName("점수 총합이 12이상이면 ace의 값을 1로 계산한다")
        void givenAceAndOverTwelveScore_thenAceScoreOne() {
            //given
            final Cards cards = Cards.from(0);

            //when
            final List<Rank> ranks = List.of(Rank.ACE, Rank.FIVE, Rank.SIX);
            final Deck deck = Deck.from(TestCardGenerator.from(ranks));
            ranks.forEach(i -> cards.takeCard(deck.dealCard()));


            //then
            assertThat(cards.getScore()).isEqualTo(Score.from(1 + 5 + 6));
        }
    }
}
