import java.time.Year;

public class Car {
    private String model;
    private Year manufacturingYear;
    private int drivenKM;
    private double price;

    public Car(String model, Year manufacturingYear, int drivenKM, double price) {
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.drivenKM = drivenKM;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public Year getManufacturingYear() {
        return manufacturingYear;
    }

    public int getDrivenKM() {
        return drivenKM;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return this.getModel() + this.getManufacturingYear() + this.getDrivenKM() + this.getPrice();
    }

    public boolean equalTo(Car c){
        if(this.toString() == c.toString()){
            return true;
        }else{
            return false;
        }
    }
}
