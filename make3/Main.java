public class Main {
    public static void main (String[] args) throws Exception {
        int a = 2;
        int b = -5;
        int c = 0;

        double h = 1.0;
        double i = -3.0;

        System.out.println(intMake3(a));
        System.out.println(intMake3(b));
        System.out.println(intMake3(c));

        System.out.println(doubleMake3(h));
        System.out.println(doubleMake3(i));
    }

    public static int intMake3 (int d) {
        int e = d;
        e *= 2;
        e += 6;
        e /= 2;
        e -= d;

        return e;
    }
    
    public static double doubleMake3 (double f) {
        double g = f;
        g *= 2;
        g += 6;
        g /= 2;
        g -= f;

        return g;
    }
}