import static java.lang.Math.abs;

public class Work2 {

//Задание №1 замена 0 на 1 и 1 на 0
    public static void changeArray (int [] array_in) {
        System.out.println("Задание №1 ");
        for (int i=0; i <= array_in.length-1; i++ ){
            if (array_in[i] == 0){
                array_in[i] = 1;
            } else {
                array_in[i] = 0;
            }
            System.out.print(array_in[i]+" ");
        }
        System.out.println("");
    }

//Задание №2  Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void arrEmpty ( ) {
        int[] arr2 = new int [8];
        System.out.println("Задание №2 ");
        for (int i=0; i <= arr2.length-1; i++ ){
            arr2[i]=3 * i;
            System.out.print(arr2[i]+" ");
        }
        System.out.println("");
    }


//Задание №3  Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void arrMullOn6 ( ) {
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Задание №3 ");
        for (int i=0; i <= arr3.length-1; i++ ){
            if (arr3[i] < 6){
                arr3[i]=arr3[i] * 2;
                System.out.print(arr3[i]+" ");
            }
        }
        System.out.println("");
    }

//Задание №4
    public static void arrDiagonali ( int[][] arr4) {
        System.out.println("Задание №4 ");
        int n = arr4.length - 1 ;
        for (int i=0; i <= n; i++ ){
            arr4[i][n-i]=1;
            for (int j=0; j <= n; j++ ) {
                if (i == j){
                    arr4[i][j]=1;
                }
                System.out.print(arr4[i][j]+" ");
            }
            System.out.println("");
        }
    }

//Задание №5
    public static void arrMinMax ( ) {
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, -1 };
        System.out.println("Задание №5 ");
        int min_v=0;
        int max_v =0;

        for (int i=0; i <= arr3.length-1 ; i++ ){
            if (arr3[i] < min_v){
                min_v = arr3[i];
            }else if(arr3[i] > max_v){
                max_v =  arr3[i];
            }
        }
        System.out.println("Mix=" + min_v + " Max=" + max_v);
    }


//Задание №6 сумма левой и правой частей равны
    public static boolean summRightLeft (int [] array_in ) {
        System.out.println("Задание №6 ");
        int n= array_in.length-1;
        for (int i=0; i <= n ; i++ ){
            int sumRight =0;
            int sumLeft  =0;

            //ищем сумму левой части
            for (int j=0; j <= i ; j++ ){
                sumLeft = sumLeft + array_in[j] ;
            }
            //ищем сумму правой части
            for (int j=i+1; j <= n ; j++ ){
                sumRight = sumRight + array_in[j] ;
            }
            //сравнение на равенство
            if (sumLeft == sumRight){
                System.out.print("найдено равенство на элементе №" + (i+1));
                System.out.println();
                return true;
            }
        }
        System.out.println();
        return false;
    }


    //Задание №7 сдвиг массива на К
    public static void arrMoov (int [] array_in, int k ) {
        System.out.println("Задание №7 ");
        int n= array_in.length-1;
        if (k < 0){ //сдвигаем массив влево
            for (int i=0; i <= n-abs(k) ; i++ ) { // n-abs(k) чтобы в цикле не вышли за пределы массива
                array_in[i] = array_in[i + abs(k)];
                array_in[i + abs(k)] = 0; // заполняем перенесенные значения нулями
            }
        }else if(k > 0) { //сдвигаем массив вправо
            for (int i = n; i >= k; i--) { // n-k чтобы в цикле не вышли за пределы массива
                array_in[i] = array_in[i-abs(k)];
                array_in[i - abs(k)] = 0; // заполняем перенесенные значения нулями
            }
        }
        for (int i=0; i <= n  ; i++ ) {
            System.out.print(array_in[i]);
        }
        System.out.println();
    }




    public static void main(String[] args) {
        // №1
        int[] a = {0,1,1,1,0,0,0,1};
        changeArray(a) ;
        // №2
        arrEmpty();
        // №3
        arrMullOn6();
        // №4
        int[][] b =new int [8][8];
        arrDiagonali(b);
        // №5
        arrMinMax();
        // №6
        int[] c = {2, 2, 2, 1, 2, 2, 10, 1};
        summRightLeft(c) ;
        // №7
        int[] d = {1, 2, 3, 4, 5, 6, 7, 8};
        int ki=-2;
        arrMoov(d, ki ) ;
    }
}
