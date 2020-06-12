package Proyectos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Escuela {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Maestro> maestros = new ArrayList<>();
    private ArrayList<Double> ingresos = new ArrayList<Double>();
    private int corr;
    private int corr2 = 1;

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Maestro> getMaestros() {
        return maestros;
    }

    public void setMaestros(ArrayList<Maestro> maestros) {
        this.maestros = maestros;
    }

    public void agregarMaestro(String nombre)
    {

    }

    public void ingresarEstudiante()
    {
        Scanner sc = new Scanner(System.in);
        Estudiante estudiante = new Estudiante();

        System.out.println("Ingrese el nombre del estudiante:");
        String nombre = sc.nextLine();
        estudiante.setNombre(nombre);
        System.out.println("Ingrese el grado del estudiante:");
        estudiante.setGrado();
        generarID(estudiante);
        System.out.println("Estudiante ingresado con ID: " + estudiante.getId());
        estudiantes.add(estudiante);
        corr++;

    }

    public void ingresarMaestro()
    {
      LectorTeclado lt = new LectorTeclado();
      Scanner sc = new Scanner(System.in);
      Maestro maestro = new Maestro();

        System.out.println("Ingrese el nombre del maestro:");
        String nombre = sc.nextLine();
        maestro.setNombre(nombre);
        System.out.println("Ingrese el salario del maestro");
        System.out.print("L.");
        double salario = lt.obtenerDoubleValidado("Ingrese un numero");
        maestro.setSalario(salario);
        generarIDMaestro(maestro);
        System.out.println("Maestro ingresado con ID: "+ maestro.getId());
        maestros.add(maestro);
    }

    public void mostrarIngresos()
    {
        System.out.println("Total de dinero ingresado:");
        double total = 0;
        for (int i = 0; i < ingresos.size(); i++)
        {
            total = total + ingresos.get(i);
        }
        System.out.print("L.");
        System.out.println(total);
    }

    public void mostrarDeudas()
    {
        System.out.println("Total a pagar a maestros:");
        double total = 0;
        for (int i = 0; i < maestros.size(); i++)
        {
            total = total + maestros.get(i).getSalario();
        }
        System.out.print("L."+total);
        System.out.println(" ");
    }

    public void realizarPago()
    {
        Scanner sc = new Scanner(System.in);
        LectorTeclado lt = LectorTeclado.getInstance();
        System.out.println("Porfavor ingrese su id:");
        boolean salir = false;
        while (!salir)
        {
            int control = 0;
            String id = sc.nextLine();
            for (int i = 0; i < estudiantes.size(); i++)
            {
                if (id.equals(estudiantes.get(i).getId()))
                {
                    System.out.println("Nombre: " + estudiantes.get(i).getNombre());
                    System.out.println("Grado: " + estudiantes.get(i).getGrado());
                    System.out.println("Ingrese la cantidad que desea pagar:");
                    System.out.print("L.");
                    double pago = lt.obtenerDoubleValidado("Ingrese una cantidad valida");
                    ingresos.add(pago);
                    estudiantes.get(i).agregarPago(pago);
                    System.out.println(" -------------------------");
                    System.out.println(" Pago realizado con exito ");
                    System.out.println(" -------------------------");
                    salir = true;
                    break;
                }
                control++;
            }
            if (control == estudiantes.size())
            {
                System.out.println("ID invalido");
            }
        }

    }
    public void mostrarPagosRealizados()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese su id:");
        boolean salir = false;
        while (!salir)
        {
            int control = 0;
            String id = sc.nextLine();
            double total = 0;
            for (int i = 0; i < estudiantes.size(); i++)
            {
                if (id.equals(estudiantes.get(i).getId()))
                {
                    System.out.println("Nombre: " + estudiantes.get(i).getNombre());
                    System.out.println("Grado: " + estudiantes.get(i).getGrado());
                    System.out.println("Usted ha realizado los siguientes pagos: ");
                    for (int j = 0; j < estudiantes.get(i).getPagosSize(); j++ )
                    {
                        System.out.print((j+1)+".");
                        System.out.print("L.");
                        System.out.println(estudiantes.get(i).getPagosRealizados(j));
                        total = total + estudiantes.get(i).getPagosRealizados(j);
                    }
                    break;
                }
                control++;
            }
            if (control == estudiantes.size())
            {
                System.out.println("ID invalido");
            }else{
                System.out.println("Con un total de: ");
                System.out.print("L.");
                System.out.println(total);
                salir = true;
            }

        }

    }

    public void generarID(Estudiante estudiante)
    {
        Random random = new Random();
        boolean unico = false;

        while(!unico){
            String id = "2020" + estudiante.getGrado();
            for(int i=0; i<4; i++){
                id = id + random.nextInt(10);
            }

            unico = true;

            for(int i=0; i<estudiantes.size(); i++){
                Estudiante estComp = estudiantes.get(i);
                if(estComp.getId().equals(id)){
                    unico = false;
                    break;
                }
            }
            estudiante.setId(id);
        }
    }

    public void generarIDMaestro(Maestro maestro)
    {
        Random random = new Random();
        boolean unico = false;

        while(!unico){
            String id = "2020";
            for(int i=0; i<4; i++){
                id = id + random.nextInt(10);
            }

            unico = true;

            for(int i=0; i<maestros.size(); i++){
                Maestro estComp = maestros.get(i);
                if(estComp.getId().equals(id)){
                    unico = false;
                    break;
                }
            }
            maestro.setId(id);
        }
    }


}
