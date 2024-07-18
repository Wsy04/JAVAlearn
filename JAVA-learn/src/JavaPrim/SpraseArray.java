package JavaPrim;

public class SpraseArray {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = 0;
            }
        }
        arr[1][3] = 1;
        arr[2][6] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int valid = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] != 0) {
                    valid++;//获取有效值个数
                }
            }
        }

        int[][] sparseArr = new int[valid+1][3];//表头为:行数,列数,有效值个数
        sparseArr[0][0] =  arr.length;
        sparseArr[0][1] =  arr[0].length;
        sparseArr[0][2] =  valid;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[0].length; j++) {
                System.out.print(sparseArr[i][j] + " ");
            }
            System.out.println();
        }

        int[][] arr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            arr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
