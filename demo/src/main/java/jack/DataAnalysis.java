package jack;

public class DataAnalysis {
    private double[][] alg = new double[5][];
    private double min = Double.MAX_VALUE;
    private int index = 0;

    // Create an algorithm object from the input data and run it for all the
    // algorithms
    public DataAnalysis(double[] x, double[] y) {
        Algorithms a = new Algorithms(x, y);
        alg[0] = a.constant();
        alg[1] = a.linear();
        alg[2] = a.quadratic();
        alg[3] = a.sin();
        alg[4] = a.exponential();
    }

    // Create an algorithm object from the input data and run it for all the
    // algorithms
    public DataAnalysis(Integer[] x, Integer[] y) {
        Algorithms a = new Algorithms(x, y);
        alg[0] = a.constant();
        alg[1] = a.linear();
        alg[2] = a.quadratic();
        alg[3] = a.sin();
        alg[4] = a.exponential();
    }

    // Analyse the data
    public double[] analyse() {
        double[] rmses = new double[5];
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
                        "The data is best represented by a linear sequence the parameters that most closely represents the data are "
                                + Double.toString(this.alg[1][1]) + "x + " + Double.toString(this.alg[1][2])
                                + " the root mean squared error is " + Double.toString(this.alg[1][0]));

                break;
            case 2:
                System.out.println(
                        "The data is best represented by a quadratic sequence the parameters that most closely represents the data are "
                                + Double.toString(this.alg[2][1]) + "x^2 + " + Double.toString(this.alg[2][2]) + "x + "
                                + Double.toString(this.alg[2][3]) + " the root mean squared error is "
                                + Double.toString(this.alg[2][0]));
                break;
            case 3:
                System.out.println(
                        "The data is best represented by a sine wave the parameters that most closely represents the data are "
                                + Double.toString(this.alg[3][1]) + " * sin(" + Double.toString(this.alg[3][2]) + "x + "
                                + Double.toString(this.alg[3][3]) + ") the root mean squared error is "
                                + Double.toString(this.alg[3][0]));
                break;
            case 4:
                System.out.println(
                        "The data is best represented by an exponential fit the parameters that most closely represents the data are "
                                + Double.toString(this.alg[4][1]) + "e^(" + Double.toString(this.alg[4][2])
                                + " * x) the root mean squared error is " + Double.toString(this.alg[4][0]));
                break;

        }
        // return all the RMSE
        return rmses;

    }
    // :(((((((
    /*
     * 
     * // WILL CAUSE AN ERROR IF ANALYSE ISNT CALLED FIRST public void
     * makeBestChart(String file) throws IOException { Chart chart = new
     * Chart(this.x, this.y, this.alg); switch (this.index) { case 0:
     * chart.constantChart(); break; case 1: chart.linearChart(); break; case 2:
     * chart.quadraticChart(); break; case 3: chart.sineChart(); break; case 4:
     * chart.exponentialChart(); break; } chart.makeChart(file); }
     * 
     * // WILL CAUSE AN ERROR IF ANALYSE ISNT CALLED FIRST public void
     * makeAllChart(String file) throws IOException { Chart chart = new
     * Chart(this.x, this.y, this.alg); if (this.alg[0].length > 0) {
     * chart.constantChart(); } if (this.alg[1].length > 0) { chart.linearChart(); }
     * if (this.alg[2].length > 0) { chart.quadraticChart(); } if
     * (this.alg[3].length > 0) { chart.sineChart(); } if (this.alg[4].length > 0) {
     * chart.exponentialChart(); } chart.makeChart(file); }
     * 
     * }
     */
}
