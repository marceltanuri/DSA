package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFS {

    // Código explicado passo a passo para buscas BFS. Este exemplo é para fins didáticos e não reflete a melhor abordagem possível para o problema em questão. Não foi utilizado por exemplo Multi Source BFS para resolver o problema, pois esse conceito ainda será visto a seguir.

    // possiveis direções de expansão da BFS
    public static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int bfsCalls = 0; // Contador de chamadas BFS

    public static void main(String[] args) {
        // Exemplo 1
        int[][] matrix1 = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        System.out.println("Exemplo 1: Matriz de distâncias:");
        printMatrix(updateMatrix(matrix1));

        // Exemplo 2
        int[][] matrix2 = {
                {1, 1, 0},
                {1, 1, 1},
                {1, 0, 1}
        };
        System.out.println("\nExemplo 2: Matriz de distâncias:");
        printMatrix(updateMatrix(matrix2));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];

        bfsCalls = 0; // Reset contador

        // Chama BFS para TODAS as células (inclusive 0s)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = bfs(mat, i, j); // Executa BFS para encontrar o 0 mais próximo
            }
        }

        System.out.println("Total de chamadas BFS: " + bfsCalls);
        return dist;
    }

    // BFS para encontrar a distância até o 0 mais próximo
    private static int bfs(int[][] mat, int x, int y) {

        bfsCalls++; // Conta quantas vezes BFS foi chamado

        // altura e largura da matriz
        int m = mat.length;
        int n = mat[0].length;

        // DEBUG: Exibir qual célula está chamando BFS
        System.out.println("Chamando BFS para (" + x + "," + y + ")");

        // BFS se baseia em um fila de operações busca, a ordem da fila é por proximidade.
        Queue<int[]> queue = new LinkedList<>();

        // BFS também utiliza um histórico de vértices que já foram analisadas, para otimização e para evitar loop infinito
        boolean[][] visited = new boolean[m][n];

        // Cada entrada na fila será um processamento de busca da BFS
        queue.offer(new int[]{x, y, 0}); // {linha, coluna, distância}
        visited[x][y] = true;

        // Inicia processamento da fila
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1], d = cell[2];

            // DEBUG: Exibir verificações de BFS
            System.out.println("   Verificando (" + i + "," + j + ") com distância " + d);

            // Se encontramos um 0, retornamos a distância
            // Aplica critério da pesquisa
            if (mat[i][j] == 0) {
                System.out.println("   Encontrado 0 na célula (" + i + "," + j + "), distância = " + d);
                return d;
            }

            // Expande para os vizinhos, se não atende critério
            for (int[] dir : DIRECTIONS) {
                int ni = i + dir[0], nj = j + dir[1];

                // verifica se os vértices são válidos (existem) e se não constam na lista de já verificados
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    // adiciona novo vértice a fila de processamento BFS
                    queue.offer(new int[]{ni, nj, d + 1});
                    visited[ni][nj] = true;
                }
            }
        }
        return Integer.MAX_VALUE; // Não deveria acontecer
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
