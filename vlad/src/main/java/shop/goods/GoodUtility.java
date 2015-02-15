package shop.goods;

import shop.writer.GoodWriter;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GoodUtility {
    GoodWriter writer = new GoodWriter();

    public void addGood(Good good) {
        if (getAllGoods().contains(good)) {
            System.out.println("Good exists! Try again");
        } else {
            writer.writeToFile(good, "vlad/src/main/java/files/shop");
            System.out.println("Good is valid");
        }
    }

    public void printAllGoods(Set<Good> goods) {
        for (Good g : goods) {
            System.out.println("Name: " + g.getName() + ". Quantity: " + g.getQuantity()
                    + ". Barcode: " + g.getBarcode() + ". Type: " + g.getType());
        }
    }

    public void printAllGoods() {
        for (Good g : getAllGoods()) {
            System.out.println("Name: " + g.getName() + ". Quantity: " + g.getQuantity()
                    + ". Barcode: " + g.getBarcode() + ". Type: " + g.getType());
        }
    }

    public void makeZIP() {
        FileInputStream in = null;
        ZipOutputStream out = null;
        try {
            in = new FileInputStream("vlad/src/main/java/files/shop");
            out = new ZipOutputStream(new FileOutputStream("/home/vladislav/Документы/goods.zip"));
            out.putNextEntry(new ZipEntry("shop_report.txt"));

            byte[] b = new byte[1024];
            int count;

            while ((count = in.read(b)) > 0) {
                System.out.println();
                out.write(b, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null && out != null) {
                    in.close();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Set<Good> getAllGoods() {
        Set<Good> goods = new HashSet<>();
        List<String> data = null;
        try {
            data = readFromFile("/home/vladislav/proff_repos/proff_1/vlad/src/main/java/files/shop");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String[]> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String[] pool = data.get(i).split(":");
            result.add(pool);
        }
        for (int i = 0; i < result.size(); i++) {
            goods.add(new Good(result.get(i)[0], Integer.parseInt(result.get(i)[1]), Integer.parseInt(result.get(i)[2]), result.get(i)[3]));
        }
        return goods;
    }

    private List<String> readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String s = "";
        while (scanner.hasNext()) {
            s += scanner.next();
        }
        String[] pool = s.split("=");
        List<String> strings = Arrays.asList(pool);
        return strings;
    }

    public void getSortedByBarcode() {
        Set<Good> goods = new TreeSet<>(new Comparator<Good>() {
            @Override
            public int compare(Good o1, Good o2) {
                if (o1.getBarcode() > o2.getBarcode()) {
                    return 1;
                }
                if (o1.getBarcode() < o2.getBarcode()) {
                    return -1;
                } else return 0;
            }
        });
        goods.addAll(getAllGoods());
        printAllGoods(goods);
    }

    public void getSortedByQuantity() {
        Set<Good> goods = new TreeSet<>(Comparator.comparing(Good::getQuantity).thenComparing(Good::getBarcode));
        goods.addAll(getAllGoods());
        printAllGoods(goods);
    }
}
