import java.io.*;
import java.util.Scanner;

public class ProgramaDonacionSangre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DonacionSangre donacionSangre = new DonacionSangre();

        int opcion;
        do {
            System.out.println("Menú Principal");
            System.out.println("1. Registrarse como donante");
            System.out.println("2. Donar sangre");
            System.out.println("3. Borrar donador");
            System.out.println("4. Retirar unidad de sangre");
            System.out.println("5. Consultar stock de unidades de sangre");
            System.out.println("6. Agregar nueva cantidad de unidades donadas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    donacionSangre.menuRegistrarDonante();
                    break;
                case 2:
                    donacionSangre.donarSangre();
                    break;
                case 3:
                    donacionSangre.borrarDonador();
                    break;
                case 4:
                    donacionSangre.retirarUnidadSangre();
                    break;
                case 5:
                    donacionSangre.consultarStock();
                    break;
                case 6:
                    donacionSangre.agregarCantidadDonada();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 7);
        
        scanner.close();
    }
}

class DonacionSangre {
    private static final String ARCHIVO_DONANTES = "donantes.txt";

    public void menuRegistrarDonante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menú para Registrar Donante");
        System.out.print("Ingrese el nombre del donante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del donante: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el tipo de sangre del donante: ");
        String tipoSangre = scanner.nextLine();
        
        try {
            FileWriter fileWriter = new FileWriter(ARCHIVO_DONANTES, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            
            printWriter.println(nombre + "," + apellido + "," + tipoSangre);
            
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
            
            System.out.println("Donante registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al registrar el donante.");
            e.printStackTrace();
        }
        
        scanner.close();
    }

    public void donarSangre() {
        // Implementación de la donación de sangre
        System.out.println("Donando sangre...");
    }

    public void borrarDonador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menú para Borrar Donador");
        System.out.print("Ingrese el nombre del donador a borrar: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del donador a borrar: ");
        String apellido = scanner.nextLine();

        try {
            File archivo = new File(ARCHIVO_DONANTES);
            File archivoTemp = new File("temp.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoTemp));

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (!datos[0].equals(nombre) || !datos[1].equals(apellido)) {
                    bufferedWriter.write(linea + "\n");
                }
            }

            bufferedReader.close();
            bufferedWriter.close();

            archivo.delete();
            archivoTemp.renameTo(new File(ARCHIVO_DONANTES));

            System.out.println("Donador borrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al borrar el donador.");
            e.printStackTrace();
        }

        scanner.close();
    }

    public void retirarUnidadSangre() {
        // Implementación para retirar unidad de sangre
        System.out.println("Retirando unidad de sangre...");
    }

    public void consultarStock() {
        // Implementación para consultar stock de unidades de sangre
        System.out.println("Consultando stock de unidades de sangre...");
    }

    public void agregarCantidadDonada() {
        // Implementación para agregar nueva cantidad de unidades donadas
        System.out.println("Agregando nueva cantidad de unidades donadas...");
    }
}