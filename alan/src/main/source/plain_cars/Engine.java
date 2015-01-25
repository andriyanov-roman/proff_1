package plain_cars;

import java.math.BigDecimal;

public class Engine extends Options {
    private String type;
    private BigDecimal  volume;





    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}