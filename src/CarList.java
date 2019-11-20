import java.io.*;

public class CarList {
    private LineNumberReader lnr;
    private FileReader fin;
    private File f;

    //funciona
    public CarList(String filename) {
        f = new File(filename);
    }
    //funciona
    private void openStream(){
        try{
            fin = new FileReader(f);
            lnr = new LineNumberReader(fin);
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    //funciona
    public int numberOfCars() {
        openStream();
        int count = 0;
        try {
            while (lnr.readLine() != null) {
                if (lnr.readLine() != null) {
                    if (lnr.readLine() != null) {
                        if(lnr.readLine() != null) {
                            count++;
                            }
                        }
                    }
                }
            fin.close();
        } catch(IOException e){
            System.out.println(e);
        }
        return count;
    }

    //funciona
    public Car mostExpensiveCar() {
        openStream();
        double expensive = 0;
        Car c = null;
        String model;
        String line;
        int year;
        int km;
        double price;
        try {
            while ((model = lnr.readLine()) != null) {
                if ((line = lnr.readLine()) != null) {
                    try{
                        year = Integer.parseInt(line);
                    }catch (NumberFormatException e){
                        year = 0;
                    }
                    if ((line = lnr.readLine()) != null) {
                        try{
                            km = Integer.parseInt(line);
                        }catch (NumberFormatException e){
                            km = 0;
                        }
                        if((line = lnr.readLine())!= null) {
                            try{
                                price = Double.parseDouble(line);
                            }catch (NumberFormatException e){
                                price = 0;
                            }
                            if (expensive < price) {
                                expensive = price;
                                c = new Car(model, year, km, price);
                            }
                        }
                    }
                }
            }
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c;
    }

    //funciona
    public void addCar(Car c){
        try {
            FileOutputStream fout = new FileOutputStream(f,true);
            try {
                fout.write(c.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    //funciona
    public void removeCar(Car c){
        String model;
        String line;
        int year;
        int km;
        double price;
        try {
            openStream();
            String rCar= "";
            while ((model = lnr.readLine()) != null) {
                if ((line = lnr.readLine()) != null) {
                    try{
                        year = Integer.parseInt(line);
                    }catch (NumberFormatException e){
                        year = 0;
                    }
                    if ((line = lnr.readLine()) != null) {
                        try{
                            km = Integer.parseInt(line);
                        }catch (NumberFormatException e){
                            km = 0;
                        }
                        if((line = lnr.readLine())!= null) {
                            try{
                                price = Double.parseDouble(line);
                            }catch (NumberFormatException e){
                                price = 0;
                            }
                            if ((model.equals(c.getModel())) && (year == c.getManufacturingYear()) && (km == c.getDrivenKM()) && (price == c.getPrice())) {
                                rCar += "";
                            }else{
                                rCar += model + "\n" + year + "\n" + km + "\n" + price + "\n";
                            }
                        }
                    }
                }
            }

            byte[] listOfCars = rCar.getBytes();
            fin.close();

            FileOutputStream fout = new FileOutputStream(f);
            fout.write(listOfCars);
            fout.close();

        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
