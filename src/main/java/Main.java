import java.util.Scanner;

/**
 * Created by Tatty on 24.01.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            if("0".equals(scanner.next())) {
                System.out.println("Exit");
                break;
            }
        }
    }
}
