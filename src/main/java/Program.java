import java.io.*;

public class Program
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("in.txt"));
            String message = bufferedReader.readLine();
            while (null != message)
            {
                Parser numberParser = new Parser(message);
                numberParser.parse();
                message = bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
