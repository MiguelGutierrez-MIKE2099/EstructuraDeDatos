/**
 * Miguel Gutiérrez AL03035575 IDS
 */

package ExamenRapido05.utils;

/**
 * Esta clase se dedica a gestionar el estado del tablero.
 */
public class Tablero {
    private int dim;
    private int[] reinas;
    public Tablero(int dim) {
        this.dim = dim;
        reinas = new int[dim];
    }
    public boolean esViable(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (reinas[i] == col || reinas[i] - i == col - row || reinas[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }
    public void casillaReina(int row, int col) {
        reinas[row] = col;
    }
    public void removerReina(int row, int col) {
        reinas[row] = 0;
    }
    public void printBoard() {
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (reinas[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
