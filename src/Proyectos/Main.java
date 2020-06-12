package Proyectos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
/*El sistema debe manejar 3 tipos de objetos: la escuela, el estudiante y los maestros.
El sistema debe llevar el control de las finanzas de la escuela,
 controlando las deudas de los estudiantes y lo que se les debe pagar a los maestros.
  Una vez finalizado el sistema debe tener:
Un objeto de escuela con estudiantes, maestros, ingresos y egresos
Un objeto maestro con  un nombre, un id y un salario
Un objeto estudiante con un nombre, un id, un grado, pagos realizados y el total de pagos.*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Escuela escuela = new Escuela();
        menu menu = new menu();
        boolean salir = false;
        while (!salir)
        {
            menu.principal();
            try
            {
                int opcion = sc.nextInt();
                switch (opcion)
                {
                    case 1:
                        boolean salir1 = false;
                        while (!salir1)
                        {
                            menu.estudiante();
                            try
                            {
                                int opcion1 = sc.nextInt();
                                switch (opcion1)
                                {
                                    case 1:
                                    escuela.realizarPago();
                                        break;
                                    case 2:
                                        escuela.mostrarPagosRealizados();
                                        break;
                                    case 3:
                                        salir1 = true;
                                        break;
                                    default:
                                        System.err.println("Ingrese un numero valido");
                                        System.out.println(" ");
                                        break;
                                }
                            }catch (InputMismatchException e)
                                {
                                    System.err.println("Ingrese un numero valido");
                                    System.out.println(" ");
                                    sc.next();
                                }
                        }
                        break;
                    case 2:
                        boolean salir2 = false;
                        while(!salir2)
                        {
                            menu.escuela();
                            try
                            {
                                int opcion2 = sc.nextInt();
                                switch (opcion2)
                                {
                                    case 1:
                                        boolean salir3 = false;
                                        while (!salir3)
                                        {
                                            menu.ingreso();
                                            try
                                            {
                                                int opcion3 = sc.nextInt();
                                                switch (opcion3)
                                                {
                                                    case 1:
                                                        escuela.ingresarEstudiante();
                                                        break;
                                                    case 2:
                                                        escuela.ingresarMaestro();
                                                        break;
                                                    case 3:
                                                        salir3 = true;
                                                        break;
                                                    default:
                                                        System.err.println("Ingrese un numero valido");
                                                        System.out.println(" ");
                                                }
                                            }catch (InputMismatchException e)
                                                {
                                                    System.err.println("Ingrese un numero valido");
                                                    System.out.println(" ");
                                                    sc.next();
                                                }
                                        }
                                        break;
                                    case 2:
                                        escuela.mostrarIngresos();
                                        break;
                                    case 3:
                                        escuela.mostrarDeudas();
                                        break;
                                    case 4:
                                        salir2 = true;
                                        break;
                                    default:
                                        System.err.println("Ingrese un numero valido");
                                        System.out.println(" ");
                                        break;
                                }
                            }catch (InputMismatchException e)
                                {
                                    System.err.println("Ingrese un numero valido");
                                    System.out.println(" ");
                                    sc.next();
                                }
                        }
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.err.println("Ingrese un numero valido");
                        System.out.println(" ");
                }
            }catch (InputMismatchException e)
                {
                    System.err.println("Ingrese un numero valido");
                    System.out.println(" ");
                    sc.next();
                }

        }












































































































    }
}
