import java.util.ArrayList;

class NumberCorrespondence
{
    private ArrayList<String> numberBloc;

    NumberCorrespondence(ArrayList<String> numberBloc)
    {
        this.numberBloc = numberBloc;
    }

    ArrayList<String> getNumberBloc()
    {
        return this.numberBloc;
    }

    int getNumberBlocCorrespondantInt()
    {
        /*
         * Construction de l'arbre de correspondance
         */
        if (this.numberBloc.get(0).equals("   "))
        {
            if (this.numberBloc.get(1).equals(" | "))
            {
                if (this.numberBloc.get(2).equals(" | "))
                    return 1;
                else
                    return -1;
            }
            else if (this.numberBloc.get(1).equals("|_|"))
            {
                if (this.numberBloc.get(2).equals("  |"))
                    return 4;
                else
                    return -1;
            }
            else
                return -1;
        }
        else // Si le premier bloc correspond à " _ "
        {
            if (this.numberBloc.get(1).equals("|_ "))
            {
                if (this.numberBloc.get(2).equals(" _|"))
                    return 5;
                else if (this.numberBloc.get(2).equals("|_|"))
                    return 6;
                else
                    return -1;
            }
            else if (this.numberBloc.get(1).equals(" _|"))
            {
                if (this.numberBloc.get(2).equals("|_ "))
                    return 2;
                else if (this.numberBloc.get(2).equals(" _|"))
                    return 3;
                else
                    return -1;
            }
            else if (this.numberBloc.get(1).equals("|_|"))
            {
                if (this.numberBloc.get(2).equals("|_|"))
                    return 8;
                else if (this.numberBloc.get(2).equals(" _|"))
                    return 9;
                else return -1;
            }
            else if (this.numberBloc.get(1).equals("  |"))
                return 7;
            else
                return -1;
        }
    }
}
