package lv.id.jc.boundaryvalues.case03;

public class Main {
    public static void main(String[] args) {
        var message = new TimeUntilMidnightOriginal().get();
        System.out.println(message);

        message = new TimeUntilMidnightCorrect().get();
        System.out.println(message);
    }
}
