import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

record myList(String place, String distance) {

    public myList(String place) {
        this(place, "400");
    }
}

public class TravelList {

    public void createItinerary(ArrayList<myList> travelItinerary) {
        String firstTown = travelItinerary.get(0).place();
        int i = 4;

        out.printf("\nADD (%d) TOWNS TO VISIT:\n\n", i);

        while (i > 0) {
            out.println("Enter name of Town");
            String cityName = new Scanner(in).nextLine();

            out.println("\nEnter distance from "+ firstTown);
            String distance = new Scanner(in).nextLine();

            myList myList = new myList(cityName, distance);

            if(!addPlace(travelItinerary, myList)) {
                out.println("\n"+cityName + " is already on the list\n");
                i++;
            } else {
                out.println("\n"+cityName + " Added to itinerary.\n");
            }

            i--;
        }
    }

    public boolean addPlace (ArrayList<myList> allPlace, myList place) {

        if (allPlace.contains(place)) {
            return false;
        }

        for (myList m : allPlace) {
            if (m.place().equalsIgnoreCase(place.place())) {
                return false;
            }
        }

        allPlace.add(place);
        return true;
    }

    public void menu () {
        System.out.println(
                """
                Available actions:
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """
        );
    }
}
