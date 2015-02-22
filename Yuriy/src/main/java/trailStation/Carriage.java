package trailStation;


import java.util.ArrayList;

public class Carriage {

    private String type;
    private int passengerCapacity;
    private int numberCarriage;
    private ArrayList<Passenger> passengers;

    public String toString(){
        return type+":"+passengerCapacity+":"+numberCarriage+":"+passengers;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getNumberCarriage() {
        return numberCarriage;
    }
    public void setNumberCarriage(int numberCarriage) {
        this.numberCarriage = numberCarriage;
    }


}
