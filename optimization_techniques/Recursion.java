
/**
 * Demonstração de recursão com cálculo fatorial e soma de elementos de um array.
 * Também testa o limite da pilha de chamadas da JVM.
 *
 * @author tanuri
 */
public class Recursion {

    public static void main(String[] args) {

        // Testando o cálculo fatorial de 3
        int num = 3;
        int expected = 6;

        int given = factorial(num);
        System.out.println("Expected " + expected);
        System.out.println("Given " + given);
        System.out.println("Passed " + (given == expected));

        // Teste com array grande (provável StackOverflowError se n for muito alto)
        int[] nums = new int[15000]; // A JVM geralmente suporta ~5000 a 10000 chamadas recursivas

        try {
            expected = 0; // O array está inicializado com 0, então a soma esperada é 0
            given = sumArray(nums, 0);

            System.out.println("Expected " + expected);
            System.out.println("Given " + given);
            System.out.println("Passed " + (given == expected));

        } catch (StackOverflowError e) {
            System.err.println("Erro: StackOverflowError! O número de chamadas recursivas foi muito alto.");
        }
    }

    /**
     * Calcula o fatorial de um número usando recursão.
     *
     * Exemplo: factorial(3) → 3 * factorial(2) → 3 * (2 * factorial(1)) → 3 * 2
     * * 1 = 6
     *
     * @param i número para calcular o fatorial.
     * @return o fatorial de i.
     */
    private static int factorial(int i) {

        // Imprime a estrutura da recursão
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
        System.out.print("Chamando factorial(" + i + ")\n");

        int result;

        if (i == 1) {
            result = 1;
        } else {
            result = i * factorial(i - 1);
        }

        // Imprime a estrutura da recursão ao retornar
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
        System.out.print("Retornando: " + result + "\n");

        return result;
    }

    /**
     * Soma todos os elementos de um array de forma recursiva.
     *
     * @param arr Array de inteiros.
     * @param index Índice atual a ser somado.
     * @return Soma de todos os elementos do array.
     */
    private static int sumArray(int[] arr, int index) {
        if (arr.length == index) {
            return 0;
        }
        return arr[index] + sumArray(arr, index + 1);
    }
}
