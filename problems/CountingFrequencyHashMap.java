
import java.util.HashMap;

class CountingFrequencyHashMap {

    public boolean areOccurrencesEqual(String s) {

        // usar um hashMap para contar ocorrencias, complexidade O(n) para escrever o map e O(n) no pior caso para ler
        HashMap<Character, Integer> charOccur = new HashMap<>();

        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            charOccur.put(c, (charOccur.getOrDefault(c, 0) + 1));
        }

        int frequency = charOccur.values().iterator().next();

        for (int f : charOccur.values()) {
            if (f != frequency) {
                return false;
            }
        }

        return true;

    }
}
