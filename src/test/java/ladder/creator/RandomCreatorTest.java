package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.LadderGameFactory;
import ladder.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomCreatorTest {

    @Test
    @DisplayName("자동 사다리 생성 확인")
    void random_ladder_creation_check() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        // when
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(numberOfRow, numberOfPerson);

        // then
        assertThat(ladderGame).isNotNull();
    }

    @Test
    @DisplayName("자동 사다리 예외 처리 확인")
    void random_ladder_exception_check() {
        // given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);

        // when
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(GreaterThanOne.from(2), numberOfPerson);

        // then
        Position position = Position.from(4);
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동 사다리 결과 확인")
    void random_ladder_result_check() {
        // given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(8);
        GreaterThanOne row = GreaterThanOne.from(8);

        // when
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(row, numberOfPerson);

        // then
        Position position = Position.from(0);
        assertThat(ladderGame.run(position)).isNotNull();
    }
}
