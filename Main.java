import java.util.*;
import java.util.regex.Pattern;

public class Main {
    static String[] roman = new String[]{"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
    static String[] arabic = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static String result = "";
    static String letter1 = "";
    static String letter2 = "";

    public static void main(String[] args) {
        // write your code here
        System.out.println("Введите ваш пример :");
        Scanner scannerKeyIn = new Scanner(System.in);
        String keyOut = scannerKeyIn.next();
        // проверка на корректность с помощью регулярного выражения
        try {
            if(!Pattern.matches("(\\d+[\\-+/*]+\\d)|([XVI]{1,3}+[\\-+/*]+[XVI]{1,3})",keyOut)) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //Здесь начинается парсинг и передача его в массивы
        String[] operand = keyOut.split("\\W"); //Разделяет строку на слагаемые и записывает их в массив
        String[] operator = keyOut.split("\\w"); //Выделяет знак действия и записывает его в массив
        String num1 = operand[0];
        String num2 = operand[1];
        char op = operator[operator.length - 1].charAt(0);

        //
        try {
            if (isCorrect(arabic, num1) && (isCorrect(arabic, num2))) {
                System.out.println(operation(num1, num2, op));
            } else if (isCorrect(roman, num1) && (isCorrect(roman, num2))) {
                num1 = romanToArabic(num1);
                num2 = romanToArabic(num2);
                int arabicInt = operation(num1, num2, op);
                if (arabicInt >= 0) {
                    System.out.println(arabicToRoman(arabicInt));
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
        }
    }


    public static int operation(String num1, String num2, char op) {
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);
        switch (op) {

            case '*':
                return number1 * number2;
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '/':
                return number1 / number2;
            default:
                return 0;
        }
    }


    private static String romanToArabic(String romanLetter) {
        switch (romanLetter) {
            case "I":
                return "1";
            case "II":
                return "2";
            case "III":
                return "3";
            case "IV":
                return "4";
            case "V":
                return "5";
            case "VI":
                return "6";
            case "VII":
                return "7";
            case "VIII":
                return "8";
            case "IX":
                return "9";
            case "X":
                return "10";
            default:
                return "";
        }
    }

    public static String arabicToRoman(int arabicInt) {
        String[] romanArray = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCII", "XCVIII", "XCIX", "C"
        };
        String romanResult = romanArray[arabicInt];
        return romanResult;


    }

    public static boolean isCorrect(String[] arr, String toCheckValue) {
        for (String element : arr) {
            if (element.equals(toCheckValue)) {
                return true;
            }
        }
        return false;


    }
}
