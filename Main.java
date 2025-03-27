import java.math.BigDecimal;
import java.math.BigInteger;
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
        List<String> history = new ArrayList<>(); // история, в нее пихаем результаты операций в выбранной системе счисления
        int numberSystem = 10; // система счисления по умолчанию

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
            System.out.println("\nТекущее число 1: " + formatNumberInAllSystems(num1));
            System.out.println("Текущее число 2: " + formatNumberInAllSystems(num2));
            System.out.print("Введите номер действия: ");

            String input = scanner.nextLine().trim(); // выбираем действие

            switch (input)
            {
                case "1":
                    System.out.print("Введите первое число: ");
                    String inputNum1 = scanner.nextLine().trim();
                    try // проверка, что на вход поступает число
                    {
                        num1 = parseNumber(inputNum1, numberSystem); // парсинг числа в текущей системе счисления
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Ошибка: введите корректное число для текущей системы счисления.");
                    }
                    break;
                case "2":
                    System.out.print("Введите второе число: ");
                    String inputNum2 = scanner.nextLine().trim();
                    try
                    {
                        num2 = parseNumber(inputNum2, numberSystem); // парсинг числа в текущей системе счисления
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Ошибка: введите корректное число для текущей системы счисления.");
                    }
                    break;
                case "3": // сложение
                    result = num1.add(num2);
                    System.out.println("Результат: " + formatNumberInAllSystems(result));
                    history.add(formatNumber(num1, numberSystem) + " + " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
                    num1 = result;
                    break;
                case "4": // вычитание
                    result = num1.subtract(num2);
                    System.out.println("Результат: " + formatNumberInAllSystems(result));
                    history.add(formatNumber(num1, numberSystem) + " - " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
                    num1 = result;
                    break;
                case "5": // умножение
                    result = num1.multiply(num2);
                    System.out.println("Результат: " + formatNumberInAllSystems(result));
                    history.add(formatNumber(num1, numberSystem) + " * " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
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
                        System.out.println("Результат: " + formatNumberInAllSystems(result));
                        history.add(formatNumber(num1, numberSystem) + " / " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
                        num1 = result;
                    }
                    break;
                case "7": // остаток от деления
                    if (num2.compareTo(BigDecimal.ZERO) == 0)
                    {
                        System.out.println("Ошибка: деление на ноль невозможно");
                    }
                    else
                    {
                        result = num1.remainder(num2);
                        System.out.println("Результат: " + formatNumberInAllSystems(result));
                        history.add(formatNumber(num1, numberSystem) + " % " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
                        num1 = result;
                    }
                    break;
                case "8":
                    System.out.println("История операций:");
                    history.forEach(System.out::println);
                    break;
                case "9":
                    System.out.println("Выберите систему счисления:");
                    System.out.println("1) Десятичная (dec)");
                    System.out.println("2) Шестнадцатеричная (hex)");
                    System.out.println("3) Восьмеричная (oct)");
                    System.out.println("4) Двоичная (bin)");
                    System.out.print("Введите номер системы счисления: ");
                    String systemInput = scanner.nextLine().trim();
                    switch (systemInput)
                    {
                        case "1":
                            numberSystem = 10;
                            break;
                        case "2":
                            numberSystem = 16;
                            break;
                        case "3":
                            numberSystem = 8;
                            break;
                        case "4":
                            numberSystem = 2;
                            break;
                        default:
                            System.out.println("Ошибка: неизвестная система счисления.");
                    }
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
    /// парсинг числа в заданной системе счисления
    private static BigDecimal parseNumber(String input, int numberSystem) throws NumberFormatException
    {
        try // пытаемся распарсить поступившее число в выбранной системе счисления
        {
            return new BigDecimal(new BigInteger(input, numberSystem));
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("Некорректное число для системы счисления " + numberSystem);
        }
    }
    /// возвращаем число во всех системах счисления
    private static String formatNumberInAllSystems(BigDecimal number)
    {
        BigInteger intValue = number.toBigInteger();
        return "DEC: " + intValue.toString(10) +
                ", HEX: " + intValue.toString(16) +
                ", OCT: " + intValue.toString(8) +
                ", BIN: " + intValue.toString(2);
    }
    ///  возвращает число в текущей системе счисления (для истории)
    private static String formatNumber(BigDecimal number, int numberSystem)
    {
        return number.toBigInteger().toString(numberSystem); // используется для записи числа в историю в системе счисления, используемой на тот момент
    }
}