package entregado;

public class Car {
    private String model;
    private int manufacturingYear, drivenKM;
    private double price;

    public Car(String model, int manufacturingYear, int drivenKM, double price) {
        this.model = model;
        if(manufacturingYear >= 0) {
            this.manufacturingYear = manufacturingYear;
        }else{
            this.manufacturingYear = 0;
        }
        if(drivenKM >= 0) {
            this.drivenKM = drivenKM;
        }else{
            this.drivenKM = 0;
        }
        if(price >= 0){
            this.price = price;
        }else{
            this.price = 0;
        }

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

    public boolean equalTo(Car c) {
        return  this.getModel().equals(c.getModel()) &&
                this.getManufacturingYear() == c.getManufacturingYear() &&
                this.getDrivenKM() == c.getDrivenKM() &&
                this.getPrice() == c.getPrice();
    }
}
