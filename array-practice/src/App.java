public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[8];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 3 * i;
        }

        for (int x : numbers) {
            System.out.println(x);
        }

        int[] arr = new int[numbers.length * 3];

        for (int i = 0; i < 4; i++) {
            arr[i] = numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 42;
        }
    }

    public static int range(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }

        return (max - min + 1);
    }

    public static int mode(int[] arr) {
        int mode1 = 0;
        int mode2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < arr.length; i++) {
            mode1 = arr[i];
            count1 = 1;

            for (int j = i + 1; j < arr.length; j++) {
                if (mode1 == arr[j]) {
                    count1++;
                }

                if (count1 > count2) {
                    mode2 = mode1;
                    count2 = count1;
                } else if (count1 == count2) {
                    mode2 = Math.min(mode1, mode2);
                }
            }
        }

        return mode2;
    }
}
