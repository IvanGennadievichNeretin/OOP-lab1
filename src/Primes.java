import java.io.PrintStream;

/**
 * Программа "Простые числа" находит и выводит в консоль простые числа от 2 до 100 включительно.
 * @author Иван
 * @version 1.0
 * @since 23.03.2020
 * **/

public class Primes {
    private static int MAX_COUNT_OF_FINDING_PRIMES = 50; //максимальный делитель
    private static int COUNT_OF_NUMBERS = 100; //количество чисел на входе

    //входная точка программы
    public static void main(String[] args){

        //ввод и проверка кодировки вывода в консоль
        String consoleEncoding = System.getProperty("consoleEncoding");
        if (consoleEncoding != null) {
            try {
                System.setOut(new PrintStream(System.out, true, consoleEncoding));
            } catch (java.io.UnsupportedEncodingException ex) {
                System.err.println("Unsupported encoding set for console: "+consoleEncoding);
            }
        }

        //выполнение программы
        System.out.println("Простые числа:");
        for (int i = 2; i <= COUNT_OF_NUMBERS; i++){
            //если число простое, выводим его
            if (IsPrime(i)){
                System.out.println(i);
            }
        }
        System.out.println("Конец");
    }

    //функция, определяющая, является ли число простым или нет. Возвращает true, если число простое
    public static boolean IsPrime(int x){
        for (int i = 2; i < MAX_COUNT_OF_FINDING_PRIMES; i++){
            //число не простое, если оно делится на какое-то другое число, но не само на себя
            if (((x % i) == 0) && (x > i)){
                return false;
            }
        }
        //если делителей числа не нашлось, значит, число простое
        return true;
    }
}

