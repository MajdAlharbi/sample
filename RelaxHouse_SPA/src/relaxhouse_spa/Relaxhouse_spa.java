/*
3c3
Majd Mohammed Alharbi 	444008852
Fajr Alfulayih      	444008937 
Aseel Mohammed Alharbi	444008878
Rimas Awad Al-Otaibi	444008950
 */
package relaxhouse_spa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Relaxhouse_spa {

    private static Scanner input = new Scanner(System.in);
    public static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {

        // Create ArrayLists for bookings and services
        ArrayList<Booking> bookings = new ArrayList<>();
        ArrayList<Service> Services = new ArrayList<>();
        Services.add(new Hair("1\\Hair Coloring", 1, "Hair Color and Style", 799));
        Services.add(new Hair("2\\Hair Styling", 2, "Hair Color and Style", 399));
        Services.add(new MassageServices("3\\Hot Stone Massage", 3, "Relaxing", 1090));
        Services.add(new MassageServices("4\\Deep Tissue Massage", 4, "Relaxing", 999));
        Services.add(new NailCare("5\\Nail Art", 5, "Nail Treatement", 249));
        Services.add(new NailCare("6\\Spa Manicure", 6, "Nail Treatement", 399));
        
        
        System.out.println("**** Welcome To Relax House SPA ****\n");

        CreateCustomer.main(null);
        int choice = 0;
        do {
            try {
                // Display the main menu and get the user's choice
                System.out.print("\n1. our Services\n"
                        + "2. Booking\n"
                        + "3. Display Booking:\n"
                        + "4. Cancel Booking:\n"
                        + "5. Read Files\n"
                        + "6. Exit\n");

                choice = input.nextInt();//customer choice 

                switch (choice) {

                    case 1:// Display the services

                        for (Service s : Services) {
                            System.out.println(s);
                            System.out.printf("Discount: %.2f %%\n", s.discount() * 100);
                            if (s instanceof Hair) {
                                ((Hair) s).prinHairStyles();// Downcast to Hair and print hairstyles 

                            }
                            System.out.println("------------------------------------------------------");
                        }
                        break;

                    case 2: // Create a new booking

                        System.out.println("Enter booking information:");

                        //Read the booking date from the console and validate it
                        System.out.println("Booking date (dd mm yyyy): ");
                        System.out.println("Enter The day :");
                        int day = input.nextInt();
                        while (day < 1 || day > 31) {
                            System.out.println("invalid day.");
                            System.out.println("Enter The day :");
                            day = input.nextInt();
                        }
                        System.out.println("Enter The month :");
                        int month = input.nextInt();
                        while (month < 1 || month > 12) {
                            System.out.println("invalid month");
                            System.out.println("Enter The month :");
                            month = input.nextInt();
                        }

                        int year = 2023;

                        Date bookingDate = new Date(day, month, year);
                        System.out.println("yor Booking Date is " + day + "/" + month + "/" + year);

                        // Read the booking time from the console
                        System.out.println("Booking time (hh mm): ");
                        System.out.println("Enter hours : ");
                        int hours = input.nextInt();
                        System.out.println("Enter minits : ");
                        int minutes = input.nextInt();
                        Time bookingTime = new Time(hours, minutes);
                        System.out.println("yor Booking Time is " + hours + ":" + minutes);

                        //Read the services to be booked from the console
                        System.out.print("How many services you like to book? ");
                        int size = input.nextInt();
                        if (size <= 0) {
                            System.out.println("Invalid number of services.");
                        } else {
                            Service[] bServices = new Service[size];
                            int c = 0;
                            while (c < size) {
                                System.out.println("\n1.Hair Color and Style"
                                        + "\n2.Relaxing"
                                        + "\n3.Nail Treatement");
                                System.out.print("Enter service number: ");
                                int sNumber = input.nextInt();
                                boolean found = false;
                                for (Service s : Services) {
                                    if (s.getServiceNumber() == sNumber) {
                                        bServices[c] = s;
                                        found = true;
                                    }
                                }

                                if (found == false) {
                                    System.out.println("Invalid id, service not found, try again");
                                } else {
                                    c++;
                                }
                            }

                            // Create a new booking with the entered information
                            Booking b = new Booking(customers.get(0), bookingDate, bookingTime, bServices);
                            bookings.add(b);// Add the new booking to the list of bookings
                            System.out.println(b);
                            System.out.printf("Total is: %.2f SAR", b.total());
                            b.displayServices();
                            System.out.println("Your booking has been confirmed");
                        }

                        break;

                    case 3:// Display a specific booking
                        System.out.print("Enter your booking id: ");
                        int bookingId = input.nextInt();
                        boolean found = false;
                        for (Booking b : bookings) {
                            if (b.getBookingID() == bookingId) {
                                System.out.println(b);
                                System.out.printf("Total is: %.2f SAR", b.total());
                                found = true;
                            }
                        }
                        if (found == false) {
                            System.out.println("your booking not found!");
                        }
                        break;

                    case 4:// Cancel a specific booking

                        System.out.print("Enter your booking id: ");
                        bookingId = input.nextInt();
                        int index = -1;
                        for (int i = 0; i < bookings.size(); i++) {
                            if (bookings.get(i).getBookingID() == bookingId) {
                                index = i;
                            }
                        }
                        if (index == -1) {
                            System.out.println("your booking not found!");
                        } else {
                            System.out.print("Are you sure you want to cancel your Booking? (Y/N): ");
                            char answer = input.next().charAt(0);
                            if (answer == 'y' || answer == 'Y') {
                                bookings.remove(index); // Remove the booking from the list of bookings
                                System.out.println("Your booking has been cancelled!");
                            } else {
                                System.out.println("Your booking is still confirmed!");
                            }
                        }

                        break;
                    case 5:// Read services from a file
                        ReadFiles r = new ReadFiles(); // Create a new ReadFiles object
                        r.openTextFile("p.txt"); // Open the file named "p.txt
                        r.readFromFile(); // Read the services from the file
                        r.closeFile();// Close the file
                        break;

                    case 6: // Write services to a file and exit
                        WriteFiles w = new WriteFiles(); // Create a new WriteFiles object
                        w.openTextFile("p.txt"); // Open the file named "p.txt
                        for (Service s : Services) {
                            w.writeToFile(s);  // Write each service to the file
                        }
                        w.closeFile();// Close the file
                        System.out.println("All information saved");
                        System.out.println("Thank you!");
                        System.exit(0);
                        break;

                }

            } catch (InputMismatchException e) { // Catch input mismatch exceptions
                System.out.println("incorrect input");
            } catch (NullPointerException e) {// Catch null pointer exceptions
                System.out.println("incorrect object");
            } catch (ArrayIndexOutOfBoundsException e) {
                { // Catch array index out of bounds exceptions
                    System.out.println("incorrect index");
                }
            }
        } while (choice != 6);// exits the program
    }
}
