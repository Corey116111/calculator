import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Консольный калькулятор");
        System.out.println("Поддерживаемые операции:");

        while (true)
        {
            System.out.println("\n1) Написать первое число");
            System.out.println("2) Написать второе число");
            System.out.println("3) Сложить");
            System.out.println("4) Вычесть");
            System.out.println("5) Умножить");
            System.out.println("6) Разделить");
            System.out.println("7) Остаток от деления");
            System.out.println("8) История");
            System.out.println("9) Выбрать систему счисления");
            System.out.println("10) Выход");
            System.out.println("\nТекущее число 1: " + calculator.allSystem(calculator.getNum1()));
            System.out.println("Текущее число 2: " + calculator.allSystem(calculator.getNum2()));
            System.out.println("Текущая система счисления:" + calculator.getNumberSystem());
            System.out.print("Введите номер действия: ");

            String input = scanner.nextLine().trim(); // выбираем действие

            switch (input)
            {
                case "1":
                    System.out.print("Введите первое число: ");
                    calculator.setNum1(scanner.nextLine().trim(), calculator.getNumberSystem());
                    break;
                case "2":
                    System.out.print("Введите второе число: ");
                    calculator.setNum2(scanner.nextLine().trim(), calculator.getNumberSystem());
                    break;
                case "3":
                    calculator.add();
                    break;
                case "4":
                    calculator.subtract();
                    break;
                case "5":
                    calculator.multiply();
                    break;
                case "6":
                    calculator.divide();
                    break;
                case "7":
                    calculator.remainder();
                    break;
                case "8":
                    calculator.printHistory();
                    break;
                case "9":
                    System.out.println("Выберите систему счисления:");
                    System.out.println("1) Десятичная (dec)");
                    System.out.println("2) Шестнадцатеричная (hex)");
                    System.out.println("3) Восьмеричная (oct)");
                    System.out.println("4) Двоичная (bin)");
                    System.out.print("Введите номер системы счисления: ");
                    calculator.setNumberSystem(scanner.nextLine().trim());
                    break;
                case "10":
                    System.out.println("Выход из калькулятора.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ошибка: неизвестное действие.");
            }
        }
    }
}