/**
 *
 * @author tanuri
 */
public class PalindromeSolvedWithTwoPointer {

    public boolean isPalindrome(String s) {

        // pode ser solucionado com two pointer otimizando o resultado para O(n) em
        // tempo e espaço
        // Requer retirada de caracters especiais, e lowercase
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

}
