import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run(){
        boolean running=true;
        System.out.println("Fleet Management system");
        while (running){
            printMenu();

            int choice;
            choice=Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1: printAllVehicles(); break;
                case 2: addNewCar(); break;
                case 3: addNewBus(); break;
                case 4: showTotalInsurance(); break;
                case 5: showVehiclesOlderThan(); break;
                case 6: performServicesAll(); break;
                case 7: System.out.println("Quitting system"); running=false; break;
            }
        }
    }

    private void printMenu() {
        System.out.println("***Menu***");
        System.out.println("1.Print all vehicles");
        System.out.println("2.Add new car");
        System.out.println("3.Add new bus");
        System.out.println("4.Show total yearly insurance fee");
        System.out.println("5.Show vehicles older than _ years");
        System.out.println("6.Perform service for all vehicles");
        System.out.println("7.Quit");
    }

    private void printAllVehicles(){
        if (vehicles.isEmpty()){
            System.out.println("No vehicles in the fleet");
        }
        else {
            for (Vehicle v: vehicles){
                System.out.println(v);
            }
        }
    }

    private void addNewCar(){
        System.out.println("Print model of the car: ");
        String model=scanner.nextLine();

        System.out.println("Print year of the car: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Print Base price of the car: ");
        double basePrice = Double.parseDouble(scanner.nextLine());

        System.out.println("Print Number of doors of the car: ");
        int NumberOfDoors = Integer.parseInt(scanner.nextLine());

        vehicles.add(new Car(model, year, basePrice, NumberOfDoors));
        System.out.println("Car successfully added!");
    }

    private void addNewBus(){
        System.out.println("Print model of the bus: ");
        String model=scanner.nextLine();

        System.out.println("Print year of the bus: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Print Base price of the bus: ");
        double basePrice = Double.parseDouble(scanner.nextLine());

        System.out.println("Print Capacity of the bus: ");
        int PassengerCapacity = Integer.parseInt(scanner.nextLine());

        vehicles.add(new Bus(model, year, basePrice, PassengerCapacity));
        System.out.println("Bus successfully added!");
    }

    private void showTotalInsurance(){
        double total = 0;
        for (Vehicle v: vehicles){
            total+= v.calculateInsuranceFee();
        }
        System.out.println("Total of Insurance fee: "+total);
    }

    private void showVehiclesOlderThan(){
        int N;
        int currentYear;
        System.out.println("Show cars older than:");
        N=Integer.parseInt(scanner.nextLine());

        for (Vehicle v: vehicles){
            if (v.getAge(v.getCurrentYear())>N){
                System.out.println(v);
            }
        }
    }

    private void performServicesAll(){
        for (Vehicle v: vehicles){
            v.performService();
        }
    }
}
