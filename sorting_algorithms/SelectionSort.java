class SelectionSort {

    public static void main(String a[]) {
        int[] nums = {9, 1, 6, 3, 7};
        sort(nums);

        int[] expected = {1, 3, 6, 7, 9};

        System.err.println("given");
        printArray(nums);
        System.err.println("\nexpected");
        printArray(expected);
        System.err.println("\npassed: " + test(nums, expected));
    }

    private static void sort(int[] nums) {
        // Passo 1: Percorrer o array do primeiro ao penúltimo elemento
        // Passo 2: Para cada iteração, procurar o menor número na parte não ordenada do array
        // Passo 3: Se encontrar um número menor, fazer a troca
        // Passo 4: Repetir até o fim do array
        // O algoritmo usa dois loops: 
        //  - O loop externo percorre de 0 até a penúltima posição
        //  - O loop interno percorre a parte não ordenada, ou seja, de i+1 até o final do array

        for (int i = 0; i < nums.length - 1; i++) {
            int minorIndex = i;
            int currentIndex = i; 

            for (int j = i + 1; j < nums.length; j++) {
                int next = nums[j];
                if(next < nums[minorIndex]){
                    minorIndex = j;
                }
            }

            if(currentIndex!=minorIndex){
                 int temp = nums[currentIndex];
                 nums[currentIndex] = nums[minorIndex];
                 nums[minorIndex] = temp;
            }
        }

        // Este método tem complexidade O(n²), ou seja, seu tempo de execução cresce de forma quadrática.
        // Isso significa que, se dobrarmos o tamanho do array, o número de operações será multiplicado por 4.
        // Portanto, este algoritmo é indicado apenas para arrays pequenos, pois para entradas grandes se torna impraticável.
        // Exemplo: Se o tamanho do array for 10⁵ (100.000 elementos), o número de operações será:
        //    (100.000)² = 10.000.000.000 (10 bilhões de operações), tornando a execução inviável.
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }

    private static boolean test(int[] given, int[] expected) {
        if (given.length != expected.length) return false;
        for (int i = 0; i < given.length; i++) {
            if (given[i] != expected[i]) return false;
        }
        return true;
    }
}
