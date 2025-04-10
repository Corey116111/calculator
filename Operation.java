public abstract class Operation
{
    protected long num1;
    protected long num2;
    protected long result;
    protected int originalNumberSystem;

    public Operation(long num1, long num2, int numberSystem)
    {
        this.num1 = num1;
        this.num2 = num2;
        this.originalNumberSystem = numberSystem;
    }
    /// абстрактный метод работы выбранной операции
    public abstract void work();
    /// получаем результат операции
    public long getResult()
    {
        return result;
    }
    /// абстрактный метод, который вернет символ выбранной операции
    public abstract String getOperationSymbol();
    /// строковое представление операции с числами в выбранной системе счисления
    public String toString()
    {
        return formatNumber(num1, originalNumberSystem) + " " +
                getOperationSymbol() + " " +
                formatNumber(num2, originalNumberSystem) + " = " +
                formatNumber(result, originalNumberSystem);
    }
    /// форматирование числа в выбранной системе счисления
    protected static String formatNumber(long number, int numberSystem)
    {
        switch (numberSystem)
        {
            case 2: return Long.toBinaryString(number);
            case 8: return Long.toOctalString(number);
            case 10: return Long.toString(number);
            case 16: return Long.toHexString(number);
            default: throw new IllegalArgumentException("Неподдерживаемая система счисления: " + numberSystem);
        }
    }
}

