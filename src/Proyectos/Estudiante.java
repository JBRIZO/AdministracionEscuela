package Proyectos;

import java.util.ArrayList;
import java.util.Scanner;

public class Estudiante {
    private String nombre;
    private String id;
    private int grado;
    private ArrayList<Double> pagosRealizados = new ArrayList<Double>();
    private int totalDePagos;


    public Double getPagosRealizados(int indice) {
        return pagosRealizados.get(indice);
    }

    public int getPagosSize()
    {
        return pagosRealizados.size();
    }

    public void setPagosRealizados(ArrayList<Double> pagosRealizados) {
        this.pagosRealizados = pagosRealizados;
    }

    public int getTotalDePagos() {
        return totalDePagos;
    }

    public void setTotalDePagos(int totalDePagos) {
        this.totalDePagos = totalDePagos;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while (!salir)
        {
            int grado = sc.nextInt();
            if (grado <= 0)
            {
                System.out.println("No puede estar en un grado menor o igual a cero");
            }else
            {
                if (grado > 6)
                {
                    System.out.println("Esta escuela solo cuenta con 6 grados");
                }else
                {
                    this.grado = grado;
                    salir = true;
                }
            }
        }


    }


    public  void agregarPago(double pago)
    {
        this.pagosRealizados.add(pago);
    }

}
