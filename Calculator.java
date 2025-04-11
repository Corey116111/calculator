import java.util.ArrayList;
import java.util.List;

public class Calculator
{
    private long num1 = 0;
    private long num2 = 0;
    private long result = 0;
    private List<Operation> history = new ArrayList<>(); // история
    private int numberSystem = 10; // система счисления по умолчанию
    /// Получаем текущую систему счисления
    public int getNumberSystem()
    {
        return numberSystem;
    }
    /// получаем 1-ое число
    public long getNum1()
    {
        return num1;
    }
    ///  получаем 2-ое число
    public long getNum2()
    {
        return num2;
    }
    ///  устанавливаем 1 число
    public void setNum1(String input)
    {
        try
        {
            num1 = Long.parseLong(input, numberSystem); // парсим в выбранной системе счисления
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ошибка: введите корректное число для текущей системы счисления.");
        }
    }
    ///  устанавливаем 2 число
    public void setNum2(String input)
    {
        try
        {
            num2 = Long.parseLong(input, numberSystem); // парсим в выбранной системе счисления
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ошибка: введите корректное число для текущей системы счисления.");
        }
    }
    ///  устанавливаем систему счисления
    public void setNumberSystem(String systemInput)
    {
        switch (systemInput)
        {
            case "1": numberSystem = 10; break;
            case "2": numberSystem = 16; break;
            case "3": numberSystem = 8; break;
            case "4": numberSystem = 2; break;
            default: System.out.println("Ошибка: неизвестная система счисления.");
        }
    }
    /// метод для выполнения поступившей в параметры операции
    public void selectedOperation(Operation operation)
    {
        try
        {
            operation.work(); // выполняется реализация метода из конкретного класса наследника
            result = operation.getResult();
            System.out.println("Результат: " + allSystem(result));
            history.add(operation);
            num1 = result;
        }
        catch (ArithmeticException e)
        {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    /// вывод всей истории операций
    public void printHistory()
    {
        System.out.println("История операций:");
        for (Operation operation : history)
        {
            System.out.println(operation.toString()); // Вызываем toString без параметров
        }
    }
    ///  представление числа во всех системах счисления
    public static String allSystem(long number)
    {
        return "DEC: " + number +
                ", HEX: " + Long.toHexString(number) +
                ", OCT: " + Long.toOctalString(number) +
                ", BIN: " + Long.toBinaryString(number);
    }
}