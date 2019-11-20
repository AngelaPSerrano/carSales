
public class Car {
    private String model;
    private int manufacturingYear;
    private int drivenKM;
    private double price;

    public Car(String model, int manufacturingYear, int drivenKM, double price) {
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.drivenKM = drivenKM;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public int getDrivenKM() {
        return drivenKM;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return this.getModel() + "\n" + this.getManufacturingYear() + "\n" + this.getDrivenKM() + "\n" + this.getPrice() + "\n";
    }

    public boolean equalTo(Car c){
        if(this.toString() == c.toString()){
            return true;
        }else{
            return false;
        }
    }
}
