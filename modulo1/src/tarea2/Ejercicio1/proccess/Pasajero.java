/*
Crear una aplicación que controle una lista de pasajeros de autobuses.
 */

package tarea2.Ejercicio1.proccess;

import java.util.Objects;
public class Pasajero {
    private String nombre;
    private int boleto;
    private boolean trueBoleto;

    //Impelementación del Constructor:
    public Pasajero(String nombre, int boleto)
    {
        this.nombre = nombre;
        this. boleto = boleto;
        this. trueBoleto = true;
    }

    public Pasajero(String nombre)
    {
        this.nombre = nombre;
        this.boleto = -1;
        this.trueBoleto = false;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getBoleto()
    {
        return boleto;
    }

    public boolean isTrueBoleto()
    {
        return trueBoleto;
    }

    @Override
    public String toString()
    {
        return "JugadorFutbol{" +
                "nombre='" + nombre + '\'' +
                ", boleto=" + boleto +
                ", trueBoleto=" + trueBoleto +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasajero otroPasajero = (Pasajero) o;
        return boleto == otroPasajero.boleto && trueBoleto == otroPasajero.trueBoleto && Objects.equals(nombre, otroPasajero.nombre);
    }
}
