
import java.util.*;

//решение должно содержать данный класс
class Main {
    static String[] roman = new String[]{"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
    static String[] arabic = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static String num1 = "";
    static String num2 = "";
    static char op = ' ';
    static String result = "";
    static String letter1 = "";
    static String letter2 = "";
   
    public static void main(String[] args)
    {

        Scanner scannerKeyIn = new Scanner(System.in);
        String input = scannerKeyIn.next();
        calc(input);
    }
    //Решение должно содержать данный метод
    public static String calc(String inputString) throws Exception {
        //Твой код здесь
        //Здесь начинается парсинг и передача его в массивы

        String[] operand = inputString.split(" "); //Разделяет строку на слагаемые и записывает их в массив
        String[] operator = inputString.split(" "); //Выделяет знак действия и записывает его в массив
        String num1 = operand[0];
        String num2 = operand[2];
        char op = operator[1].charAt(0);
        List<String> arabicList = new ArrayList<>(Arrays.asList(arabic));
        List<String> romanList = new ArrayList<>(Arrays.asList(roman));
        try {
            if (arabicList.contains(num1) && arabicList.contains(num2)) {
                result = Integer.toString(operation(num1, num2, op));
                return result;

            } else if (romanList.contains(num1) && romanList.contains(num2)) {
                String letter1 = romanToArabic(num1);
                String letter2 = romanToArabic(num2);

                if (operation(letter1, letter2, op) < 0) {
                    throw new Exception();
                }

                result = Integer.toString(operation(letter1, letter2, op));
                result = arabicToRoman(result);
                return result;
            } else {
                throw new Exception();
            }
        }
        catch (Exception e) {return null;
        }
        return null;
    }
    private static int operation(String num1, String num2, char op) {
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
    private static String romanToArabic (String romanLetter) {
        switch (romanLetter) {
            case  "I" :return "1";
            case "II" :return "2";
            case "III" :return "3";
            case "IV" :return "4";
            case "V" :return "5";
            case "VI" :return "6";
            case "VII" :return "7";
            case "VIII" :return "8";
            case "IX" :return "9";
            case "X" :return "10";
            default: return "";
        }
    }
    public static String arabicToRoman (String arabicCurrent) {
        int arabicInt = Integer.parseInt(arabicCurrent);
        String[] romanArray = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                        "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                                                        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                                                                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                                                                                        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
        };
                           String romanResult = romanArray[arabicInt];
                           return romanResult;                                                                             
       
       
    }
}
