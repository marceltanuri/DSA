import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementação do problema 3Sum usando a técnica Two Pointers.
 *
 * O objetivo é encontrar todas as triplas (i, j, k) onde:
 * - nums[i] + nums[j] + nums[k] == 0
 * - i, j e k são índices distintos.
 * - As triplas devem ser únicas, ou seja, sem duplicatas no resultado final.
 *
 * A abordagem Two Pointers reduz a complexidade de O(n³) para O(n²).
 *
 * @author tanuri
 */
public class NestedTwoPointer {

    /*
     * Dado um array de inteiros nums[], retornar todas as triplas únicas [nums[i], nums[j], nums[k]]
     * onde a soma seja exatamente 0.
     *
     * Exemplo 1:
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explicação:
     * - (-1) + 0 + 1 = 0
     * - (-1) + (-1) + 2 = 0
     * - Apenas essas combinações são únicas.
     *
     * Exemplo 2:
     * Input: nums = [0,1,1]
     * Output: []
     * Explicação: Nenhuma combinação possível soma 0.
     *
     * Exemplo 3:
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explicação: A única tripla válida é [0,0,0].
     *
     * 📌 Restrições:
     * - 3 <= nums.length <= 3000
     * - -10^5 <= nums[i] <= 10^5
     *
     * 🔹 Complexidade:
     * - Ordenação: O(n log n)
     * - Loop principal: O(n)
     * - Two Pointers interno: O(n)
     * - Total: O(n²), muito mais eficiente do que O(n³).
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        // Utilizamos a técnica Two Pointers para reduzir a complexidade de O(n³) para O(n²).
        // Essa técnica funciona eficientemente apenas em arrays ordenados, por isso ordenamos primeiro.
        
        List<int[]> tempResult = new LinkedList<>();
        Arrays.sort(nums); // Ordenação necessária para Two Pointers funcionar

        int len = nums.length - 2; // Deixa espaço para os dois ponteiros (left e right)
        for (int i = 0; i < len; i++) {

            // Se nums[i] > 0, não há como obter soma zero, pois os números seguintes serão ainda maiores.
            // Como o array está ordenado, não faz sentido continuar, então encerramos o loop.
            if (nums[i] > 0) {
                break;
            }

            // Evita processar o mesmo número inicial múltiplas vezes, garantindo que cada tripla seja única.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    tempResult.add(new int[]{nums[i], nums[left], nums[right]});

                    // Remove as duplicatas no segundo item da tripla (left)
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Remove as duplicatas no terceiro item da tripla (right)
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        // Converte o resultado de List<int[]> para List<List<Integer>>
        List<List<Integer>> result = new ArrayList<>(tempResult.size());
        for (int[] triplet : tempResult) {
            result.add(Arrays.asList(triplet[0], triplet[1], triplet[2]));
        }

        return result;
    }
}
