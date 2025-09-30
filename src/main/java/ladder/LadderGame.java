package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderManualCreator;
import ladder.creator.LadderRandomCreator;

public class LadderGame {

    // LadderGame의 instance 변수로 LadderCreator 선언
    private final LadderCreator ladderCreator;

    // LadderGame은 사다리를 직접 만들지 않고 LadderCreator에 의존
    // 외부에서 의존성 주입해준다 -> DI
    public LadderGame(LadderCreator ladderCreator){
        this.ladderCreator = ladderCreator;
    }

    public LadderCreator getLadderCreator() {
        return ladderCreator;
    }

    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        ladderRunner.run(position);
        return position.getValue();
    }
}