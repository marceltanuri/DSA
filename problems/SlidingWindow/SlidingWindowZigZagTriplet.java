package SlidingWindow;

/**
 *
 * @author tanuri
 */
public class SlidingWindowZigZagTriplet {

    public int[] solution(int[] numbers) {
        int slide = 3; // Trabalhando com janelas
        if (numbers.length < slide) return new int[0]; // Retorna vazio se não houver espaço para uma janela
    
        int[] result = new int[numbers.length - slide + 1];
    
        for (int i = 0; i < result.length; i++) { // Ajustando limite correto
            int balance = 0;
    
            for (int j = 1; j < slide; j++) { // Processamos a janela
                if (numbers[i + j - 1] > numbers[i + j]) balance -= 1;
                else if (numbers[i + j - 1] < numbers[i + j]) balance += 1;
                else {
                    balance = 1; // Se houver número repetido, invalidamos a sequência
                    break;
                }
            }
    
            result[i] = (balance == 0) ? 1 : 0;
        }
    
        return result;
    }
    

}
