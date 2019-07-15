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

    private boolean calculateChecksum(String decodedMessage)
    {
        int checksum = 0;
        int position = 9;
        for (char c: decodedMessage.toCharArray())
        {
            int number = Integer.parseInt(String.valueOf(c)) * position;
            checksum += number;
            position--;
        }

        return checksum % 11 == 0;
    }

    void parse()
    {
        StringBuilder decodedMessage = new StringBuilder();
        for (NumberCorrespondence numberBloc : this.numberCorrespondenceList)
        {
            int correspondantInt = numberBloc.getNumberBlocCorrespondantInt();
            if (-1 != correspondantInt)
                decodedMessage.append(String.valueOf(correspondantInt));
            else
                decodedMessage.append("?");
        }

        String stringifiedDecodedMessage = String.valueOf(decodedMessage);
        if (stringifiedDecodedMessage.contains("?"))
        {
            System.out.println(stringifiedDecodedMessage + " ILL");
            try
            {
                this.bufferedWriter.write(stringifiedDecodedMessage + " ILL");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            boolean isChecksumValid = this.calculateChecksum(stringifiedDecodedMessage);
            if (isChecksumValid)
            {
                System.out.println(stringifiedDecodedMessage);
                try
                {
                    this.bufferedWriter.write(stringifiedDecodedMessage);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println(stringifiedDecodedMessage + " ERR");
                try
                {
                    this.bufferedWriter.write(stringifiedDecodedMessage + " ERR");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
