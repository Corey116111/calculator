public class Remainder extends Operation
{
    public Remainder(long num1, long num2, int numberSystem)
    {
        super(num1, num2, numberSystem); // вызов конструктора родительского Operation
    }
    ///  возвращаем результат операции
    @Override
    public void work()
    {
        if (num2 == 0)
        {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        result = num1 % num2;
    }
    ///  возвращаем символ операции
    @Override
    public String getOperationSymbol()
    {
        return "%";
    }
}
