package jack;

public class DataAnalysis2D {
    private double[][] alg = new double[3][];
    private double min = Double.MAX_VALUE;
    private int index = 0;

    // Create an algorithm object from the input data and run it for all the
    // algorithms
    public DataAnalysis2D(double[] x1, double[] x2, double[] y) {
        Algorithms2D a = new Algorithms2D(x1, x2, y);
        alg[0] = a.constant();
        alg[1] = a.linear();
        alg[2] = a.quadratic();
    }

    // Create an algorithm object from the input data and run it for all the
    // algorithms
    public DataAnalysis2D(Integer[] x1, Integer[] x2, Integer[] y) {
        Algorithms2D a = new Algorithms2D(x1, x2, y);
        alg[0] = a.constant();
        alg[1] = a.linear();
        alg[2] = a.quadratic();
    }

    // Analyse the data
    public double[] analyse() {
        double[] rmses = new double[3];
        // Caculate which data has the smallest RMSE
        for (int i = 0; i < this.alg.length; i++) {
            if (this.alg[i].length == 0) {
                // use a value of -1 to indicate not applicable ie the error was too great or
                // the data did not work with that model
                rmses[i] = -1.0;
            } else {
                rmses[i] = this.alg[i][0];
                if (rmses[i] < this.min) {
                    this.min = rmses[i];
                    this.index = i;
                }
            }
        }
        // Log a message that states what algorithm fit the data best and what were the
        // calculated parameters for that algorithm
        switch (this.index) {
            case 0:
                System.out.println(
                        "The data is best represented by a constant value the value that most closely represents the data is "
                                + Double.toString(this.alg[0][1]) + " the root mean squared error is "
                                + Double.toString(this.alg[0][0]));

                break;
            case 1:
                System.out.println(
                        "The data is best represented by a 2D linear sequence the parameters that most closely represents the data are "
                                + Double.toString(this.alg[1][1]) + "x1 + " + Double.toString(this.alg[1][2]) + "x2 + "
                                + Double.toString(this.alg[1][3]) + " the root mean squared error is "
                                + Double.toString(this.alg[1][0]));

                break;
            case 2:
                System.out.println(
                        "The data is best represented by a 2D quadratic sequence the parameters that most closely represents the data are "
                                + Double.toString(this.alg[2][1]) + "x1^2 + " + Double.toString(this.alg[2][2])
                                + "x2^2 + " + Double.toString(this.alg[2][3]) + "x1 + "
                                + Double.toString(this.alg[2][4]) + "x2 + " + Double.toString(this.alg[2][5])
                                + "x1x2 + " + Double.toString(this.alg[2][6]) + " the root mean squared error is "
                                + Double.toString(this.alg[2][0]));
                break;
        }
        // Return the RMSE for all the algorithms
        return rmses;
    }
}