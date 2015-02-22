package trailStation;


public class Passenger {

    private String name;
    private String secondName;
    private String carriagesType;
    private String destination;

    public String toString (){
        return name+""+secondName+""+carriagesType+""+destination;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCarriagesType() {
        return carriagesType;
    }
    public void setCarriagesType(String carriagesType) {
        this.carriagesType = carriagesType;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }


}
