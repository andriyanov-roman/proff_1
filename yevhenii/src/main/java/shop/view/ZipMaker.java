package shop.view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by eugene on 06.02.15.
 */
public class ZipMaker {
    public ZipMaker() {
        toZip();
    }



    public void toZip() {
        FileInputStream in = null;
        ZipOutputStream out = null;
        try {
            in = new FileInputStream("/home/eugene/proff_repos/proff_1/yevhenii/src/main/java/shop/view/report");
            out = new ZipOutputStream(new FileOutputStream("/home/eugene/proff_repos/proff_1/yevhenii/src/main/java/shop/view/test.zip"));
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
}
