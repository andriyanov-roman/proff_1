package shop.goods;

import shop.db_access.GoodDAO;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GoodUtility {
    GoodDAO goodDAO = new GoodDAO();

    public void addGood(Good good) {
        if (goodDAO.selectAll().contains(good)) {
            System.out.println("Good exists! Try again");
        } else {
            goodDAO.executeUpdate(good);
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
        for (Good g : goodDAO.selectAll()) {
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
        goods.addAll(goodDAO.selectAll());
        printAllGoods(goods);
    }

    public void getSortedByQuantity() {
        Set<Good> goods = new TreeSet<>(Comparator.comparing(Good::getQuantity).thenComparing(Good::getBarcode));
        goods.addAll(goodDAO.selectAll());
        printAllGoods(goods);
    }


}
