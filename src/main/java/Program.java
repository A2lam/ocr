import java.io.*;
import java.util.ArrayList;

public class Program
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("in.txt"));
            ArrayList<String> message = new ArrayList<String>();
            for (int i = 0; i < 3; i++)
            {
                String line = bufferedReader.readLine();
                message.add(line);
            }
            bufferedReader.readLine();

            Parser numberParser = new Parser(message);
            numberParser.parse();
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
