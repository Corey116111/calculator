import java.util.ArrayList;
import java.util.List;

public class Calculator
{
    private long num1 = 0;
    private long num2 = 0;
    private long result = 0;
    private List<String> history = new ArrayList<>(); // история операций
    private int numberSystem = 10;
    /// получаем текущую систему счисления
    public int getNumberSystem()
    {
        return numberSystem;
    }
    ///  получаем 1 число
    public long getNum1()
    {
        return num1;
    }
    ///  получаем 2 число
    public long getNum2()
    {
        return num2;
    }
    ///  устанавливаем 1 число
    public void setNum1(String input, int numberSystem)
    {
        try
        {
            num1 = Long.parseLong(input, numberSystem); // парсим число в текущей системе счисления
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ошибка: введите корректное число для текущей системы счисления.");
        }
    }
    ///  устанавливаем 2 число
    public void setNum2(String input, int numberSystem)
    {
        try
        {
            num2 = Long.parseLong(input, numberSystem); // парсим число в текущей системе счисления
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ошибка: введите корректное число для текущей системы счисления.");
        }
    }
    /// устанавливаем систему счисления
    public void setNumberSystem(String systemInput)
    {
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
    }
    ///  сложение
    public void add()
    {
        result = num1 + num2;
        System.out.println("Результат: " + allSystem(result));
        history.add(formatNumber(num1, numberSystem) + " + " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
        num1 = result;
    }
    ///  вычитание
    public void subtract()
    {
        result = num1 - num2;
        System.out.println("Результат: " + allSystem(result));
        history.add(formatNumber(num1, numberSystem) + " - " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
        num1 = result;
    }
    ///  умножение
    public void multiply()
    {
        result = num1 * num2;
        System.out.println("Результат: " + allSystem(result));
        history.add(formatNumber(num1, numberSystem) + " * " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
        num1 = result;
    }
    ///  деление
    public void divide()
    {
        if (num2 == 0)
        {
            System.out.println("Ошибка: деление на ноль невозможно");
        }
        else
        {
            result = num1 / num2;
            System.out.println("Результат: " + allSystem(result));
            history.add(formatNumber(num1, numberSystem) + " / " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
            num1 = result;
        }
    }
    ///  получить остаток от деления
    public void remainder()
    {
        if (num2 == 0)
        {
            System.out.println("Ошибка: деление на ноль невозможно");
        }
        else
        {
            result = num1 % num2;
            System.out.println("Результат: " + allSystem(result));
            history.add(formatNumber(num1, numberSystem) + " % " + formatNumber(num2, numberSystem) + " = " + formatNumber(result, numberSystem));
            num1 = result;
        }
    }
    ///  вывести историю операций
    public void printHistory()
    {
        System.out.println("История операций:");
        history.forEach(System.out::println);
    }
    /// выводим число во всех системах счисления
    public static String allSystem(long number)
    {
        return "DEC: " + number +
                ", HEX: " + Long.toHexString(number) +
                ", OCT: " + Long.toOctalString(number) +
                ", BIN: " + Long.toBinaryString(number);
    }
    /// переводим число в выбранную систему счисления
    private static String formatNumber(long number, int numberSystem)
    {
        switch (numberSystem)
        {
            case 2:
                return Long.toBinaryString(number);
            case 8:
                return Long.toOctalString(number);
            case 10:
                return Long.toString(number);
            case 16:
                return Long.toHexString(number);
            default:
                throw new IllegalArgumentException("Неподдерживаемая система счисления: " + numberSystem);
        }
    }
}