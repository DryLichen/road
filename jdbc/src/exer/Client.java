package exer;

import java.util.Scanner;

public class Client {
    public static String symbol;
    public static String id;

    public static void show(){
        System.out.println("请选择您要输入的类型：");
        System.out.println("a:准考证号");
        System.out.println("b:身份证号");

        Scanner scan = new Scanner(System.in);
        symbol = scan.next();

        while(!ifAB()){
            System.out.println("请选择您要输入的类型：");
            System.out.println("a:准考证号");
            System.out.println("b:身份证号");
            symbol = scan.next();
        };
    }

    public static boolean ifAB() {
        Scanner scanner = new Scanner(System.in);

        if(symbol.equals("a")){
            System.out.println("请输入准考证号：");
            id = scanner.next();
            return true;
        }else if(symbol.equals("b")){
            System.out.println("请输入身份证号：");
            id = scanner.next();
            return true;
        }

        System.out.println("您的输入有误！只能输入字母a或b");
        return false;
    }



}
