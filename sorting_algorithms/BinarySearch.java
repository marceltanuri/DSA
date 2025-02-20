
/**
 * Implementação da Busca Binária usando Recursão.
 *
 * @author tanuri
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        int expected = 2;
        int given = search(nums, 3);
        System.out.println("Expected: " + expected);
        System.out.println("Given: " + given);
        System.out.println("Passed: " + (expected == given));

        // Teste para número ausente
        expected = -1;
        given = search(nums, 10);
        System.out.println("Expected: " + expected);
        System.out.println("Given: " + given);
        System.out.println("Passed: " + (expected == given));
    }

    /**
     * Método de busca binária recursiva com sobrecarga.
     *
     * @param arr Array ordenado onde a busca será realizada.
     * @param target Valor a ser encontrado.
     * @return Índice do elemento encontrado ou -1 se não estiver no array.
     */
    public static int search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    /**
     * Implementação recursiva da busca binária.
     *
     * @param arr Array ordenado.
     * @param target Valor a ser buscado.
     * @param start Índice inicial da busca.
     * @param end Índice final da busca.
     * @return Índice do elemento encontrado ou -1 se não estiver presente.
     */
    private static int search(int[] arr, int target, int start, int end) {
        if (start > end) { // Caso base: o número não está no array
            return -1;
        }

        int mid = start + (end - start) / 2; // Pega o meio do intervalo

        if (arr[mid] == target) {
            return mid; // Elemento encontrado
        } else if (arr[mid] > target) {
            return search(arr, target, start, mid - 1); // Busca na metade esquerda
        } else {
            return search(arr, target, mid + 1, end); // Busca na metade direita
        }
    }
}
