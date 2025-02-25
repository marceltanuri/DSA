package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixMultiSourceBFS {

    public static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        // Exemplo 1
        int[][] matrix1 = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        System.out.println("Exemplo 1: Matriz de distâncias:");
        int[][] matrix = updateMatrix(matrix1);
        printMatrix(matrix);

        // Exemplo 2
        int[][] matrix2 = {
                {1, 1, 0},
                {1, 1, 1},
                {1, 0, 1}
        };
        System.out.println("\nExemplo 2: Matriz de distâncias:");
        int[][] matrix3 = updateMatrix(matrix2);
        printMatrix(matrix3);
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        System.out.println("\n=== Inicializando Fila com os 0s ===");
        // Inicializa a matriz de distâncias e adiciona todos os `0s` na fila
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j}); // Adiciona `0s` para BFS começar daqui
                    System.out.println("Adicionando (0) na fila: (" + i + "," + j + ")");
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // Inicializa `1s` com "infinito"
                }
            }
        }

        System.out.println("\n=== Iniciando BFS Multi-source ===");
        // Executa BFS a partir de todos os `0s` ao mesmo tempo
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];

            System.out.println("Processando célula: (" + i + "," + j + ") com distância " + dist[i][j]);

            for (int[] dir : DIRECTIONS) {
                int ni = i + dir[0], nj = j + dir[1];

                // Se for uma célula válida e a distância pode ser melhorada
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    if (dist[ni][nj] > dist[i][j] + 1) {
                        System.out.println("   Atualizando célula (" + ni + "," + nj + ") para distância " + (dist[i][j] + 1));
                        dist[ni][nj] = dist[i][j] + 1;
                        queue.offer(new int[]{ni, nj}); // Adiciona na fila para continuar a expansão
                    }
                }
            }
        }

        System.out.println("\n=== BFS Concluído! ===");
        return dist;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
