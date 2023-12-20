import com.sun.security.jgss.GSSUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static String intToRoman(int num) {
        return List.of("", "M", "MM", "MMM").get(num / 1000) +
                List.of("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM").get(num / 100 % 10) +
                List.of("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC").get(num / 10 % 10) +
                List.of("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX").get(num % 10);
    }
    public static int ConvertXToNormal(String x) throws Exception {
        int x1 = 0;
        switch(x){
            case "I":
                x1 = 1;
                break;
            case "II":
                x1 = 2;
                break;
            case "III":
                x1 = 4;
                break;
            case "IV":
                x1 = 4;
                break;
            case "V":
                x1 = 5;
                break;
            case "VI":
                x1 = 6;
                break;
            case "VII":
                x1 = 7;
                break;
            case "VIII":
                x1 = 8;
                break;
            case "IX":
                x1 = 9;
                break;
            case "X":
                x1 = 10;
                break;
            default:
                throw new Exception();
        }
        return x1;
    }
    public static int ConvertYToNormal(String y) throws Exception {
        int y1 = 0;
        switch(y){
            case "I":
                y1 = 1;
                break;
            case "II":
                y1 = 2;
                break;
            case "III":
                y1 = 4;
                break;
            case "IV":
                y1 = 4;
                break;
            case "V":
                y1 = 5;
                break;
            case "VI":
                y1 = 6;
                break;
            case "VII":
                y1 = 7;
                break;
            case "VIII":
                y1 = 8;
                break;
            case "IX":
                y1 = 9;
                break;
            case "X":
                y1 = 10;
                break;
            default:
                throw new Exception();
        }
        return y1;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String vir = scan.nextLine();

        String[] operands = vir.split(" ");

        if (operands.length > 3){
            throw new Exception();
        }

        var first = operands[0];
        var opp = operands[1];
        var second = operands[2];
        int firstnum = 0;
        int secondnum = 0;



        if (isDigit(first) != true && isDigit(second) != true){
            firstnum = ConvertXToNormal(first);
            secondnum = ConvertYToNormal(second);
            //Проверяется, чтобы результат в римских числах был больше 0 и чтобы сами числа были от 1 до 10
            if (firstnum >= 1 && firstnum <= 10 && secondnum >= 1 && secondnum <= 10){
                //Switch с выбором действия для вычислений
                switch (opp){
                    case "/":
                        if (firstnum/secondnum >= 0){
                            System.out.println(intToRoman(firstnum/secondnum));
                        }
                        break;
                    case "*":
                        if (firstnum*secondnum >= 0){
                            System.out.println(intToRoman(firstnum*secondnum));
                        }
                        break;
                    case "+":
                        if (firstnum+secondnum >= 0){
                            System.out.println(intToRoman(firstnum+secondnum));
                        }
                        break;
                    case "-":
                        if (firstnum-secondnum >= 0){
                            System.out.println(intToRoman(firstnum-secondnum));
                        }
                        break;
                    default:
                        throw new Exception();
                }
            }
            else throw new Exception();
        }
        else if((isDigit(first) != true || isDigit(second) != true)){
            throw new Exception();
        }
        else{
            firstnum = Integer.valueOf(first);
            secondnum = Integer.valueOf(second);
            if (firstnum >= 1 && firstnum <= 10 && secondnum >= 1 && secondnum <= 10){
                switch (opp){
                    case "/":
                        System.out.println(firstnum/secondnum);
                        break;
                    case "*":
                        System.out.println(firstnum*secondnum);
                        break;
                    case "+":
                        System.out.println(firstnum+secondnum);
                        break;
                    case "-":
                        System.out.println(firstnum-secondnum);
                        break;
                    default:
                        throw new Exception();
                }
            }
            else throw new Exception();
        }
    }
}
