package exeption;

/**
 * Created by artem on 28.01.15.
 */
public class ViewException {
    public static int DoSomething(int n) throws MyException {
        if (n > 0) {
            return n;
        } else {
            throw new MyException("Wrong value");
        }
    }
}
