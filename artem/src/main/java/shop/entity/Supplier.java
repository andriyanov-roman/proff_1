package shop.entity;

/**
 * Created by artem on 07.03.15.
 */
public class Supplier {
    String name;
    String goods_type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }
    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", goods_type='" + goods_type + '\'' +
                '}';
    }
}
