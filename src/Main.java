import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        TravelList myClass = new TravelList(); // class creation

        ArrayList<myList> listOfPlaces = new ArrayList<>(10); // ArrayList

        System.out.println("Enter your current Town: ");
        String city = new Scanner(in).nextLine();

        listOfPlaces.add(new myList(city));
        myClass.createItinerary(listOfPlaces);

        boolean flag = true;
        var iterator = listOfPlaces.listIterator();

        out.println("\nStart Traveling\n".toUpperCase());
        myClass.menu();

        while (true) {
            switch (new Scanner(in).nextLine()) {

                case "F" -> {
                    out.println("Going Forward".toUpperCase());
                    if(!iterator.hasPrevious()) {
                        iterator.next();

                        String town = iterator.next().place();
                        iterator.previous();

                        String km = iterator.next().distance();
                        System.out.println("\nNow visiting --> "+ town.toUpperCase() + "\n"
                                + km+"km from " + listOfPlaces.get(0).place()
                        );

                        flag = false;
                    } else if (iterator.hasNext()) {

                        if (flag) {
                            iterator.next();
                        }

                        String town = iterator.next().place();
                        iterator.previous();

                        String km = iterator.next().distance();
                        System.out.println("\nNow visiting --> " + town.toUpperCase() + "\n"
                                + km + "km from " + listOfPlaces.get(0).place()
                        );

                        flag = false;
                    } else {
                        System.out.println("\nYou're at the end.");
                        flag = true;
                    }
                }

                case "B" -> {
                    out.println("Going Backwards\n".toUpperCase());

                    if(!iterator.hasNext()) {
                        iterator.previous();

                        String town = iterator.previous().place();
                        iterator.next();
                        String km = iterator.previous().distance();

                        System.out.println("\nNow visiting --> " + town.toUpperCase() + "\n"
                                + km + "km from " + listOfPlaces.get(0).place()
                        );

                        flag = true;
                    } else if (iterator.hasPrevious()) {

                        if (!flag) {
                            iterator.previous();
                        }

                        String town = iterator.previous().place();
                        iterator.next();
                        String km = iterator.previous().distance();

                        if (town.equalsIgnoreCase("sydney")) {
                            System.out.println("\nNow visiting --> "+ town.toUpperCase());
                        } else {
                            System.out.println("\nNow visiting --> "+ town.toUpperCase() + "\n"
                                    + km+"km from " + listOfPlaces.get(0).place()
                            );
                        }

                        flag = true;
                    } else {
                        System.out.println("\nYou're at the beginning.");
                        flag = false;
                    }
                }

                case "L" -> {
                    out.println("ITINERARY:\n");

                    for (int i = 1; i < listOfPlaces.size(); i++) {
                        String place = listOfPlaces.get(i).place();
                        String distance = listOfPlaces.get(i).distance();

                        out.printf("%s\n : %s km from %s\n", place.toUpperCase(), distance,
                                listOfPlaces.get(0).place()
                        );

                        out.println();
                    }
                }

                case "M" -> myClass.menu();

                case "Q" -> {
                    System.out.println("Quitting application...");
                    return;
                }

                default -> System.out.println("Invalid input");
            }
        }
    }
}

// Thank you for viewing this code. :-)
