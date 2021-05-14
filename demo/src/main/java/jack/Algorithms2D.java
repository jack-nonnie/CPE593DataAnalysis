package jack;

public class Algorithms2D {
    private double[] x1;
    private double[] x2;
    private double[] y;
    private Integer[] x1int;
    private Integer[] x2int;
    private Integer[] yint;

    // Initialize the algorithm
    public Algorithms2D(double[] x1, double[] x2, double[] y) {
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
    }

    // Initialize the algorithm
    public Algorithms2D(Integer[] x1, Integer x2[], Integer[] y) {
        this.x1int = x1;
        this.x2int = x2;
        this.yint = y;
    }

    public double[] constant() {
        // Finding the RMSE for Integer data of a constant value
        if (this.x1 == null) {
            // If no data return empty array
            if (this.x1int == null) {
                return new double[] {};
            }
            // Finding the best constant
            double tot = 0;
            for (int d : this.yint) {
                tot += d;
            }
            // Calculating the error for that constant
            double constant = tot / this.yint.length;
            double rsm = 0;
            for (int d : this.yint) {
                rsm += (constant - d) * (constant - d);
            }
            // Returning the RMSE and the constant
            return new double[] { Math.pow(rsm, .5), constant };
        }
        // Doing the same thing as above but for double data
        double tot = 0;
        for (double d : this.y) {
            tot += d;
        }
        double constant = tot / this.y.length;
        double rsm = 0;
        for (double d : this.y) {
            rsm += (constant - d) * (constant - d);
        }
        return new double[] { Math.pow(rsm, .5), constant };
    }

    public double[] linear() {
        // Calculating the RMSE for Integer data of a 2D linear function
        if (this.x1 == null) {
            // If data is empty return empty array
            if (this.x1int == null) {
                return new double[] {};
            }
            // Initialize learning rate and parameters
            // Learning rate is tricky to find optimal
            double learningRate = .001;
            double[] parameters = new double[3];
            // batch gradient descent
            for (int j = 0; j < 10001; j++) {
                double error = 0;
                double derivativea = 0;
                double derivativeb = 0;
                double derivativec = 0;
                // calculating the derivatives of the parameters for the loss function
                for (int i = 0; i < this.x1int.length; i++) {
                    double yhat = this.x1int[i] * parameters[0] + this.x2int[i] * parameters[1] + parameters[2];
                    error += (this.yint[i] - yhat) * (this.yint[i] - yhat);
                    derivativea += (this.yint[i] - yhat) * this.x1int[i];
                    derivativeb += (this.yint[i] - yhat) * this.x2int[i];
                    derivativec += (this.yint[i] - yhat);
                }
                // if error too large break out and return empty array
                if (Double.isNaN(error)) {
                    break;
                }
                // update parmaters
                derivativea *= -2.0 / this.x1int.length;
                derivativeb *= -2.0 / this.x1int.length;
                derivativec *= -2.0 / this.yint.length;
                parameters[0] -= learningRate * derivativea;
                parameters[1] -= learningRate * derivativeb;
                parameters[2] -= learningRate * derivativec;
                // On final iteration return the RMSE and the parameters
                if (j == 10000) {
                    return new double[] { Math.pow(error / this.x1int.length, .5), parameters[0], parameters[1],
                            parameters[2] };
                }
            }
            return new double[] {};
        }
        // Same as above but for double data
        double learningRate = .001;
        double[] parameters = new double[3];
        for (int j = 0; j < 10001; j++) {
            double error = 0;
            double derivativea = 0;
            double derivativeb = 0;
            double derivativec = 0;
            for (int i = 0; i < this.x1.length; i++) {
                double yhat = this.x1[i] * parameters[0] + this.x2[i] * parameters[1] + parameters[2];
                error += (this.y[i] - yhat) * (this.y[i] - yhat);
                derivativea += (this.y[i] - yhat) * this.x1[i];
                derivativeb += (this.y[i] - yhat) * this.x2[i];
                derivativec += (this.y[i] - yhat);
            }
            if (Double.isNaN(error)) {
                break;
            }
            derivativea *= -2.0 / this.x1.length;
            derivativeb *= -2.0 / this.x1.length;
            derivativec *= -2.0 / this.y.length;
            parameters[0] -= learningRate * derivativea;
            parameters[1] -= learningRate * derivativeb;
            parameters[2] -= learningRate * derivativec;
            if (j == 10000) {
                return new double[] { Math.pow(error / this.x1.length, .5), parameters[0], parameters[1],
                        parameters[2] };
            }
        }
        return new double[] {};
    }

