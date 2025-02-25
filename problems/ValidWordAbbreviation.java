class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0;
        int abbrIndex = 0;

        while (abbrIndex < abbr.length()) {
            if (wordIndex >= word.length()) return false;

            char abbrChar = abbr.charAt(abbrIndex);
            
            // Se os caracteres forem iguais, avançamos ambos os índices
            if (wordIndex < word.length() && word.charAt(wordIndex) == abbrChar) {
                wordIndex++;
                abbrIndex++;
            } 
            // Se for um número, extraímos o valor
            else if (Character.isDigit(abbrChar) && abbrChar != '0') {

                int num = 0;
                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num * 10 + Character.getNumericValue(abbr.charAt(abbrIndex));
                    abbrIndex++;
                }

                wordIndex += num;
                if (wordIndex > word.length()) return false; // Se ultrapassar o tamanho da palavra
            } 
            // Se os caracteres não forem iguais e não for número, a abreviação é inválida
            else {
                return false;
            }
        }

        //Math.

        // A abreviação só é válida se ambos os índices chegarem ao final ao mesmo tempo
        return wordIndex == word.length();
    }
}
