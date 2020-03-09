

import java.util.Random;
import java.util.Scanner;

public class FirstGame {

    public static int size = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '_';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static char[][] map = new char [size][size];
    public static int xBlokStep = 1 ;
    public static int yBlokStep = 1 ;
    public static boolean flagStep = false ;

   //ИНИЦИАЛИЗАЦИЯ МАССИВА
    public static void mapInitial() {
        for(int i=0; i<size; i++ ){
            for(int j=0; j<size; j++ ){
                map[i][j]= DOT_EMPTY;
            }
        }
    }

    //ПЕЧАТЬ МАССИВА
    public static void printMap_() {
        for(int j=0; j <= size; j++ ){
            System.out.printf("%2d ", j); //печать шапки
        }

        for(int i=0; i < size; i++ ){
            System.out.println("");
            System.out.printf("%2d", (i+1));
            for(int j=0; j<size; j++ ){
                System.out.printf("%3c", map[i][j] );
            }
        }
        System.out.println("");
    }

    public static void stepHuman() {
        int x, y = 0;
         do {
             System.out.println("введите координаты x y");
             x = sc.nextInt()-1;
             y = sc.nextInt()-1;
         }while(!chekBox(x, y));
        map[x][y] =DOT_X;
    }

    public static boolean chekBox(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        if (map[x][y] == DOT_EMPTY ){
            return true;
        }
        return false;
    }


    public static void fixStepComp (int x, int y) {
        if (map[x][y] == DOT_EMPTY){
            xBlokStep = x;
            yBlokStep = y;
        }

    }

    public static boolean chekWinner(char step) {
        int goriz = 0;
        int vertik = 0;
        int diagDwn = 0;
        int diagUp = 0;
        int diagLdwnL  ;  // проверка диагонали слева вниз левая часть
        int diagLdwnR  ;   // проверка диагонали слева вниз правая часть
        int diagLupL  ;   // проверка диагоналей слева вверх левая
        int diagLupR  ;    // проверка диагоналей слева вверх правая
        int iter  ;

        for (int i = 0; i < size; i++) {
            goriz = 0;
            vertik = 0;
            for (int j = 0; j < size; j++) {
                if (map[i][j] == step) { // проверка по горизонтали
                    goriz++;
                    fixStepComp(i, j);
                    if (goriz>=DOTS_TO_WIN-1) break;
                }
                if (map[j][i] == step) { // проверка по вертикпли
                    vertik++;
                    fixStepComp(j, i);
                    if (vertik>=DOTS_TO_WIN-1) break;
                }
                if (goriz >= DOTS_TO_WIN || vertik >= DOTS_TO_WIN || diagUp >= DOTS_TO_WIN || diagDwn >= DOTS_TO_WIN) {
                    flagStep = true;
                    return true;
                }
            }
        }

        //проверка   диагоналей
        for (int digonal = 0; digonal < DOTS_TO_WIN - 1; digonal++) {
              diagLdwnL =  0;  // проверка диагонали слева вниз левая часть
              diagLdwnR =  0;  // проверка диагонали слева вниз правая часть
              diagLupL =   0;  // проверка диагоналей слева вверх левая
              diagLupR =   0;  // проверка диагоналей слева вверх правая
              iter =       0;

            do {
                if (map[iter + digonal][iter] == step) { // проверка диагонали слева вниз левее от центральной
                    diagLdwnL++;
                    fixStepComp(iter + digonal, iter);
                    if (diagLdwnL>=DOTS_TO_WIN-1) break;
                }

                if (map[iter][iter + digonal] == step) { // проверка диагонали слева вниз правее от центральной
                    diagLdwnR++;
                    fixStepComp(iter,iter + digonal );
                    if (diagLdwnR>=DOTS_TO_WIN-1) break;
                }

                if (map[(size - 1) - iter - digonal][iter] == step) { // проверка диагоналей слева вверх левее от центральной
                    diagLupL++;
                    fixStepComp((size - 1) - iter - digonal, iter );
                    if (diagLupL>=DOTS_TO_WIN-1) break;
                }

                if (map[(size - 1) - iter][iter + digonal] == step) { // проверка диагоналей слева вверх правее от центральной
                    diagLupR++;
                    fixStepComp((size - 1) - iter, iter + digonal);
                    if (diagLupR>=DOTS_TO_WIN-1) break;
                }
                iter++;
            } while (iter + digonal < size);
            if (diagLdwnL >= DOTS_TO_WIN || diagLdwnR >= DOTS_TO_WIN || diagLupL >= DOTS_TO_WIN || diagLupR >= DOTS_TO_WIN) {
                flagStep = true;
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        mapInitial();
        printMap_(); //напечатать массив
        while (true) {
            stepHuman(); //инициализация массива
            printMap_();
            if (chekWinner(DOT_X)) { //
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap_();
            if (chekWinner(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            if  (flagStep==true) {
                x = xBlokStep; // rand.nextInt(size);
                y = yBlokStep; // rand.nextInt(size);
                flagStep=false;
            }else {
                x = rand.nextInt(size);
                y =  rand.nextInt(size);
            }
        } while (!chekBox(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
    }
}

















