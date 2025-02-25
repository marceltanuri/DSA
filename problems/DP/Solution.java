package DP;

class Solution {
    public int rob(int[] nums) {
        int twoHousesAgo = 0;  // i-2 → Máximo acumulado sem incluir a casa anterior
        int oneHouseAgo = 0;   // i-1 → Máximo acumulado até a casa anterior

        System.out.printf("%-10s %-10s %-15s %-15s %-15s%n", 
                          "Casa (i)", "Valor", "i-2 ", "i-1 ", "Melhor Escolha");

        for (int i = 0; i < nums.length; i++) {
            
            int bestChoice = Math.max(oneHouseAgo, twoHousesAgo + nums[i]);

            // Mostrando a escolha no print
            System.out.printf("%-10d %-10d %-15d %-15d %-15d%n", 
                              i, nums[i], twoHousesAgo, oneHouseAgo, bestChoice);

            twoHousesAgo = oneHouseAgo;  // i-2 agora vira i-1
            oneHouseAgo = bestChoice;   // i-1 agora vira a nova melhor escolha
        }

        return oneHouseAgo;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 5, 10, 1};  // Exemplo de entrada
        int maxMoney = solution.rob(nums);
        System.out.println("\n💰 Máximo que pode ser roubado: " + maxMoney);
    }
}
