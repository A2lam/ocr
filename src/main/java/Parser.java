import java.util.ArrayList;

class Parser
{
    private String message;
    private ArrayList<NumberCorrespondence> numberCorrespondenceList;

    Parser(String message)
    {
        this.message = message;
        this.numberCorrespondenceList = new ArrayList<NumberCorrespondence>();

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
            for (NumberCorrespondence correspondence: this.numberCorrespondenceList)
            {
                System.out.print(correspondence.getNumberCorrespondenceArray().get(i));
            }
            System.out.println();
        }
    }
}
