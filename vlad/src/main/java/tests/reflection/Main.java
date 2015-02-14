package tests.reflection;

import io_homework.url_reader.URLReader;
import shop.goods.Good;
import shop.main.View;

import java.io.IOException;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        View view = new View();
        ClassInvestigator.getInformation(view);
//        Good good = new Good();
//        getInformation(good);
        URLReader u = new URLReader();
        ClassInvestigator.getInformation(u);
    }

}

