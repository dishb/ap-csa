public class Main {
    public static void main(String[] args) {

        int a = -2;
        int b = 5;
        int c = 11;

        multiples12(a);
        multiples12(b);
        multiples12(c);
        
        int f = ifMethod(a, b);
        int g = ifMethod(b, c);
        int h = ifMethod(c, a);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);

    }
    public static void multiples12(int d){
        for(int i=1; i<13; i++){
            int e=d*i;
            System.out.println(e);
        }
    }

    public static int ifMethod(int j, int k) {
        if (j > k) {
            return (j^2 + k);
        } else if (j < k) {
            return (k - j);
        }

        return -1;
    }

}
