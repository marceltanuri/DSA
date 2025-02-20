
class CountingFrequencyFixedArray {

    public boolean areOccurrencesEqual(String s) {
        // Array para armazenar a frequência de cada caractere (26 letras do alfabeto)
        int[] freq = new int[26];

        // Contagem de ocorrências dos caracteres (O(n))
        for (char c : s.toCharArray()) {
            freq[c - 'a']++; // Mapeia 'a' para 0, 'b' para 1, ..., 'z' para 25
        }

        // Encontrar a primeira frequência não zero como referência
        int targetFreq = 0;
        for (int count : freq) {
            if (count > 0) {
                targetFreq = count;
                break;
            }
        }

        // Verificar se todas as frequências são iguais (O(26) ≈ O(1))
        for (int count : freq) {
            if (count > 0 && count != targetFreq) {
                return false;
            }
        }

        return true;
    }
}
