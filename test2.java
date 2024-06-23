import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("произведите расчет чисел");
        String str = sc.nextLine();
        String[] p = str.split(" ");
        if (p.length < 3 ) throw new IllegalArgumentException("строка не является математической операцией");
        if (p.length == 4) throw new IllegalArgumentException("throws Exception");
        if (p.length!=3) throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию " +
                "\n - два операнда и один оператор (+, -, /, *)");
        String znak = p[1];
        int a=0;
        int b=0;
        boolean flag=false;
        try {
            a = Integer.parseInt(p[0]);
            b = Integer.parseInt(p[2]);
            int result= calc(znak, a, b);
            System.out.println(result);
        }
        catch (NumberFormatException e){
            flag=true;
        }
        if (flag){
            throw new InputMismatchException("строка не является математической операцией");
        }
    }
    public static int calc(String znak, int a, int b) {
        if (a<1 || a>10){
            throw new IllegalArgumentException("1е число: меньше 1, либо больше 10");
        }
        if (b<1 || b>10){
            throw new IllegalArgumentException("2е число: меньше 1, либо больше 10");
        }
        return switch (znak) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Неверный знак: " + znak+", верный: +,-,* или /");
        };
    }
}
