package spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shop.control.ControlUser;
import shop.entity.Good;
import shop.entity.User;
import shop.control.Validator;
import spring.dao.GoodsDAO;

@Configuration
public class AppConfig {
    @Bean
    public GoodsDAO getGoodsDao() {
        return new GoodsDAO();
    }
    @Bean
    public Good getGood(){
         Good good=new Good();
         return good;
     }
    @Bean
    public ControlUser getControlUser(){
        ControlUser controlUser=new ControlUser();
        return controlUser;
    }
    @Bean
    public Validator getValidator(){
        Validator validator=new Validator();
        return validator;
    }
    @Bean
    public User getUser(){
        User user=new User();
        return user;
    }
}
