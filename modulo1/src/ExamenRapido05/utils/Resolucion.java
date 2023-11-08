/**
 * Miguel Gutiérrez AL03035575 IDS
 */

package ExamenRapido05.utils;

/**
 * La presente clase se encarga de encontrar las soluciones
 * posibles ante el problema central abordado en este algoritmo:
 */
public class Resolucion {
    private static final int N = 8;
    private Tablero tablero = new Tablero(N);
    public void solve() {
        resolucion(0);
    }
    private void resolucion(int row) {
        if (row == N) {
            tablero.printBoard();
            return;
        }
        for (int col = 0; col < N; col++) {
            if (tablero.esViable(row, col)) {
                tablero.casillaReina(row, col);
                resolucion(row + 1);
                tablero.removerReina(row, col);
            }
        }
    }
}
