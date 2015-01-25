package trailStation;

import java.util.ArrayList;

public class Train {

    private ArrayList<Carriage> carriages;
    private String destination;
    private int carriagesCapacity;


    public int getCarriagesCapacity() {
        return carriagesCapacity;
    }

    public void setCarriagesCapacity(int carriagesCapacity) {
        this.carriagesCapacity = carriagesCapacity;
    }

    public ArrayList<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(ArrayList<Carriage> carriagesOfOneTrain) {
        this.carriages = carriagesOfOneTrain;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
