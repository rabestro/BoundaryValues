package lv.id.jc.boundaryvalues.case01;

import java.util.function.LongToIntFunction;

public class SmallestValueCorrect implements LongToIntFunction {

    @Override
    public int applyAsInt(long m) {
        int n = 0;
        while (m != 0) {
            m /= ++n;
        }
        return n;
    }
}
