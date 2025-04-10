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
            System.out.println("\nТекущее число 1: " + Calculator.allSystem(calculator.getNum1()));
            System.out.println("Текущее число 2: " + Calculator.allSystem(calculator.getNum2()));
            System.out.println("Текущая система счисления:" + calculator.getNumberSystem());
            System.out.print("Введите номер действия: ");

            String input = scanner.nextLine().trim();

            switch (input)
            {
                case "1":
                    System.out.print("Введите первое число: ");
                    calculator.setNum1(scanner.nextLine().trim());
                    break;
                case "2":
                    System.out.print("Введите второе число: ");
                    calculator.setNum2(scanner.nextLine().trim());
                    break;
                case "3":
                    calculator.selectedOperation(new Addition(calculator.getNum1(), calculator.getNum2(), calculator.getNumberSystem())); // передаем операцию сложения
                    break;
                case "4":
                    calculator.selectedOperation(new Subtraction(calculator.getNum1(), calculator.getNum2(), calculator.getNumberSystem())); // передаем операцию вычитания
                    break;
                case "5":
                    calculator.selectedOperation(new Multiplication(calculator.getNum1(), calculator.getNum2(), calculator.getNumberSystem())); // передаем операцию умножения
                    break;
                case "6":
                    calculator.selectedOperation(new Division(calculator.getNum1(), calculator.getNum2(), calculator.getNumberSystem())); // передаем операцию деления
                    break;
                case "7":
                    calculator.selectedOperation(new Remainder(calculator.getNum1(), calculator.getNum2(), calculator.getNumberSystem())); // передаем операцию деления нацело
                    break;
                case "8":
                    calculator.printHistory(); // вывод истории
                    break;
                case "9":
                    System.out.println("Выберите систему счисления:");
                    System.out.println("1) Десятичная (dec)");
                    System.out.println("2) Шестнадцатеричная (hex)");
                    System.out.println("3) Восьмеричная (oct)");
                    System.out.println("4) Двоичная (bin)");
                    System.out.print("Введите номер системы счисления: ");
                    calculator.setNumberSystem(scanner.nextLine().trim()); // выбираем систему счисления
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