    public double[] quadratic() {
        // Calculating the RMSE for integer data of a 2D quadratic function
        if (this.x1 == null) {
            // if the algorithm has no data return empty array
            if (this.x1int == null) {
                return new double[] {};
            }
            // initialize learning rate and parameters
            // Learning rate is very tricky
            double learningRate = .0001;
            double[] parameters = new double[6];
            // batch gradient descent
            for (int j = 0; j < 10001; j++) {
                double error = 0;
                double derivativea = 0;
                double derivativeb = 0;
                double derivativec = 0;
                double derivatived = 0;
                double derivativee = 0;
                double derivativef = 0;
                // calculating the partial derivative of the parmaters for the loss function
                for (int i = 0; i < this.x1int.length; i++) {
                    double yhat = this.x1int[i] * this.x1int[i] * parameters[0]
                            + this.x2int[i] * this.x2int[i] * parameters[1] + this.x1int[i] * parameters[2]
                            + this.x2int[i] * parameters[3] + this.x1int[i] * this.x2int[i] * parameters[4]
                            + parameters[5];
                    error += (this.yint[i] - yhat) * (this.yint[i] - yhat);
                    derivativea += (this.yint[i] - yhat) * this.x1int[i] * this.x1int[i];
                    derivativeb += (this.yint[i] - yhat) * this.x2int[i] * this.x2int[i];
                    derivativec += (this.yint[i] - yhat) * this.x1int[i];
                    derivatived += (this.yint[i] - yhat) * this.x2int[i];
                    derivativee += (this.yint[i] - yhat) * this.x1int[i] * this.x2int[i];
                    derivativef += (this.yint[i] - yhat);
                }
                // if error is too large break out and return empty array
                if (Double.isNaN(error)) {
                    break;
                }
                // updating paramters
                derivativea *= -2.0 / this.x1int.length;
                derivativeb *= -2.0 / this.x1int.length;
                derivativec *= -2.0 / this.x1int.length;
                derivatived *= -2.0 / this.x1int.length;
                derivativee *= -2.0 / this.x1int.length;
                derivativef *= -2.0 / this.x1int.length;
                parameters[0] -= learningRate * derivativea;
                parameters[1] -= learningRate * derivativeb;
                parameters[2] -= learningRate * derivativec;
                parameters[3] -= learningRate * derivatived;
                parameters[4] -= learningRate * derivativee;
                parameters[5] -= learningRate * derivativef;
                // on the final iteration return the RMSE along with the values for each
                // parameter
                if (j == 10000) {
                    // If parameter a, b and e are too small return empty array because than the
                    // data is just 2D linear
                    if (Math.abs(parameters[0]) < .1 && Math.abs(parameters[1]) < .1 && Math.abs(parameters[4]) < .1) {
                        return new double[] {};
                    }
                    return new double[] { Math.pow(error / this.x1int.length, .5), parameters[0], parameters[1],
                            parameters[2], parameters[3], parameters[4], parameters[5] };
                }
            }
            return new double[] {};
        }
        // Same thing as above except for double data
        double learningRate = .0001;
        double[] parameters = new double[6];
        for (int j = 0; j < 10001; j++) {
            double error = 0;
            double derivativea = 0;
            double derivativeb = 0;
            double derivativec = 0;
            double derivatived = 0;
            double derivativee = 0;
            double derivativef = 0;
            for (int i = 0; i < this.x1.length; i++) {
                double yhat = this.x1[i] * this.x1[i] * parameters[0] + this.x2[i] * this.x2[i] * parameters[1]
                        + this.x1[i] * parameters[2] + this.x2[i] * parameters[3]
                        + this.x1[i] * this.x2[i] * parameters[4] + parameters[5];
                error += (this.y[i] - yhat) * (this.y[i] - yhat);
                derivativea += (this.y[i] - yhat) * this.x1[i] * this.x1[i];
                derivativeb += (this.y[i] - yhat) * this.x2[i] * this.x2[i];
                derivativec += (this.y[i] - yhat) * this.x1[i];
                derivatived += (this.y[i] - yhat) * this.x2[i];
                derivativee += (this.y[i] - yhat) * this.x1[i] * this.x2[i];
                derivativef += (this.y[i] - yhat);
            }
            if (Double.isNaN(error)) {
                break;
            }
            derivativea *= -2.0 / this.x1.length;
            derivativeb *= -2.0 / this.x1.length;
            derivativec *= -2.0 / this.x1.length;
            derivatived *= -2.0 / this.x1.length;
            derivativee *= -2.0 / this.x1.length;
            derivativef *= -2.0 / this.x1.length;
            parameters[0] -= learningRate * derivativea;
            parameters[1] -= learningRate * derivativeb;
            parameters[2] -= learningRate * derivativec;
            parameters[3] -= learningRate * derivatived;
            parameters[4] -= learningRate * derivativee;
            parameters[5] -= learningRate * derivativef;
            if (j == 10000) {
                if (Math.abs(parameters[0]) < .1 && Math.abs(parameters[1]) < .1 && Math.abs(parameters[4]) < .1) {
                    return new double[] {};
                }
                return new double[] { Math.pow(error / this.x1.length, .5), parameters[0], parameters[1], parameters[2],
                        parameters[3], parameters[4], parameters[5] };
            }
        }
        return new double[] {};
    }
}