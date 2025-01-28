public class App {
    public static void main(String[] args) throws Exception {
        int[][] arr = new int[4][3];
        int current = 0;
        for (int[] row : arr) {
            for (int col = 0; col < row.length; col++) {
                row[col] = current + (arr.length * col);
            }
            current++;
        }

        for (int[] row : arr) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }
    }
}
