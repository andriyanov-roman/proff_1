package lessonForSinglePattern;


public final class SimpleString {
    private static SimpleString instance = new SimpleString();

    private SimpleString() {
    }

    public static SimpleString getInstance() {
        return instance;
    }


    public static void doSamsing(int a) {
        System.out.println("this is method doSamsing");
    }

    public static void doSamsing(int a, int b) {
        System.out.println("this is method doSamsingWithTwoArg");
    }
}
