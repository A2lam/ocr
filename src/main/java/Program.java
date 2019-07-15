import java.io.*;
import java.util.ArrayList;

public class Program
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("in.txt"));
            String line = bufferedReader.readLine();
            while (null != line)
            {
                ArrayList<String> message = new ArrayList<String>();
                message.add(line);
                for (int i = 0; i < 2; i++)
                {
                    line = bufferedReader.readLine();
                    message.add(line);
                }
                bufferedReader.readLine(); // Saut de la 4e ligne qui est vide

                Parser numberParser = new Parser(message);
                numberParser.parse();

                line = bufferedReader.readLine();
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
