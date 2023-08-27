package tarea2.Ejercicio2.proccess;

import java.util.Objects;
public class JugadorFutbol {
    private String nombre;
    private int numeroJugador;
    private boolean esCapitan;
    private boolean tieneEquipo;

    //Implementacion de Constructor.
    public JugadorFutbol(String nombre, int numeroJugador, boolean esCapitan) {
        this.nombre = nombre;
        this.numeroJugador = numeroJugador;
        this.esCapitan = esCapitan;
        tieneEquipo = false;
    }

    public String getName() {
        return nombre;
    }

    public int obtNumeroJugador() {
        return numeroJugador;
    }

    public boolean obtEsCapitan() {
        return esCapitan;
    }

    public void obtEquipo(boolean tieneEquipo) {
        this.tieneEquipo = tieneEquipo;
    }

    @Override
    public String toString(){
            return "JugadorFutbol{" +
                    "nombre='" + nombre + '\'' +
                    ", numeroJugador=" + numeroJugador +
                    ", esCapitan=" + esCapitan +
                    '}';
        }

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JugadorFutbol that = (JugadorFutbol) o;
            return numeroJugador == that.numeroJugador && esCapitan == that.esCapitan && Objects.equals(nombre, that.nombre);
        }
    }

