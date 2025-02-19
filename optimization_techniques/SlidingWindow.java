
import java.util.Arrays;


public class SlidingWindow {

    public static void main(String[] args) {

        // Encontrar a diferença entre o maior e menor valor de um subarray de tamanho k

        // para operações em subarrays a técnica sliding window pode ser uma boa opção podendo reduzir a complexidade de tempo de O(n^k) para O(n), podendo ser necessário dependendo do caso que o array esteja ordenado.

        // Em caso de ordenação de array a complexidade normalmente chega a ordem de O(n log n) em casos de quick sort.

        // Sendo a complexidade da ordenação de maior ordem que a complexidade de percorrer o array, a complexidade final da solução é determinada como O(n log n), na análise assintótica. 

        // Há uma técnica alternativa de ordenação, a counting sort, a qual pode reduzir o tempo para tempo linear, no entanto o espaço deixa de ser contante podendo afetar o desempenho geral a depender do tamanho do array. Para esse exercício o quick sort se mostrou mais adequado.

        int[] nums = {9, 4, 1, 7};
        int k = 2;
        
        //The minimum possible difference is 2.
        int expected = 2;

        int minimumDiff = getMinimumDiff(nums, k);

        System.out.println("expected: " + expected);
        System.out.println("given: " + minimumDiff);
        System.out.println("passed: " + (expected == minimumDiff));


    }

    public static int getMinimumDiff(int[] nums, int k) {

        if(k<=1 || nums.length<=1) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        int slide = k-1;
        for(int i = 0; i < nums.length - slide; i++){
            int windowDiff = nums[i+slide] - nums[i];
            if(windowDiff < minDiff){
                minDiff = windowDiff;
            }
        }

        return minDiff;

    }

}
