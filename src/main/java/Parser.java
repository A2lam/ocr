import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Parser
{
    private ArrayList<String> message;
    private ArrayList<NumberCorrespondence> numberCorrespondenceList;
    private BufferedWriter bufferedWriter;

    Parser(ArrayList<String> message)
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

        for (int i = 0; i < 27; i += 3)
        {
            ArrayList<String> numberBloc = new ArrayList<String>();
            for (String line : this.message)
                numberBloc.add(line.substring(i, (i + 3)));

            numberCorrespondenceList.add(new NumberCorrespondence((numberBloc)));
        }
    }

    ArrayList<String> getMessage()
    {
        return this.message;
    }

    boolean calculateChecksum(String decodedMessage)
    {
        int checksum = 0;
        int position = 9;
        for (char c: decodedMessage.toCharArray())
        {
            int number = Integer.parseInt(String.valueOf(c)) * position;
            checksum += number;
            position--;
        }

        if (checksum % 11 == 0)
        {
            System.out.println("Le checksum est valide");
            try
            {
                this.bufferedWriter.write("Le checksum est valide");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return true;
        }
        else
        {
            System.out.println("Le checksum n'est pas valide");
            try
            {
                this.bufferedWriter.write("Le checksum n'est pas valide");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return false;
        }
    }

    void parse()
    {
        StringBuilder decodedMessage = new StringBuilder();
        for (NumberCorrespondence numberBloc : this.numberCorrespondenceList)
        {
            decodedMessage.append(String.valueOf(numberBloc.getNumberBlocCorrespondantInt()));
        }

        System.out.println(String.valueOf(decodedMessage));
        this.calculateChecksum(String.valueOf(decodedMessage));
        try
        {
            this.bufferedWriter.write(String.valueOf(decodedMessage));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
