import java.time.Year;

public class Car extends Vehicle {
    int NumberOfDoors;

    protected Car(String model, int year, double basePrice, int NumberOfDoors) {
        super(model, year, basePrice);
    }

    public void setNumberOfDoors(int NumberOfDoors) {
        if (NumberOfDoors > 1 && NumberOfDoors < 5 && NumberOfDoors != 3) {
            this.NumberOfDoors = NumberOfDoors;
        }
    }

    public int getNumberOfDoors() {return NumberOfDoors;}

    @Override
    public double calculateInsuranceFee() {
        int currentYear = Year.now().getValue();
        int age = getAge(currentYear);
        return (getbasePrice() * 0.4) + (age * 50);
    }

    @Override
    public void performService(){
        System.out.println("Serving Car: Changing oil, checking condition of wheels");
    }

    @Override
    public int getServiceIntervalKm(){
        return 15000;
    }
}
