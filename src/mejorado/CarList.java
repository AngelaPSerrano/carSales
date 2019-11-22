package mejorado;

import java.io.*;

public class CarList {
    private LineNumberReader lnr;
    private FileReader fin;
    private File f;

    // CONSTRUCTOR
    public CarList(String filename) {
        f = new File(filename);
    }

    // Método para abrir el fichero y el reader cada vez que se use un método
    private void openStream(){
        try{
            fin = new FileReader(f);
            lnr = new LineNumberReader(fin);
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    /* Este no lo habías pedido pero vivo en los mundos de Yuppi y me acabo de dar cuenta.
     * Método para contar todos los coches. Cada cuatro líneas cuenta un coche.
     * Sí, lo sé, puden colarmela aquí porque en alguna línea los datos no sean los requeridos.
     */
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

    /*
     * Método para contar los coches nuevos.
     * Lee las lineas y cuando llega a la línea donde se supone que estan los km, los parsea a int y lo cuenta si
     * tiene 0 km. Si no es parseable lanza un error.
     */
    public int countNewCars(){
        openStream();
        int count = 0, km;
        String line;
        try {
            while (lnr.readLine() != null) {
                if (lnr.readLine() != null) {
                    if ((line = lnr.readLine()) != null) {
                        try{
                            km =Integer.parseInt(line);
                            if(km == 0){
                                count++;
                            }
                        }catch(NumberFormatException e){
                            System.out.println("The file is damaged or not compatible. The action can't be performed.");
                        }
                        if(lnr.readLine()!= null) {
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

    /*
     * Método para encontrar el coche más caro.
     * Cuenta las líneas y cada una la parse (si necesario) para comprobar que los datos son validos para instanciar entregado.Car.
     * Lo único que hace si no lo son es ponerlos a 0 para no lanzar error al instanciarlo.
     */
    public Car mostExpensiveCar() {
        openStream();
        double expensive = 0, price;
        Car c = null;
        String model, line;
        int year, km;
        try {
            while ((model = lnr.readLine()) != null) {
                if ((line = lnr.readLine()) != null) {
                    year = Integer.parseInt(line);
                    if ((line = lnr.readLine()) != null) {
                        km = Integer.parseInt(line);
                        if ((line = lnr.readLine()) != null) {
                            price = Double.parseDouble(line);
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
        }catch (NumberFormatException e) {
            System.out.println("The file is damaged or not compatible. The action can't be performed.");
        }
            return c;
    }

    /*
     * Método para añadir un coche nuevo.
     * Escribe el toString de la instancia coche dado por argumentos transformado en Bytes.
     */
    public void addCar(Car c){
        try {
            FileOutputStream fout = new FileOutputStream(f,true);
            try {
                fout.write(c.toString().getBytes());
                System.out.println("entregado.Car added!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /*
     * Método para eliminar el coche dado por los argumentos.
     * Parsea los valores necesarios y si no son validos, los devuelve como -1(un valor no posible al instanciarlo)
     * Recogidos los datos instancia un entregado.Car  y con el metodo equalTo los compara.
     * Si no coinciden, lo incluye en el array de bytes que al final se escribe en el fichero.
     */
    public void removeCar(Car c){
        String model="", line;
        int year=-1, km=-1, count = 0;
        double price=-1;
        try {
            openStream();
            String rCar= "";
            while ((model = lnr.readLine()) != null) {
                if ((line = lnr.readLine()) != null) {
                    try{
                        year = Integer.parseInt(line);
                    }catch (NumberFormatException e){
                    }finally{
                        if ((line = lnr.readLine()) != null) {
                            try{
                                km = Integer.parseInt(line);
                            }catch (NumberFormatException e){
                            }finally{
                                if((line = lnr.readLine())!= null) {
                                    try {
                                        price = Double.parseDouble(line);
                                    } catch (NumberFormatException e) {
                                    }finally {
                                        Car aux = new Car(model, year, km, price);
                                        if (!aux.equalTo(c)) {
                                            rCar += model + "\n" + year + "\n" + km + "\n" + price + "\n";
                                        } else {
                                            count++;
                                            System.out.println("A coincident car has been deleted (" + count + ")");
                                        }
                                    }
                                }
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
