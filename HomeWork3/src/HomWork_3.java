import java.util.Random;
import java.util.Scanner;


public class HomWork_3 {

    //Задание №1
    public static void gameControl( ) {
        Scanner inputData = new Scanner(System.in);
        Random random = new Random();
        int counter=1; //счетчик 3 попыток
        int iData;
        int randData = random.nextInt(9);

        do {
            System.out.println("введите число от 0 до 9. У вас 3 попытки");
            iData = inputData.nextInt();
        }while( iData < 0 || iData >= 9 );

        while(iData!=randData ){
            if (iData>randData) System.out.println("число должно быть меньше");
            if (iData<randData) System.out.println("число должно быть больше");

            if (counter>=3){
                System.out.println("Вы продули.");
                counter=0;
                return ;
            }
            iData = inputData.nextInt();
            counter+=1;
        }
        System.out.println("УРА! Вы выиграли");

    }

    public static int checkNum() {
        int iData;
        Scanner inputData1 = new Scanner(System.in);
        do { //выбираем продолжить или нет
            System.out.println("Хотите повторить? 1 - да 0 - нет");
            iData = inputData1.nextInt();
        }while(iData!=1 && iData!=0);
        return iData;
    }


    public static void main(String[] args) {

//Задание №2
        String[] arrWords = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random1 = new Random( );
        //номер слова в массиве
        int numWordsock = random1.nextInt(arrWords.length);
        //вводим слово
        Scanner sc = new Scanner(System.in);
        int count1=0;

        do {
            System.out.println("введите слово!" + "    тайное слово - " + arrWords[numWordsock]);
            String myWord= sc.nextLine();
            int len_myword = myWord.length();
            int len_secretWord = arrWords[numWordsock].length();

            for (int i = 0; i < 15; i++) { //проходим по символам введенного слова
                if ( i < len_secretWord && i < len_myword && arrWords[numWordsock].charAt(i) == myWord.charAt(i) ) {
                    System.out.print(myWord.charAt(i));
                    count1 += 1;
                } else {
                    System.out.print("*");
                }
            }
            if (count1 == len_secretWord ) {
                System.out.println("");
                System.out.println("Вы отгадали слово!!");
            }
            System.out.println("");
            count1 = 0;
        }while(checkNum()!=0);



//Задание №1
        do {
            gameControl();
        }while(checkNum()!=0);
          System.out.println("GAME OVER");

    }
}
