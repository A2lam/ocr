import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Parser
{
    private String message;
    private ArrayList<NumberCorrespondence> numberCorrespondenceList;
    private BufferedWriter bufferedWriter;

    Parser(String message)
    {
        this.message = message;
        this.numberCorrespondenceList = new ArrayList<NumberCorrespondence>();
        try
        {
            this.bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        for (char c: this.message.toCharArray())
        {
            numberCorrespondenceList.add(new NumberCorrespondence((Integer.parseInt(String.valueOf(c)))));
        }
    }

    String getMessage()
    {
        return this.message;
    }

    void parse()
    {
        for (int i = 0; i < 4; i++)
        {
            StringBuilder line = new StringBuilder();
            for (NumberCorrespondence correspondence: this.numberCorrespondenceList)
            {
                line.append(correspondence.getNumberCorrespondenceArray().get(i));
            }

            System.out.println(line);

            try
            {
                this.bufferedWriter.write(String.valueOf(line));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
