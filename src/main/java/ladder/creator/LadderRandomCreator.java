package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;

public class LadderRandomCreator implements LadderCreator {

    private final LadderManualCreator manualCreator; // 조합
    LadderSize ladderSize;
    Random random = new Random();

    // 생성자 overloading
    public LadderRandomCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this(new LadderManualCreator(numberOfRow, numberOfPerson), numberOfRow, numberOfPerson);
    }

    // private final 변수 추가 -> 초기화 해주는 방식으로
    public LadderRandomCreator(LadderManualCreator manualCreator, GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.manualCreator = manualCreator;
        ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        makeLinesSet(numberOfRow,numberOfPerson);
    }

    @Override
    public Row[] getRows() {
        return manualCreator.getRows();
    }

    @Override
    public boolean drawLine(Position row, Position col) {
        // return rows[row.getValue()].drawLine(col);
        return manualCreator.drawLine(row, col);
    }

    public void makeLinesSet(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {

        HashSet<LadderPosition> lineCount = new HashSet<>();
        LadderPosition ladderPos;

        while (lineCount.size() != ladderSize.getNumberOfRandomLine()) {

            int rowIndex = random.nextInt(numberOfRow.getNumber());
            int columnIndex = random.nextInt(numberOfPerson.getNumber() - 1);

            ladderPos = new LadderPosition(Position.from(rowIndex), Position.from(columnIndex));

            boolean validLine = drawLine(ladderPos.getRow(), ladderPos.getColumn());

            if (validLine) {
                lineCount.add(ladderPos);
            }
        }
    }
}
