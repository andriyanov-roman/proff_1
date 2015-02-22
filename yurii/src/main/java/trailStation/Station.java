package trailStation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Station {

    private static ArrayList<String> destinations = new ArrayList<>();
    static {
        destinations.add("Kiev-Lutsk");
        destinations.add("Kiev-Odessa");
        destinations.add("Kiev-Lviv");
    }

    private ArrayList<Carriage> carriages = new ArrayList<>();

    private ArrayList<Passenger> passengers = new ArrayList<>();

    public ArrayList<Train> getTrains() throws IOException {
        ArrayList<Train> trains = new ArrayList<>();
        for (int i = 0; i < destinations.size(); i++) {
            trains.add(getTrain(destinations.get(i)));
        }
        System.out.println(trains.toString());
        return trains;
    }

    public Train getTrain(String destination) throws IOException {
        Train train = new Train();
        train.setCarriagesCapacity(20);
        train.setDestination(destination);
        ArrayList<Carriage> carriageList = new ArrayList<>();
        int qtyPassengers = 0;
        for (int i = 0; i < train.getCarriagesCapacity(); i++) {
            for (int j = 0; j < carriages.size(); j++) {
                if (carriages.get(j).getPassengerCapacity() > qtyPassengers) {
                    Carriage carriage = fillCarriage(destination, carriages.get(i));
                    carriageList.add(carriage);
                    qtyPassengers++;
                }
            }
        }
        train.setCarriages(carriageList);
        return train;
    }

    public Carriage fillCarriage(String destination, Carriage carriage) {
        ArrayList<Passenger> tmpPas = new ArrayList<>();
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getDestination().equals(destination) && carriage.getPassengerCapacity() < tmpPas.size()) {
                tmpPas.add(passengers.get(i));
            }
        }
        carriage.setPassengers(tmpPas);
        return carriage;
    }

    public void checkPassengersList() throws IOException {
        PassengerHelper helper = new PassengerHelper();
        helper.getPassenger();

    }

    private class PassengerHelper {
        public static final int NAME = 0;
        public static final int SECOND_NAME = 1;
        public static final int CARRIAGES_TYPE = 2;
        public static final int DESTINATION = 3;

        public void getPassenger() throws IOException {
            ArrayList<String[]> lines = getString("src\\Passenger.txt");
            for (int i = 0; i < lines.size(); i++) {
                Passenger p = new Passenger();
                p.setName(lines.get(i)[NAME]);
                p.setSecondName(lines.get(i)[SECOND_NAME]);
                p.setCarriagesType(lines.get(i)[CARRIAGES_TYPE]);
                p.setDestination(lines.get(i)[DESTINATION]);
                passengers.add(p);
            }

        }
    }

    public void createCarriages() {
        Carriage carriage = new Carriage();
        for (int i = 0; i < 50; i++) {
            if (i < 25) {
                carriage.setType("cupe");
                carriage.setNumberCarriage(i);
            }
            if (i > 25) {
                carriage.setType("placard");
                carriage.setNumberCarriage(i);
            }
            if (carriage.getType().equals("cupe")) {
                carriage.setPassengerCapacity(50);
            }
            if (carriage.getType().equals("placard")) {
                carriage.setPassengerCapacity(70);
            }

            carriages.add(carriage);
            System.out.println(carriages.get(i).toString());
        }

    }

    public void generatePassengerToFile() {
        ArrayList<Passenger> passengers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Passenger passenger = new Passenger();
            passenger.setName("name" + i);
            passenger.setSecondName("secondName" + Math.random());
            if (i < 50) {
                passenger.setCarriagesType("cupe");
            }
            if (i > 50) {
                passenger.setCarriagesType("placard");
            }
            if (i < 30) {
                passenger.setDestination("Kiev-Lutsk");
            }
            if (i > 30 && i < 60) {
                passenger.setDestination("Kiev-Odessa");
            }
            if (i > 60 && i < 100) {
                passenger.setDestination("Kiev-Lviv");
            }
            passengers.add(passenger);

        }
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src\\Passenger.txt")));
            for (int i = 0; i < passengers.size(); i++) {
                out.println(passengers.get(i).getName() + ":" + passengers.get(i).getSecondName() + ":" + passengers.get(i).getCarriagesType() + ":" + passengers.get(i).getDestination());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> getString(String path) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : Files.readAllLines(Paths.get(path))) {
            strings.add(s);
        }
        ArrayList<String[]> stringsSplit = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            stringsSplit.add(strings.get(i).split(":"));
        }
        return stringsSplit;
    }

}

