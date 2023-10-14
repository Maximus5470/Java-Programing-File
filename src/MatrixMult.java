import java.util.Arrays;
class Loadin {

    public void matAdd(int[][] m1, int[][] m2) {
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2.length; j++) {
                m1[i][j] += m2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(m1));
    }

    public void matSub(int[][] m1, int[][] m2) {
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2.length; j++) {
                m1[i][j] -= m2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(m1));
    }

    public void matMult(int[][] m1, int[][] m2) {
        int[][] res = new int[3][3];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                for (int k = 0; k < m2[j].length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(res));
    }
}

public class MatrixMult {
    public static void main(String[] args) {
        int[][] mat1 = { { 2, 1, 5 },
                { 3, 6, 1 },
                { 8, 4, 2 } };
        int[][] mat2 = { { 8, 3, 2 },
                { 9, 5, 7 },
                { 4, 3, 6 } };
        Loadin obj = new Loadin();
        obj.matAdd(mat1, mat2);
    }
}