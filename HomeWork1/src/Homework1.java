public class Homework1 {


    static float calculation (float a, float b, float c, float d) {
        return  a * (b + (c / d));
    }

    static boolean compare_ (float a, float b){
        float c = a + b;
        return ( c > 10 && c <= 20 ) ? true : false;
    }

    static void printNumb (int a ){
        if (a>=0){
            System.out.println("число больше нуля");
        }else {
            System.out.println("число меньше нуля");
        }
    }

    static void negativNumb (int a){
        if (a < 0){
            System.out.println("число меньше нуля");
        }
    }

    static void negativNumb (char a){
        System.out.println("Привет, " + a);
    }

    static void bissextileYear (int a) {
        if ((a % 4 == 0 && a%100!= 0) || a % 400 == 0 ){
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }

    public static void main(String[] args) {
        boolean b = true;
        byte by= 11;
        short Sh=24;
        int i= 127;
        long l=14;
        float f=11.3f;

        float f1 = calculation(1, 2, 3, 4);
        System.out.println(f);

        boolean b1 = compare_(11, 9);
        System.out.println(b1);
bissextileYear(20);



    }



}
