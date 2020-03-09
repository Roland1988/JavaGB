import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Sotrudnik[] sotrudniki = new Sotrudnik[5];
        sotrudniki[0]=new Sotrudnik("Ivanova Margarita", "Engineer I", "Margarita@mailbox.com", "893452312", 30000, 30);
        sotrudniki[1]=new Sotrudnik("Ivanova Angelika", "Engineer II", "Angelika@mailbox.com", "89234512", 40000, 41);
        sotrudniki[2]=new Sotrudnik("Ivanova Elvira", "Engineer III", "Elvira@mailbox.com", "892356312", 50000, 25);
        sotrudniki[3]=new Sotrudnik("Ivanova Snejana", "Engineer IV", "Snejana@mailbox.com", "897812312", 60000, 50);
        sotrudniki[4]=new Sotrudnik("Ivanova Zlata", "Engineer V", "Zlata@mailbox.com", "892323312", 70000, 77);

        for (int i=0; i < 5; i++ ){
           if (sotrudniki[i].vozrast >=40 ){
               System.out.println( sotrudniki[i].fio + ", "+ sotrudniki[i].vozrast );
           }
         }

    }


}
