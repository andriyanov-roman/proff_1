package shop;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by artem on 24.01.15.
 */
@Entity
@Table(name = "goods")
public class Good implements Serializable {
    static final long serialVersionUID = -7593775012501239455L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  @Column(name = "id")
    private Long id;
    @Column(name="good_name")
    private String name;
    @Column(name="good_number")
    private int number;
    @Column(name="barcode")
    private long barcode;
    @Column(name="good_type")
    private String type;

    public Good(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Good)) return false;

        Good good = (Good) o;

        if (barcode != good.barcode) return false;
        if (number != good.number) return false;
        if (id != null ? !id.equals(good.id) : good.id != null) return false;
        if (name != null ? !name.equals(good.name) : good.name != null) return false;
        if (type != null ? !type.equals(good.type) : good.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (int) (barcode ^ (barcode >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String toString() {
        return "Good name: "+getName()+" Good number: "+getNumber()+" Good barcode: "+getBarcode()+" Good Type: "+getType();
    }
}
