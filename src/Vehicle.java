import java.time.Year;

abstract class Vehicle implements Servicable {
    protected int id;
    protected static int idGen;
    protected int year;
    protected String model;
    protected double basePrice;
    int currentYear = Year.now().getValue();

    protected Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setbasePrice(basePrice);
    }

    public int getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public double getbasePrice() {
        return basePrice;
    }
    public int getCurrentYear(){return currentYear;}

    public void setModel(String model) {
            if (model.isEmpty()) {
                System.out.println("model must not be empty");
            }
            else {this.model=model;
            }
        }

    public void setYear(int year) {
            if (year < 2015 || year > currentYear+1) {
                System.out.println("Write proper year of the car");
            }
            else {this.year=year;
            }
        }

    public void setbasePrice(double basePrice){
            if (basePrice<0){
                System.out.println("Base price should be more than 0");}
            else {
                this.basePrice=basePrice;
            }
        }

    public int getAge(int currentYear){
        if (currentYear<this.year){
            return 0;
        }
        return currentYear-this.year;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return "ID:"+ id+
                ", Model:"+ model+
                ", Year:"+ year+
                ", Base Price:"+ basePrice;
    }
}