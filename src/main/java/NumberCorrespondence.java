import java.util.ArrayList;

class NumberCorrespondence
{
    private int number;
    private ArrayList<String> numberCorrespondenceArray;

    NumberCorrespondence(int number) throws IllegalArgumentException
    {
        if ((number < 1) || (number > 9))
            throw new IllegalArgumentException();

        this.number = number;
        this.numberCorrespondenceArray = new ArrayList<String>();
    }

    int getNumber()
    {
        return number;
    }

    ArrayList<String> getNumberCorrespondenceArray()
    {
        switch (this.number)
        {
            case 1:
                this.numberCorrespondenceArray.add("  ");
                this.numberCorrespondenceArray.add(" |");
                this.numberCorrespondenceArray.add(" |");
                this.numberCorrespondenceArray.add("  ");
                break;
            case 2:
                this.numberCorrespondenceArray.add(" _");
                this.numberCorrespondenceArray.add(" _|");
                this.numberCorrespondenceArray.add("|_ ");
                this.numberCorrespondenceArray.add("  ");
                break;
            case 3:
                this.numberCorrespondenceArray.add(" _ ");
                this.numberCorrespondenceArray.add(" _|");
                this.numberCorrespondenceArray.add(" _|");
                this.numberCorrespondenceArray.add("  ");
                break;
            case 4:
                this.numberCorrespondenceArray.add("  ");
                this.numberCorrespondenceArray.add("|_|");
                this.numberCorrespondenceArray.add("  |");
                this.numberCorrespondenceArray.add("  ");
                break;
            case 5:
                this.numberCorrespondenceArray.add(" _ ");
                this.numberCorrespondenceArray.add("|_ ");
                this.numberCorrespondenceArray.add(" _|");
                this.numberCorrespondenceArray.add("  ");
                break;
            case 6:
                this.numberCorrespondenceArray.add(" _ ");
                this.numberCorrespondenceArray.add("|_ ");
                this.numberCorrespondenceArray.add("|_|");
                this.numberCorrespondenceArray.add("  ");
                break;
            case 7:
                this.numberCorrespondenceArray.add(" _ ");
                this.numberCorrespondenceArray.add("  |");
                this.numberCorrespondenceArray.add("  |");
                this.numberCorrespondenceArray.add("  ");
                break;
            case 8:
                this.numberCorrespondenceArray.add(" _ ");
                this.numberCorrespondenceArray.add("|_|");
                this.numberCorrespondenceArray.add("|_|");
                this.numberCorrespondenceArray.add("  ");
                break;
            case 9:
                this.numberCorrespondenceArray.add(" _ ");
                this.numberCorrespondenceArray.add("|_|");
                this.numberCorrespondenceArray.add(" _|");
                this.numberCorrespondenceArray.add("  ");
                break;
        }

        return this.numberCorrespondenceArray;
    }
}
