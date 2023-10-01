package tarea07.MOrdenamiento;

public class Metricas {
    private int comparativa;
    private int movimientos;

    public Metricas() {
        comparativa = 0;
        movimientos = 0;
    }

    public void masComparativa() {
        comparativa++;
    }

    public void masMovimientos() {
        movimientos++;
    }

    public int getComparativa() {
        return comparativa;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void repetir() {
        comparativa = 0;
        movimientos = 0;
    }
}
