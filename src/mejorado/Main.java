package mejorado;

public class Main {
    public static void main(String[] args) {
        Car c = new Car("Canyonero", 1985, 0, 20000);
        Car d = new Car("Mercedes Benz W115", 1968, 1500, 15000);
        CarList cl = new CarList("C:\\Users\\Angela Serrano\\IdeaProjects\\carSales\\CarSales.txt");
        //Como no sobreescribe el documento, solo hacer si está vacio o si son coches nuevos
        /*cl.addCar(c);*/
        cl.addCar(d);
        System.out.println("Number of new cars: " + cl.countNewCars());
        System.out.println("Total number of cars: " + cl.numberOfCars());
        System.out.println("The most expensive car: ");
        System.out.println(cl.mostExpensiveCar());
        cl.removeCar(d);
    }
}
