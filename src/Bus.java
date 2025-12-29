public class Bus extends Vehicle {
    private int PassengerCapacity;

    protected Bus(String model, int year, double basePrice, int PassengerCapacity) {
        super(model, year, basePrice);
    }

    public void setPassengerCapacity(int passengerCapacity){
        if (passengerCapacity>29&&passengerCapacity<71){
            this.PassengerCapacity=passengerCapacity;
        }
    }

    public int getPassengerCapacity(){return PassengerCapacity;}

    @Override
    public double calculateInsuranceFee() {
        return (getbasePrice() * 0.4) + (PassengerCapacity * 10);
    }

    @Override
    public void performService(){
        System.out.println("Serving Bus: Checking conditions of seats, cleaning inside the bus, checking terminals");
    }

    @Override
    public int getServiceIntervalKm(){
        return 30000;
    }
}
