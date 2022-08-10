package lv.id.jc.boundaryvalues.case01;

import java.util.function.LongToIntFunction;

public class SmallestValueOriginal implements LongToIntFunction {

    @Override
    public int applyAsInt(long m) {
        int n = 1;
        long factorial = 1;

        while (factorial <= m) {
            n++;
            factorial *= n;
        }
        return n;
    }
}
