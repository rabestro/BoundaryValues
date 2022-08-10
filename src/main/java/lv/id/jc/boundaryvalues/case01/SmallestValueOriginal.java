package lv.id.jc.boundaryvalues.case01;

import java.util.function.LongToIntFunction;

public class SmallestValueOriginal implements LongToIntFunction {

    @Override
    public int applyAsInt(long number) {
        int n = 1;
        long factorial = 1;

        while (factorial <= number) {
            n++;
            factorial *= n;
        }
        return n;
    }
}
