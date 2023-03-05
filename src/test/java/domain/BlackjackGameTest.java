package domain;

import domain.card.RandomCardGenerator;
import domain.game.BlackjackGame;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BlackjackGameTest {

    @Test
    @DisplayName("중복된 이름이 입력되면, 예외가 발생한다")
    void givenDuplicateName_thenFail() {
        assertThatThrownBy(() -> BlackjackGame.from(List.of("준팍", "준팍", "파워", "파워"), new RandomCardGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 이름만 입력해주세요");
    }

    @Test
    @DisplayName("딜러를 사칭하면, 예외가 발생한다.")
    void giveDealerName_thenFailed() {
        assertThatThrownBy(() -> BlackjackGame.from(List.of("딜러", "준팍", "파워"), new RandomCardGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자의 이름은 딜러가 될 수 없습니다.");
    }

    @Test
    @DisplayName("카드를 뽑으면 덱의 장수가 줄어든다")
    void drawCardTest() {
        //given
        final BlackjackGame blackjackGame = BlackjackGame.from(List.of("준팍", "파워", "범블비", "서브웨이"), new RandomCardGenerator());
        //when
        blackjackGame.drawCard();

        //then
        assertThat(blackjackGame)
                .extracting("deck")
                .extracting("deck", InstanceOfAssertFactories.collection(ArrayDeque.class))
                .hasSize(52 - 10);
    }
}
