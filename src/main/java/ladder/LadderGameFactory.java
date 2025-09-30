package ladder;

import ladder.creator.LadderManualCreator;
import ladder.creator.LadderRandomCreator;

// 정적 팩토리 매소드 패턴
// 클라이언트 코드 (테스트 & 서비스 코드) 에서 직접 생성자를 호출하지 않도록 감싸줌
// 외부에 의존성이 드러나지 않도록 하고 생성 책임을 Factory가 맡음

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        LadderManualCreator manualCreator = new LadderManualCreator(numberOfRow, numberOfPerson);
        return new LadderGame(new LadderRandomCreator(manualCreator, numberOfRow, numberOfPerson));
    }

    public static LadderGame createManualLadderGame(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        return new LadderGame(new LadderManualCreator(numberOfRow, numberOfPerson));
    }
}
