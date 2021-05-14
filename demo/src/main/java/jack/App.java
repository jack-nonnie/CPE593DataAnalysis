package jack;

import java.util.Random;

public final class App {
    private App() {
    }

    /**
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        // Initial Test Without any noise
        // double[] x = { 1.0, 2, 3, 4, 5, 6, 7, 8 };
        // double[] y = new double[8];
        // for (int i = 0; i < 8; i++) {
        // y[i] = 3 * x[i] + 7;
        // }
        // DataAnalysis a = new DataAnalysis(x, y);
        // System.out.println("1: ");
        // a.analyse();

        // for (int i = 0; i < 8; i++) {
        // y[i] = 5 * x[i] * x[i] + -4 * x[i] + 1;
        // }
        // DataAnalysis b = new DataAnalysis(x, y);
        // System.out.println("2: ");
        // b.analyse();

        // for (int i = 0; i < 8; i++) {
        // y[i] = -2 * Math.exp(-3 * x[i]);
        // }
        // DataAnalysis c = new DataAnalysis(x, y);
        // System.out.println("3: ");
        // c.analyse();
        // //c.makeAllChart("chart3.jpeg");

        // for (int i = 0; i < 8; i++) {
        // x[i] = Math.PI / 4 * i;
        // y[i] = 1.2 * Math.sin(0.7 * x[i] - 1.2);
        // }
        // System.out.println("4: ");
        // DataAnalysis d = new DataAnalysis(x, y);
        // d.analyse();
        // // d.makeBestChart("chart4.jpeg");

        // int[] x1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int[] y1 = new int[8];
        // for (int i = 0; i < 8; i++) {
        // y1[i] = 3 * x1[i] + 7;
        // }
        // DataAnalysis e = new DataAnalysis(x1, y1);
        // System.out.println("5: ");
        // e.analyse();

        // for (int i = 0; i < 8; i++) {
        // y1[i] = 5 * x1[i] * x1[i] + -4 * x1[i] + 1;
        // }
        // DataAnalysis f = new DataAnalysis(x1, y1);
        // System.out.println("6: ");
        // f.analyse();

        // double[] x2 = { 1.0, 2, 3, 4, 5, 6, 7, 8 };
        // double[] x3 = { .5, 1, 1.5, 2, 2.5, 3, 3.5, 4 };
        // for (int i = 0; i < 8; i++) {
        // y[i] = 3 * x2[i] - 5 * x3[i] + 11;
        // }
        // DataAnalysis2D g = new DataAnalysis2D(x2, x3, y);
        // System.out.println("7: ");
        // g.analyse();

        // for (int i = 0; i < 8; i++) {
        // y[i] = -3 * x2[i] * x2[i] - 1 * x3[i] * x3[i] + 11 * x2[i] - 4 * x3[i] + 2 *
        // x2[i] * x3[i] - 2;
        // }
        // DataAnalysis2D h = new DataAnalysis2D(x2, x3, y);
        // System.out.println("8: ");
        // h.analyse();
        // Going through all of the possible cases and analysing the data
        // Random in order to generate noise
        Random rand = new Random();
        double[] x = { 1.0, 2, 3, 4, 5, 6, 7, 8 };
        double[] y = new double[8];
        // creating the y linear data and than analysing
        for (int i = 0; i < 8; i++) {
            y[i] = 3 * x[i] + 7 + 3 * rand.nextGaussian();
        }
        DataAnalysis a = new DataAnalysis(x, y);
        System.out.println("1: ");
        a.analyse();

        // creating the y quadratic data and than analysing
        for (int i = 0; i < 8; i++) {
            y[i] = 5 * x[i] * x[i] + -4 * x[i] + 1 + 3 * rand.nextGaussian();
        }
        DataAnalysis b = new DataAnalysis(x, y);
        System.out.println("2: ");
        b.analyse();

        // creating the y exp data and than analysing
        for (int i = 0; i < 8; i++) {
            y[i] = 2 * Math.exp(3 * x[i]) + 3 * rand.nextGaussian();
        }
        DataAnalysis c = new DataAnalysis(x, y);
        System.out.println("3: ");
        c.analyse();

        // creating the y sin data and than analysing
        for (int i = 0; i < 8; i++) {
            x[i] = Math.PI / 4 * i;
            y[i] = 10 * Math.sin(.9 * x[i] - 1.2) + rand.nextGaussian();
        }
        System.out.println("4: ");
        DataAnalysis d = new DataAnalysis(x, y);
        d.analyse();

        // creating the y linear data (Integer[]) and than analysing
        Integer[] x1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Integer[] y1 = new Integer[8];
        for (int i = 0; i < 8; i++) {
            y1[i] = 3 * x1[i] + 7;
        }
        DataAnalysis e = new DataAnalysis(x1, y1);
        System.out.println("5: ");
        e.analyse();

        // creating the y quadratic data (Integer[]) and than analysing
        for (int i = 0; i < 8; i++) {
            y1[i] = 5 * x1[i] * x1[i] + -4 * x1[i] + 1;
        }
        DataAnalysis f = new DataAnalysis(x1, y1);
        System.out.println("6: ");
        f.analyse();

        // creating the y linear 2D data and than analysing
        double[] x2 = { 1.0, 2, 3, 4, 5, 6, 7, 8 };
        double[] x3 = { .5, 1, 1.5, 2, 2.5, 3, 3.5, 4 };
        for (int i = 0; i < 8; i++) {
            y[i] = 3 * x2[i] - 5 * x3[i] + 11 + 3 * rand.nextGaussian();
        }
        DataAnalysis2D g = new DataAnalysis2D(x2, x3, y);
        System.out.println("7: ");
        g.analyse();

        // creating the y quadratic 2D data and than analysing
        for (int i = 0; i < 8; i++) {
            y[i] = -3 * x2[i] * x2[i] - 1 * x3[i] * x3[i] + 11 * x2[i] - 4 * x3[i] + 2 * x2[i] * x3[i] - 2
                    + 3 * rand.nextGaussian();
        }
        DataAnalysis2D h = new DataAnalysis2D(x2, x3, y);
        System.out.println("8: ");
        h.analyse();

    }
}
