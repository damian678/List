import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;

public class Lista
{
    //pola

    private int pojemnosc;
    private int rozmiar;
    private int[] liczby;

    //konstruktor klasy

    public Lista(int pojemnosc)
    {
        this.pojemnosc = pojemnosc;
        liczby= new int[pojemnosc];
    }

    //metoda dodająca element do listy

    public void dodajElement(int liczba)
    {
        rozmiar++;
        try
        {
            for (int i = rozmiar - 1; i < rozmiar; i++)
            {
                liczby[i] = liczba;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){}
    }

    //metoda znajdująca element liczba w liście

    public void znajdz(int liczba)
    {
        int pozycja = -1;
        for (int i = 0; i < rozmiar; i++)
        {
            if (liczby[i] == liczba)
            {
                pozycja = i;
                break;
            }
        }
        System.out.println("\nElement " + liczba + " znajduje się na pozycji: " + pozycja);
    }

    //usuwa pierwszy element liczba w liście

    public void usunPierwszy(int liczba)
    {
        for (int i = 0; i < rozmiar; i++)//0-9  i=2
        {
            if (liczby[i] == liczba)
            {
                rozmiar--;
                for (int j = 0; j < rozmiar-i-1; j++)//8
                {
                    liczby[i + j] = liczby[i + (j + 1)];
                }
                break;
            }
        }
    }

    //stan listy

    public String pisz()
    {
        String c="";
        String wynik;
        try
        {
            for (int i = 0; i < rozmiar; i++)
            {
                c=c.concat(liczby[i]+" ");
            }
            wynik="Pojemność: " + pojemnosc+"\nRozmiar: " + rozmiar+"\nElementy: "+c;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            wynik="Lista jest za długa."+"\nPojemność: " + pojemnosc+"\nRozmiar: " + rozmiar;
        }
        return wynik;
    }

    //usuwa powtórzenia

    public void usunPowtorzenia()
    {
        for (int i = 0; i < rozmiar-1; i++)
        {
            for (int j = i + 1; j < rozmiar; j++)
            {
                if (liczby[i] == liczby[j])
                {
                    for (int k = j; k < liczby.length- 1; k++)
                    {
                        liczby[k] = liczby[k + 1];
                    }
                    rozmiar--;
                    j--;
                }
            }
        }
    }

    //odwraca listę

    public void odwroc()
    {
        int[] lista=new int[rozmiar];
        for (int i = 0; i< rozmiar; i++)//8
        {
            lista[i]=liczby[rozmiar-1-i];
        }
        for(int i=0;i<rozmiar;i++)
        {
            liczby[i]=lista[i];
        }
    }

    //zapisuje do pliku

    public void zapiszDoPliku(String nazwaPliku) throws IOException
    {
        FileWriter plik = new FileWriter(nazwaPliku);
        plik.write(pisz());
        plik.close();
    }

    public static void main(String[] args) throws IOException
    {
        int N = 10;
        Lista l = new Lista(N);
        l.dodajElement(2);

        double dodane;
        for (int i = 0; i < N / 2; i++)
        {
            dodane = Math.pow(2, i);
            l.dodajElement((int) dodane);
        }
        l.dodajElement(2);
        l.dodajElement(4);
        l.dodajElement(61);
        l.dodajElement(62);
//        l.dodajElement(22);
//        l.dodajElement(223);

//        l.usunPierwszy(2);

//        l.znajdz(16);

//        l.usunPowtorzenia();
        l.odwroc();
        System.out.println(l.pisz());

         l.zapiszDoPliku("daneLista.txt");


    }
}
