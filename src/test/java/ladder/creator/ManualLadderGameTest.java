package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderGame;
import ladder.LadderGameFactory;
import ladder.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ManualLadderGameTest {

    @Test
    @DisplayName("수동 사다리 생성 확인")
    void manual_ladder_creation_check() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        // when
        LadderGame ladderGame = LadderGameFactory.createManualLadderGame(numberOfRow, numberOfPerson);

        // then
        assertThat(ladderGame).isNotNull();
    }

    @Test
    @DisplayName("수동 사다리 예외 처리 확인")
    void manual_ladder_exception_check() {
        // given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderGame ladderGame = LadderGameFactory.createManualLadderGame(GreaterThanOne.from(2), numberOfPerson);

        // then
        Position position = Position.from(4);
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동 사다리 결과 확인")
    void manual_ladder_result_check() {
        // given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderGame ladderGame = LadderGameFactory.createManualLadderGame(row, numberOfPerson);

        // when: 수동으로 선을 그려줌
        ladderGame.getLadderCreator().drawLine(Position.from(0), Position.from(0));
        ladderGame.getLadderCreator().drawLine(Position.from(1), Position.from(1));
        ladderGame.getLadderCreator().drawLine(Position.from(2), Position.from(0));

        // then
        Position position = Position.from(0);
        assertThat(ladderGame.run(position)).isEqualTo(2);

        position = Position.from(1);
        assertThat(ladderGame.run(position)).isEqualTo(1);

        position = Position.from(2);
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }
}
