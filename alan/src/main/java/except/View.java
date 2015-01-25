package except;


import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private GoodValidator validator = new GoodValidator();

    public View() {
        startProgram();
    }

    public void startProgram() {
        System.out.println("Введите название товара" + "\n" + "Название товара");
        while (scanner.hasNext()) {
            Good g = new Good();
            String goodName = scanner.nextLine();
            if (validator.isGoodNameValid(goodName)) {
                g.setTitle(goodName);
            } else {
                System.out.println("Enter goods quantity");
                String quantity = scanner.nextLine();
                if (validator.isGoodQuantityValid(quantity)) {
                    g.setQuantity(Integer.parseInt(quantity));

                }
            }
        }
    }
}

