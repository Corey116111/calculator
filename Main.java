import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Консольный калькулятор");
        System.out.println("Поддерживаемые операции:");

        BigDecimal num1 = BigDecimal.ZERO;
        BigDecimal num2 = BigDecimal.ZERO;
        BigDecimal result = BigDecimal.ZERO;
        List<String> history = new ArrayList<>(); // история

        while (true)
        {
            System.out.println("\n1) Написать первое число");
            System.out.println("2) Написать второе число");
            System.out.println("3) Сложить");
            System.out.println("4) Вычесть");
            System.out.println("5) Умножить");
            System.out.println("6) Разделить");
            System.out.println("7) История");
            System.out.println("8) Выход");
            System.out.println("\nТекущее число 1: " + num1);
            System.out.println("Текущее число 2: " + num2);
            System.out.print("Введите номер действия: ");
            String input = scanner.nextLine().trim(); // выбираем действие

            switch (input)
            {
                case "1":
                    System.out.print("Введите первое число: ");
                    String inputNum1 = scanner.nextLine().trim();
                    try
                    {
                        num1 = new BigDecimal(inputNum1);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Ошибка: введите корректное число.");
                    }
                    break;
                case "2":
                    System.out.print("Введите второе число: ");
                    String inputNum2 = scanner.nextLine().trim();
                    try
                    {
                        num2 = new BigDecimal(inputNum2);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Ошибка: введите корректное число.");
                    }
                    break;
                case "3": // сложение
                    result = num1.add(num2);
                    System.out.println("Результат: " + result);
                    history.add(num1 + " + " + num2 + " = " + result);
                    num1 = result;
                    break;
                case "4": // вычитание
                    result = num1.subtract(num2);
                    System.out.println("Результат: " + result);
                    history.add(num1 + " - " + num2 + " = " + result);
                    num1 = result;
                    break;
                case "5": // умножение
                    result = num1.multiply(num2);
                    System.out.println("Результат: " + result);
                    history.add(num1 + " * " + num2 + " = " + result);
                    num1 = result;
                    break;
                case "6": // деление
                    if (num2.compareTo(BigDecimal.ZERO) == 0)
                    {
                        System.out.println("Ошибка: деление на ноль невозможно");
                    }
                    else
                    {
                        result = num1.divide(num2, 16, RoundingMode.HALF_UP);
                        System.out.println("Результат: " + result);
                        history.add(num1 + " / " + num2 + " = " + result);
                        num1 = result;
                    }
                    break;
                case "7":
                    System.out.println("История операций:");
                    history.forEach(System.out::println);
                    break;
                case "8":
                    System.out.println("Выход из калькулятора.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ошибка: неизвестное действие.");
            }
        }
    }
}