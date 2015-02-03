package shop;

import shop.user.Authentification;
import shop.user.User;

import java.io.IOException;

/**
 * Created by eugene on 04.02.15.
 */
public class Shop {
    public Shop() throws IOException {
        Authentification u = new Authentification();
        u.log();
    }

}
