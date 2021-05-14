package jack;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Input {
    private Input() {

    }

    public static void main(String[] args) throws IOException {
        // This is the code I used to create the binary files that I used to test the
        // project

        // double[] x = { 1.0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
        // 18, 19, 20 };
        // double[] lin = new double[20];
        // double[] quad = new double[20];
        // double[] sin = new double[20];
        // Random rand = new Random();
        // for (int i = 0; i < 20; i++) {
        // lin[i] = x[i] * 2.5 + 7 + rand.nextGaussian();
        // quad[i] = x[i] * x[i] * .5 + x[i] * 4 - 12 + rand.nextGaussian();
        // sin[i] = 12 * Math.sin(x[i] / Math.PI + .5) + rand.nextGaussian();
        // }
        // FileOutputStream outX = new FileOutputStream("input.dat");
        // DataOutputStream doutX = new DataOutputStream(outX);
        // for (double d : x) {
        // doutX.writeDouble(d);
        // }
        // doutX.close();
        // FileOutputStream outLin = new FileOutputStream("lin.dat");
        // DataOutputStream doutLin = new DataOutputStream(outLin);
        // for (double d : lin) {
        // doutLin.writeDouble(d);
        // }
        // doutLin.close();
        // FileOutputStream outQuad = new FileOutputStream("quad.dat");
        // DataOutputStream doutQuad = new DataOutputStream(outQuad);
        // for (double d : quad) {
        // doutQuad.writeDouble(d);
        // }
        // doutQuad.close();
        // FileOutputStream outSin = new FileOutputStream("sin.dat");
        // DataOutputStream doutSin = new DataOutputStream(outSin);
        // for (double d : sin) {
        // doutSin.writeDouble(d);
        // }
        // doutSin.close();

        // DataInputStream in = new DataInputStream(new FileInputStream("input.dat"));
        // ArrayList<Double> doub = new ArrayList<Double>();
        // while (in.available() > 0) {
        // doub.add(in.readDouble());
        // }
        // double[] x1 = new double[doub.size()];
        // in.close();
        // for (int i = 0; i < doub.size(); i++) {
        // x1[i] = doub.get(i);
        // }

        // DataInputStream in2 = new DataInputStream(new FileInputStream("lin.dat"));
        // ArrayList<Double> doub2 = new ArrayList<Double>();
        // while (in2.available() > 0) {
        // doub2.add(in2.readDouble());
        // }
        // double[] linear = new double[doub2.size()];
        // in2.close();
        // for (int i = 0; i < doub2.size(); i++) {
        // linear[i] = doub2.get(i);
        // }

        // DataInputStream in3 = new DataInputStream(new FileInputStream("quad.dat"));
        // ArrayList<Double> doub3 = new ArrayList<Double>();
        // while (in3.available() > 0) {
        // doub3.add(in3.readDouble());
        // }
        // double[] quadratic = new double[doub3.size()];
        // in3.close();
        // for (int i = 0; i < doub3.size(); i++) {
        // quadratic[i] = doub3.get(i);
        // }

        // DataInputStream in4 = new DataInputStream(new FileInputStream("sin.dat"));
        // ArrayList<Double> doub4 = new ArrayList<Double>();
        // while (in4.available() > 0) {
        // doub4.add(in4.readDouble());
        // }
        // double[] sine = new double[doub4.size()];
        // in4.close();
        // for (int i = 0; i < doub4.size(); i++) {
        // sine[i] = doub4.get(i);
        // }

        // DataAnalysis a = new DataAnalysis(x1, linear);
        // System.out.println(a.analyse());

        // DataAnalysis b = new DataAnalysis(x1, quad);
        // System.out.println(b.analyse()[2]);

        // DataAnalysis c = new DataAnalysis(x1, sine);
        // System.out.println(c.analyse()[3]);
        // Introductory statements
        System.out.println(
                "The program is going to ask you for the name of the binary file that is the input variable, the output variable, if its a double and if there are two input variables. ");
        System.out.println(
                "From your answer the data will automatically be analysed and tell you the result that most closely matches your data");
        System.out.println(
                "Make sure the binary file was already added to the repository prior to running the program and that you spell the name of the file correctly. Failure to do so will cause an error.");
        System.out.println("Enter the input variable binary file name: ");
        // Asking the user for the names of the binary files that they added to the
        // repository in order to run the program on and taking in those file names
        Scanner sc = new Scanner(System.in);
        String x1Name = sc.nextLine();
        System.out.println(
                "If you would like to add a second input file type 'Y' type anything else for 1 input variable");
        String x2Name = "";
        String Var2D = sc.nextLine();
        if (Var2D.equals("Y")) {
            System.out.println("Enter the second input variable binary file name: ");
            x2Name = sc.nextLine();
        }
        System.out.println("Enter the output variable binary file name: ");
        String yName = sc.nextLine();
        System.out.println(
                "If the binary data you uploaded is a int[] type 'Y' if it is a double[] type in anything else");
        String isInt = sc.nextLine();
        // Checking to see if the data is Integer[] or double[]
        if (isInt.equals("Y")) {
            // Scanning the binary file and turing it into an ArrayList than converting the
            // ArrayList to an Integer[]
            // The reason for using an ArrayList first is because ArrayLists are Arbitrary
            // size and I need to convert it to an Integer[] to get it to work with the
            // program
            DataInputStream inx = new DataInputStream(new FileInputStream(x1Name));
            ArrayList<Integer> doubx = new ArrayList<Integer>();
            while (inx.available() > 0) {
                doubx.add(inx.readInt());
            }
            Integer[] X1 = new Integer[doubx.size()];
            inx.close();
            for (int i = 0; i < doubx.size(); i++) {
                X1[i] = doubx.get(i);
            }
            // Same Thing but for the Y var
            DataInputStream iny = new DataInputStream(new FileInputStream(yName));
            ArrayList<Integer> douby = new ArrayList<Integer>();
            while (iny.available() > 0) {
                douby.add(iny.readInt());
            }
            Integer[] Y = new Integer[douby.size()];
            iny.close();
            for (int i = 0; i < douby.size(); i++) {
                Y[i] = douby.get(i);
            }
            // Checks to see if the User wanted 2 input variables
            if (Var2D.equals("Y")) {
                DataInputStream inx2 = new DataInputStream(new FileInputStream(x2Name));
                ArrayList<Integer> doubx2 = new ArrayList<Integer>();
                while (inx2.available() > 0) {
                    doubx2.add(inx2.readInt());
                }
                Integer[] X2 = new Integer[doubx2.size()];
                inx2.close();
                for (int i = 0; i < doubx2.size(); i++) {
                    X2[i] = doubx2.get(i);
                }

                // Analyses the data
                DataAnalysis2D a = new DataAnalysis2D(X1, X2, Y);
                a.analyse();
            } else {
                // Analyses the data
                DataAnalysis a = new DataAnalysis(X1, Y);
                a.analyse();
            }
            sc.close();

        } else {
            // Scanning the binary file and turing it into an ArrayList than converting the
            // ArrayList to a Double[]
            // The reason for using an ArrayList first is because ArrayLists are Arbitrary
            // size and I need to convert it to an Double[] to get it to work with the
            // program
            DataInputStream inx = new DataInputStream(new FileInputStream(x1Name));
            ArrayList<Double> doubx = new ArrayList<Double>();
            while (inx.available() > 0) {
                doubx.add(inx.readDouble());
            }
            double[] X1 = new double[doubx.size()];
            inx.close();
            for (int i = 0; i < doubx.size(); i++) {
                X1[i] = doubx.get(i);
            }
            // Same Thing but for the Y var
            DataInputStream iny = new DataInputStream(new FileInputStream(yName));
            ArrayList<Double> douby = new ArrayList<Double>();
            while (iny.available() > 0) {
                douby.add(iny.readDouble());
            }
            double[] Y = new double[douby.size()];
            iny.close();
            for (int i = 0; i < douby.size(); i++) {
                Y[i] = douby.get(i);
            }
            // Checks to see if the user wanted 2 input vars
            if (Var2D.equals("Y")) {
                // Same thing as above but for the second input var
                DataInputStream inx2 = new DataInputStream(new FileInputStream(x2Name));
                ArrayList<Double> doubx2 = new ArrayList<Double>();
                while (inx2.available() > 0) {
                    doubx2.add(inx2.readDouble());
                }
                double[] X2 = new double[doubx2.size()];
                inx2.close();
                for (int i = 0; i < doubx2.size(); i++) {
                    X2[i] = doubx2.get(i);
                }
                // Analyses the data
                DataAnalysis2D a = new DataAnalysis2D(X1, X2, Y);
                a.analyse();
            } else {
                // Analyses the data
                DataAnalysis a = new DataAnalysis(X1, Y);
                a.analyse();
            }
            sc.close();
        }
    }

}