import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

class Matrix {

    int nRows;
    int nCols;
    double[][] mat;
    String name;

    Matrix(int rows, int cols, String name) {
        this.nRows = rows;
        this.nCols = cols;
        this.mat = new double[rows][cols];
        this.name = name;
    }

    Matrix(double[][] m) {

        this.nRows = m.length;
        this.nCols = m[0].length;
        this.mat = m;
    }

    Matrix(double[] m) {
        this.nRows = 1;
        this.nCols = m.length;

        this.mat = new double[1][m.length];
        this.mat[0] = m;

    }

    // Copy Constructor
    Matrix(Matrix m) {
        this.mat = deepCopy(m.mat);
        this.nRows = m.nRows;
        this.nCols = m.nCols;
    }

    public String getName() {
        return this.name;
    }

    public double[][] deepCopy(double[][] matrix) {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }

    public double[][] toArray() {
        return this.mat;
    }

    public static boolean equals(Matrix m1, Matrix m2) {
        return Arrays.deepEquals(m1.mat, m2.mat);
    }

    public void printMatrix() {
        for (int i = 0; i < nRows; i++) {
            System.out.print("[ ");
            for (int j = 0; j < this.nCols; j++) {
                System.out.print(this.mat[i][j] + " ");
            }
            System.out.println(" ]");
        }
        System.out.println();
    }

}

public class Assignment4_Q2 {

    public static ArrayList<Matrix> matrixArray = new ArrayList<Matrix>();
    public static Scanner scan = new Scanner(System.in);

    public static void menu() {
        System.out.println("1. Input and create an image matrix");
        System.out
                .println("2. Update an image matrix.");
        System.out.println("3. Display an image matrix.");
        System.out.println("4. Compute negative of an image.");
        System.out.println("5. Exit");
    }

    public static Matrix getMatrixByName() {
        System.out.println("Enter name of the image matrix: ");
        String name2 = scan.next(); String name;
        for (int j = 0; j < matrixArray.size(); j++) {
            Matrix matrix = matrixArray.get(j);
            name = matrix.getName();
            if (name.compareTo(name2) == 0) {
                    return matrix;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        int flag = 1;
        int start;
        while (flag == 1) {
            menu();
            start = scan.nextInt();
            if (start == 1) {
                System.out.println("Please enter the name of the image matrix : ");
                String name_mat = scan.next();

                System.out.println("Please enter the type of the image(color/grayscale) : ");
                String type_mat = scan.next();
                String color = "color";
                String grayscale = "grayscale";

                if(type_mat.compareTo(color) == 0){
                    int row = 1; int col = 3;
                    Matrix m = new Matrix(row, col, name_mat);
                    fillingMatrix(scan, m, row, col);
                matrixArray.add(m);
                }
                else if(type_mat.compareTo(grayscale) == 0){
                    int row = 1; int col = 1;
                    Matrix m = new Matrix(row, col, name_mat);
                    fillingMatrix(scan, m, row, col);
                    matrixArray.add(m);
                }
            } else if (start == 2) {
                Matrix matrix1 = getMatrixByName();
                matrix1 = update(matrix1);

            } else if (start == 3) {
                Matrix matrix1 = getMatrixByName();
                matrix1.printMatrix();


            } else if (start == 4) {
                Matrix matrix1 = getMatrixByName();
                Matrix matrix2 = null;
                if(matrix1 != null){
                    matrix2 = negative(matrix1);
                    matrix2.printMatrix();
                }
                
            } else if(start == 5){
                flag = 0;
            }
        }
    }

    public static Matrix negative(Matrix m) {

        Matrix negat = new Matrix(m.nCols, m.nRows, m.name);

        for (int i = 0; i < m.nRows; i++) {

            for (int j = 0; j < m.nCols; j++) {

                negat.mat[j][i] = 255 - m.mat[i][j];

            }
        }

        return negat;
    }

    public static Matrix update(Matrix m) {

        if(m.nCols == 3){
            System.out.println("Please enter updated values of red, blue, green in the image : ");
            String bn;
        for (int a = 0; a < m.nRows; a++) {
            for (int b = 0; b < m.nCols; b++) {
                bn= scan.next();  
                m.mat[a][b] = Integer.parseInt(bn,2);
            }
        }
        }
        else if(m.nCols == 1){
            System.out.println("Please enter updated value of grey in the image : ");
            String bn;
        for (int a = 0; a < m.nRows; a++) {
            for (int b = 0; b < m.nCols; b++) {
                bn= scan.next();  
                m.mat[a][b] = Integer.parseInt(bn,2);
            }
        }
        }
        return m;
    }


    public static void fillingMatrix(Scanner scan, Matrix m, int rows, int columns) {
        if(columns == 3){
            System.out.println("Please enter values of red, blue, green in the image : ");
            String bn;
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < columns; b++) {
                 bn= scan.next();  
                m.mat[a][b] = Integer.parseInt(bn,2);
            }
        }
        }
        else if(columns == 1){
            System.out.println("Please enter value of grey in the image : ");
            String bn;
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < columns; b++) {
                bn= scan.next();  
                m.mat[a][b] = Integer.parseInt(bn,2);
            }
        }
        }
    }
}
