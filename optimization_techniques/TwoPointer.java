import java.util.Arrays;

/**
 *
 * @author tanuri
 */
class TwoPointer {

    public static void main(String[] args) {
        // Técnica Two Pointers consiste em percorrer o array com dois seletores:
        // um no início e outro no fim. É útil para reduzir loops aninhados, tornando a 
        // busca mais eficiente ao evitar verificações desnecessárias.

        // Given an array nums of integers and integer k, return the maximum sum such 
        // that there exists i < j with nums[i] + nums[j] = sum and sum < k.
        // If no i, j exist satisfying this equation, return -1.

        /*
         * Input: nums = [34,23,1,24,75,33,54,8], k = 60
         * Output: 58
         * Explanation: We can use 34 and 24 to sum 58 which is less than 60.
         */
        int[] nums = {34, 23, 1, 24, 75, 33, 54, 8};
        int k = 60;
        int expected = 58;

        int given = findTwoSumLessThanK(nums, k);

        System.out.println("Expected: " + expected);
        System.out.println("Given: " + given);
        System.out.println("Passed: " + (given == expected));
    }

    private static int findTwoSumLessThanK(int[] nums, int k) {
        int maxSum = -1;

        // Ordenação do array para permitir o uso eficiente da técnica Two Pointers.
        // A ordenação melhora a busca por pares que satisfaçam a condição desejada.
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < k) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
                left++;

                // É possível prever quando o maior valor possível foi alcançado
                // satisfazendo a condição de ser menor que k. Uma vez atingido, 
                // podemos terminar o loop evitando operações desnecessárias. 
                // Embora isso não mude a avaliação assintótica da solução (continua sendo O(n log n)), 
                // pode melhorar ainda mais o tempo de processamento.
                if (maxSum == k - 1) {
                    break;
                }
            } else {
                right--;
            }
        }

        return maxSum;

        // A técnica Two Pointers junto com a ordenação do array simplificou a complexidade 
        // do algoritmo que seria O(n²) para O(n log n).
        // Uma vez ordenado o array, não foi necessário aninhar nenhum loop, pois percorremos 
        // o array com ponteiros simultâneos nas extremidades. De acordo com o target, 
        // ajustamos o ponteiro da esquerda ou da direita para encontrar a melhor soma possível.
    }
}
