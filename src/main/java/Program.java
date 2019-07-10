public class Program
{
    public static void main(String[] args)
    {
        String message = "1234";
        Parser numberParser = new Parser(message);
        numberParser.parse();
    }
}
