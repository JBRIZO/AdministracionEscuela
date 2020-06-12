package Proyectos;

public class Maestro {
    private String nombre;
    private String id;
    private double salario;
    int corr = 1;

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        boolean salir = false;
        while(!salir)
        {
            if (salario < 0)
            {
                System.out.println("No puede tener un salario negativo");
            }else{
                this.salario = salario;
                salir = true;
            }
        }

    }




}
