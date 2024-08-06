package basededatosalumnos;

import java.util.Scanner;

public class BaseDeDatosAlumnos {

    public static void main(String[] args) {
        //Creando arreglo de estudiantes
        Estudiante datos[] = new Estudiante[10];
        int op = 0;
        Scanner teclado = new Scanner(System.in);
        Scanner letras = new Scanner(System.in);
        while (op != 5) {
            System.out.println("1. Nuevo alumno");
            System.out.println("2. Ver alumnos");
            System.out.println("3. Buscar alumnos");
            System.out.println("4. Modificar alumnos");
            System.out.println("5. Salir");
            System.out.println("Ingrese el numero de opcion:");
            op = teclado.nextInt();

            System.out.println("-----Nuevo alumno-----");
            if (op == 1) {
                System.out.println("Ingrese la clave");
                int clave = teclado.nextInt();
                System.out.println("Ingrese el nombre");
                String nombre = letras.nextLine();
                System.out.println("Ingrese el grado");
                String grado = letras.nextLine();
                System.out.println(NuevoAlum(clave, nombre, grado, datos));
            } else if (op == 2) {
                System.out.println(Imprimir(datos));
            } else if (op == 3) {
                System.out.println("-----Nuevo alumno-----");
                System.out.println("Ingrese la clave");
                int clave = teclado.nextInt();
                System.out.println(buscarAlumno(clave, datos));
            } else if (op == 4) {
                System.out.println("Ingrese la clave");
                int clave = teclado.nextInt();
                if (ModificarAlumBooleano(clave, datos)) {
                    System.out.println("Ingrese el nuevo nombre");
                    String nombre = letras.nextLine();
                    System.out.println("Ingrese el nuevo grado");
                    String grado = letras.nextLine();
                    System.out.println(ModificarDatos(clave, nombre, grado, datos));
                } else {
                    System.out.println("No existe la clave");
                }
            }
        }
    }

    public static String NuevoAlum(int clave, String nombre, String grado, Estudiante arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new Estudiante(clave, nombre, grado);
                lleno = false;
                break;
            } else if (arreglo[i].getClave() == clave) {
                return "Clave existente";
            }
        }
        if (!lleno) {
            return "Se guardo con exito";
        } else {
            return "Sin espacio";
        }
    }

    public static String Imprimir(Estudiante arreglo[]) {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + arreglo[i].getClave() + "|" + arreglo[i].getNombre() + "|" + arreglo[i].getGrado() + "\n";
            }
        }
        return cadena;
    }

    public static String buscarAlumno(int clave, Estudiante arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                return "Los datos son: \nNombre: " + arreglo[i].getNombre() + "\n" + "Grado: " + arreglo[i].getGrado();
            }
        }
        return "No existe la clave ingresada";
    }

    public static boolean ModificarAlumBooleano(int clave, Estudiante arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                return true;
            }
        }
        return false;
    }

    public static String ModificarDatos(int clave, String nombre, String grado, Estudiante arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                arreglo[i].setNombre(nombre);
                arreglo[i].setGrado(grado);
                return "Se actualizo con exito";
            }
        }
        return "";
    }
}
