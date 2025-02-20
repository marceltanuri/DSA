/**
 *
 * @author tanuri
 */
public class RomanNumbers {

    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int current = getValue(s.charAt(i));

            // Verifica se há um próximo caractere e se devemos subtrair
            if (i + 1 < length && current < getValue(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }

    private int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}
