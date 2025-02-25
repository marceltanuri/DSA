class ShortestDistanceString {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int index1 = -1, index2 = -1;
        int dist = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                index1 = i;
            } else if (wordsDict[i].equals(word2)) {
                index2 = i;
            }

            // Se ambos já foram encontrados, calcula a menor distância
            if (index1 >= 0 && index2 >= 0) {
                dist = Math.min(dist, Math.abs(index1 - index2));
            }
        }

        return dist;
    }
}
