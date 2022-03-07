package oslomet.webprog;

public class RekursjonDemo {

    public static void main(String[] args) {
        System.out.println("Live-koding - rekursjon");

        skrivHei(5);

        String testStreng = "Elle";
        if(!palindrom(testStreng.toUpperCase()))
            System.out.println(testStreng + " er IKKE et palindrom!");
        else
            System.out.println(testStreng + " er et palindrom!");

        // TODO: Tesselering (f.eks. Koch-snøfnugg)

        System.out.println("Ukeoppgaver - rekursjon");

        int tall = 5;

        int liste[] = {61, 87, 154, 170, 275, 426, 503, 509, 512, 612, 653, 677, 703 ,765, 897, 908};
        int nokkel = 275; //276;

        System.out.println("Summen (iterativ metode) av alle tall fra " + tall + " til 1 er " + iterativSum(tall));
        System.out.println("Summen (rekursiv metode) av alle tall fra " + tall + " til 1 er " + sum(tall));
        System.out.println(tall + " fakultet er " + fakultet(tall));

        int pos = binsok(liste, nokkel, 0, liste.length-1);
        if(pos >= 0)
            System.out.println("Nøkkelen " + nokkel + " har posisjon " + pos);
        else
            System.out.println("Nøkkelen " + nokkel + " finnes ikke i arrayet");

        System.out.println("Tall nummer " + tall + " i Fibonacci-rekken er " + fibonacci(tall));
    }

    public static void skrivHei(int antallSomMangler)
    {
        if (antallSomMangler > 0)
        {
            System.out.println("Hei!");
            skrivHei( antallSomMangler - 1 );
        }
        System.out.println("Hoi!");
    }

    public static boolean palindrom(String str)
    {
        if (str.length() < 2)
            return true;
        else if (str.charAt( 0 ) == str.charAt(str.length() - 1))
            return palindrom(str.substring(1, str.length() - 1));
        else
            return false;
    }

    public static int fakultet(int n)
    {
        if ( n == 0 )
            return 1;
        else
            return n * fakultet( n - 1 );
    }

    public static int sum(int n) {
        if (n >= 1) {
            return sum(n - 1) + n;
        }
        return n;
    }

    public static int iterativSum(int n) {
        int sum = 0;
        if(n < 0) {
            return -1;
        }
        for(int i=0; i<=n; i++) {
            sum += i;
        }
        return sum;
    }



    // foretar rekursiv binærsøking etter nøkkel i arrayen liste
    // returnerer indeksposisjon, eller -1 i tilfelle ikke funn
    public static int binsok(int[] liste, int nokkel, int venstre, int hoyre)
    {
        if (venstre <= hoyre)
        {
            int mid = (venstre + hoyre) / 2;  //skal lete midt i lista
            if (liste[ mid ] > nokkel) //leter videre i venstre listehalvdel
                return binsok(liste, nokkel, venstre, mid - 1);
            else  if (liste[ mid ] < nokkel) //leter videre i høyre listehalvdel
                return binsok(liste, nokkel, mid + 1, hoyre);
            else //funn!
                return mid;
        }
        else  //tom liste, nøkkel finnes ikke
            return -1;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

}
