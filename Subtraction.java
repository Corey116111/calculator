public class Subtraction extends Operation
{
    public Subtraction(long num1, long num2, int numberSystem)
    {
        super(num1, num2, numberSystem); // вызов конструктора родительского Operation
    }
    ///  возвращаем результат операции
    @Override
    public void work()
    {
        result = num1 - num2;
    }
    ///  возвращаем символ операции
    @Override
    public String getOperationSymbol()
    {
        return "-";
    }
}
