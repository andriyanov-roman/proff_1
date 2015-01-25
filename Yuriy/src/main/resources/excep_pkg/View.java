package excep_pkg;

import java.io.IOException;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator();


    public View() throws IOException {
        startProgram();
    }

    public void startProgram() throws IOException {
        System.out.println("Enter goods" + "\n" + "Name of good");
        while (scanner.hasNext()) {
            Goods goods = new Goods();
            String goodName = scanner.nextLine();
            if (validator.isGoodNameValid(goodName)) {
                goods.setName(goodName);
            }
            System.out.println("Amount of good");
            String goodAmount = scanner.nextLine();
            if (validator.isGoodAmount(goodAmount)) {
                goods.setAmount(Integer.parseInt(goodAmount));
            }
            System.out.println("Barcode");
            String barcode = scanner.nextLine();
            if (validator.isGoodBarcode(barcode)) {
                goods.setBarcode(Long.parseLong(barcode));
            }
            System.out.println("Type");
            String type = scanner.nextLine();
            if (validator.isGoodType(type)) {
                goods.setType(type);
            }
            if ("0".equals(scanner.nextLine())) {
                System.out.println("Exit");
                break;
            }

            GoodsModel.writeToFile(goods);
        }
    }


}
