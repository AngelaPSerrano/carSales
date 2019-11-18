import java.io.*;
import java.time.Year;

public class carList {
    private LineNumberReader lnr;
    private FileReader fin;
    private File f;

    public carList(String filename) {
        f = new File(filename);
        try{
            fin = new FileReader(f);
            lnr = new LineNumberReader(fin);
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    public int numberOfCars() {
        int count = 0;
        try {
            while (lnr.readLine() != null) {
                String line;

                String model = lnr.readLine();

                line = lnr.readLine();
                Year year = null;
                year.of(Integer.parseInt(line));

                line = lnr.readLine();
                int km = Integer.parseInt(line);

                line = lnr.readLine();
                double price = Double.parseDouble(line);

                new Car(model, year, km, price);
                count++;
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return count;
    }

    public Car mostExpensiveCar() {
        double expensive = 0;
        Car c = null;
        try {
            while (lnr.readLine() != null) {
                String line;

                String model = lnr.readLine();

                line = lnr.readLine();
                Year year = null;
                year.of(Integer.parseInt(line));

                line = lnr.readLine();
                int km = Integer.parseInt(line);

                line = lnr.readLine();
                double price = Double.parseDouble(line);

                if (expensive < price) {
                    expensive = price;
                    c = new Car(model, year, km, price);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c;
    }


    public void addCar(Car c){

    }

    public void removeCar(Car c){

    }
}
