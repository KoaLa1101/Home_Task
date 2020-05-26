package Task21;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixCodeTest {

    @Test
    void delete() {
        int[][] arr = new int[2][2];
        int k = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k;
                k++;
            }
        MatrixCode mc = new MatrixCode(arr);
        mc.delete(0, 0);
        Assert.assertEquals(mc.sumDiag(), 0 + arr[1][1]);
    }

    void delete1() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }

        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.delete(1, 1);
        mc1.delete(1, 1);
        Assert.assertEquals(mc.sumDiag(), mc1.sumDiag());
    }

    void delete2() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }

        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.delete(1, 1);
        mc1.delete(1, 1);
        mc.delete(0, 0);
        mc1.delete(0, 0);
        Assert.assertEquals(mc.sumDiag(), mc1.sumDiag());
    }

    void delete3() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }

        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.delete(0, 0);
        mc1.delete(0, 0);
        Assert.assertEquals(mc.get(1, 1), mc1.get(1, 1));
    }

    void delete4() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }

        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.delete(1, 0);
        mc1.delete(0, 1);
        Assert.assertEquals(mc.get(1, 1), mc1.get(1, 1));
    }

    @Test
    void sumDiag() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[3][3];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                k1++;
            }
        k1 = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                arr1[i][j] = k1;
                k1++;

                MatrixCode mc = new MatrixCode(arr);
                MatrixCode mc1 = new MatrixCode(arr1);
                mc1.delete(2, 2);
                Assert.assertEquals(mc.sumDiag(), mc1.sumDiag());
            }
    }

    void sumDiag1() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[3][3];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                k1++;
            }
        k1 = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                arr1[i][j] = k1;
                k1++;

                MatrixCode mc = new MatrixCode(arr);
                MatrixCode mc1 = new MatrixCode(arr1);
                mc1.delete(2, 2);
                mc.delete(0, 0);
                mc1.delete(0, 0);
                Assert.assertEquals(mc.sumDiag(), mc1.sumDiag());
            }
    }

    @Test
    void insert() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }
        arr1[1][1] = 5;
        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.insert(1, 1, 5);
        Assert.assertEquals(mc.get(1, 1), 5);
    }

    void insert1() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }
        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.insert(0, 0, 5);
        Assert.assertEquals(mc.get(1, 1), mc1.get(1, 1));
    }

    void insert2() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }
        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.insert(0, 0, 5);
        mc.delete(0, 0);
        mc.insert(0, 0, 0);
        Assert.assertEquals(mc.get(0, 0), mc1.get(0, 0));
    }

    void insert3() {
        int[][] arr = new int[1][1];
        arr[0][0] = 0;
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr1[i][j] = k1;
                k1++;
            }
        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.insert(0, 1, 1);
        mc.insert(1, 0, 2);
        mc.insert(1, 1, 3);
        Assert.assertEquals(mc.get(1, 1), mc1.get(1, 1));
    }

    void insert4() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }
        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.insert(0, 1, 3);
        mc.insert(1, 0, 2);
        mc.insert(1, 1, 1);
        Assert.assertEquals(mc.get(1, 0), mc1.get(1, 0));
    }


    @Test
    void sumCols() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }
        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.sumCols(0, 1);
        mc1.sumCols(0, 1);
        Assert.assertEquals(mc.get(0, 0), mc1.get(0, 0));
    }

    void sumCols1() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }
        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.sumCols(1, 1);
        mc1.sumCols(1, 1);
        Assert.assertEquals(mc.get(0, 1), mc1.get(0, 1));
    }

    @Test
    void get() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }
        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        Assert.assertEquals(mc.get(0,0), 0);
    }

    void get1() {
        int[][] arr = new int[2][2];
        int[][] arr1 = new int[2][2];
        int k1 = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = k1;
                arr1[i][j] = k1;
                k1++;
            }
        MatrixCode mc = new MatrixCode(arr);
        MatrixCode mc1 = new MatrixCode(arr1);
        mc.insert(0,0,1);
        Assert.assertEquals(mc.get(0,0), 1);
    }
}