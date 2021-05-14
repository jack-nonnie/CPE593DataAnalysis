package jack;

public class Algorithms {
    private double[] x;
    private double[] y;
    private Integer[] xint;
    private Integer[] yint;

    // Initializing the algorithm
    Algorithms(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    // Initializing the algorithm for integer data
    Algorithms(Integer[] x, Integer[] y) {
        this.xint = x;
        this.yint = y;
    }

    public double[] constant() {
        // Finding the RMSE for integer data of a constant value
        if (this.x == null) {
            if (this.xint == null) {
                // If the algorithm has no data return an empty array
                return new double[] {};
            }
            // Finding constant that best resembles data
            double tot = 0;
            for (int d : this.yint) {
                tot += d;
            }
            // finding error for that constant
            double constant = tot / this.yint.length;
            double rsm = 0;
            for (int d : this.yint) {
                rsm += (constant - d) * (constant - d);
            }
            return new double[] { Math.pow(rsm, .5), constant };
        }
        // Doing the above but for double[] data
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
        // Finding the RMSE for Integer data of a linear function
        if (this.x == null) {
            if (this.xint == null) {
                // If the algorithm has no data return empty list
                return new double[] {};
            }
            // init learning rate and parameters
            // Learning rate is Tricky sometimes it is too much other times too little
            double learningRate = .001;
            double[] parameters = new double[2];
            // Batch Gradient Descent
            for (int j = 0; j < 100001; j++) {
                double error = 0;
                double derivativem = 0;
                double derivativec = 0;
                // calculating the derivatives of the parameters loss functions
                for (int i = 0; i < this.xint.length; i++) {
                    double yhat = this.xint[i] * parameters[0] + parameters[1];
                    error += (this.yint[i] - yhat) * (this.yint[i] - yhat);
                    derivativem += (this.yint[i] - yhat) * this.xint[i];
                    derivativec += (this.yint[i] - yhat);
                }
                // If error is too large break out and return empty array
                if (Double.isNaN(error)) {
                    break;
                }
                // Finish calculations for derivatives of parameters and update parameters
                derivativem *= -2.0 / this.xint.length;
                derivativec *= -2.0 / this.yint.length;
                parameters[0] -= learningRate * derivativem;
                parameters[1] -= learningRate * derivativec;
                // On the last iteration return the RMSE and the values of the parameters
                if (j == 100000) {
                    return new double[] { Math.pow(error / this.xint.length, .5), parameters[0], parameters[1] };
                }
            }
            return new double[] {};

        }
        // Same thing as above except for double[] data
        double learningRate = .001;
        double[] parameters = new double[2];
        for (int j = 0; j < 100001; j++) {
            double error = 0;
            double derivativem = 0;
            double derivativec = 0;
            for (int i = 0; i < this.x.length; i++) {
                double yhat = this.x[i] * parameters[0] + parameters[1];
                error += (this.y[i] - yhat) * (this.y[i] - yhat);
                derivativem += (this.y[i] - yhat) * this.x[i];
                derivativec += (this.y[i] - yhat);
            }
            if (Double.isNaN(error)) {
                break;
            }
            derivativem *= -2.0 / this.x.length;
            derivativec *= -2.0 / this.y.length;
            parameters[0] -= learningRate * derivativem;
            parameters[1] -= learningRate * derivativec;
            if (j == 100000) {
                return new double[] { Math.pow(error / this.x.length, .5), parameters[0], parameters[1] };
            }
        }
        return new double[] {};
    }

    public double[] quadratic() {
        // Finding the RMSE for integer data for a quadratic function
        if (this.x == null) {
            if (this.xint == null) {
                // If the algorithm has no data return empty array
                return new double[] {};
            }
            // Initialize learning rate and parameters
            // Learning rate is tricky sometimes too big sometimes too small for further
            // work work on an adaptive learning rate
            double learningRate = .000001;
            double[] parameters = new double[3];
            // batch gradient descent
            for (int j = 0; j < 100001; j++) {
                // Iterate through and find derivative for each var in the loss function
                double error = 0;
                double derivativea = 0;
                double derivativeb = 0;
                double derivativec = 0;
                // update derivatives for parameters
                for (int i = 0; i < this.xint.length; i++) {
                    double yhat = this.xint[i] * this.xint[i] * parameters[0] + parameters[1] * this.xint[i]
                            + parameters[2];
                    error += (this.yint[i] - yhat) * (this.yint[i] - yhat);
                    derivativea += (this.yint[i] - yhat) * this.xint[i] * this.xint[i];
                    derivativeb += (this.yint[i] - yhat) * this.xint[i];
                    derivativec += (this.yint[i] - yhat);
                }
                // If error is too large break out and return empty array
                if (Double.isNaN(error)) {
                    break;
                }
                // Finish calc derivatives and update params
                derivativea *= -2.0 / this.xint.length;
                derivativeb *= -2.0 / this.xint.length;
                derivativec *= -2.0 / this.yint.length;
                parameters[0] -= learningRate * derivativea;
                parameters[1] -= learningRate * derivativeb;
                parameters[2] -= learningRate * derivativec;
                // On last iteration return RMSE and the parameters
                if (j == 100000) {
                    // If parameter a is too small data is linear so return empty array
                    if (Math.abs(parameters[0]) < .1) {
                        return new double[] {};
                    }
                    return new double[] { Math.pow(error / this.xint.length, .5), parameters[0], parameters[1],
                            parameters[2] };
                }
            }
            return new double[] {};

        }
        // Same thing as above but for double data
        double learningRate = .000001;
        double[] parameters = new double[3];
        for (int j = 0; j < 100001; j++) {
            double error = 0;
            double derivativea = 0;
            double derivativeb = 0;
            double derivativec = 0;
            for (int i = 0; j < 0 && this.x.length > 5 ? i < 5 : i < this.x.length; i++) {
                double yhat = this.x[i] * this.x[i] * parameters[0] + parameters[1] * this.x[i] + parameters[2];
                error += (this.y[i] - yhat) * (this.y[i] - yhat);
                derivativea += (this.y[i] - yhat) * this.x[i] * this.x[i];
                derivativeb += (this.y[i] - yhat) * this.x[i];
                derivativec += (this.y[i] - yhat);
            }
            if (Double.isNaN(derivativea) || Double.isNaN(derivativeb) || Double.isNaN(derivativec)) {
                break;
            }
            derivativea *= j < 20 && this.x.length > 5 ? -2.0 / 5 : -2.0 / this.x.length;
            derivativeb *= j < 20 && this.x.length > 5 ? -2.0 / 5 : -2.0 / this.x.length;
            derivativec *= j < 20 && this.x.length > 5 ? -2.0 / 5 : -2.0 / this.x.length;
            parameters[0] -= learningRate * derivativea;
            parameters[1] -= learningRate * derivativeb;
            parameters[2] -= learningRate * derivativec;

            if (j == 100000) {
                if (Math.abs(parameters[0]) < .1) {
                    return new double[] {};
                }
                return new double[] { Math.pow(error / this.x.length, .5), parameters[0], parameters[1],
                        parameters[2] };
            }
        }
        return new double[] {};
    }

    // BE CAREFUL if values of input are too large may return empty array because
    // the error becomes too large. The equation can be changed to prevent this by
    // not calculating the real RMSE and only calculating the log RMSE like done
    // originally but if this is done it does not make for an accurate comparison.
    public double[] exponential() {
        // If the data is integer return empty array
        if (this.x == null) {
            return new double[] {};
        }
        // Find the RMSE for a exp function
        // Initialize parameters and learning rate
        double learningRate = .001;
        double[] parameters = new double[2];
        // Do not let data be 0 cause taking log of data
        parameters[0] += .001;
        parameters[1] += .001;
        for (int j = 0; j < 100001; j++) {
            // calculating derivative of parameters for the loss function
            double error = 0;
            double derivativea = 0;
            double derivativeb = 0;
            for (int i = 0; i < this.x.length; i++) {
                // Using log of loss so data does not get too large
                // Calculations in Documents
                // Calculating derivatives
                double yhat = this.x[i] * parameters[1] + Math.log(Math.abs(parameters[0]));
                error += (Math.log(Math.abs(this.y[i])) - yhat) * (Math.log(Math.abs(this.y[i])) - yhat);
                derivativea += (Math.log(Math.abs(this.y[i])) - yhat);
                derivativeb += (Math.log(Math.abs(this.y[i])) - yhat) * this.x[i];
            }
            // If error gets too large breaking out and returning empty array
            if (Double.isNaN(error)) {
                break;
            }
            // updating parmaters
            derivativea *= -2.0 / this.x.length;
            derivativeb *= -2.0 / this.y.length;
            parameters[0] -= learningRate * derivativea;
            parameters[1] -= learningRate * derivativeb;
            // On the last iteration returning error and parameter values
            if (j == 100000) {
                // Error had previously been calculated using the logs have to reiterate through
                // the data to calculate error normally
                // Above since the logs of one of the parameters is taken the absolute value of
                // that param is utilized so now have to calculate the error for both the
                // positive and negative value for that param
                double rsm = 0;
                double nrsm = 0;
                for (int i = 0; i < this.x.length; i++) {
                    rsm += (this.y[i] - parameters[0] * Math.exp(parameters[1] * this.x[i]))
                            * (this.y[i] - parameters[0] * Math.exp(parameters[1] * this.x[i]));
                    if (Double.isNaN(rsm)) {
                        break;
                    }
                }

                for (int i = 0; i < this.x.length; i++) {
                    nrsm += (this.y[i] + parameters[0] * Math.exp(parameters[1] * this.x[i]))
                            * (this.y[i] + parameters[0] * Math.exp(parameters[1] * this.x[i]));
                    // If both values of the param result in an error too high returns empty array
                    // if one does returns error for the other value of the param
                    if (Double.isNaN(nrsm)) {
                        if (Double.isNaN(rsm)) {
                            return new double[] {};
                        }
                        return new double[] { Math.pow(rsm / this.x.length, .5), parameters[0], parameters[1] };
                    }
                }
                if (Double.isNaN(rsm)) {
                    return new double[] { Math.pow(nrsm / this.x.length, .5), -1 * parameters[0], parameters[1] };
                }
                // comparing the results of the parameter and returning the error and parameters
                // of the more favorable parameter
                if (rsm > nrsm) {
                    return new double[] { Math.pow(nrsm / this.x.length, .5), -1 * parameters[0], parameters[1] };
                } else {
                    return new double[] { Math.pow(rsm / this.x.length, .5), parameters[0], parameters[1] };
                }
            }
        }
        return new double[] {};
    }

    public double[] sin() {
        // Finding the RMSE for a sine wave
        // If the data is integer return empty array
        if (this.x == null) {
            return new double[] {};
        }
        // Initializing learning rate and parameters
        double learningRate = .001;
        double[] parameters = new double[3];
        // batch gradient descent
        for (int j = 0; j < 100001; j++) {
            double error = 0;
            double derivativea = 0;
            double derivativeb = 0;
            double derivativec = 0;
            // calculating the derivative of the loss function for each parameter
            for (int i = 0; i < this.x.length; i++) {
                double yhat = parameters[0] * Math.sin(parameters[1] * this.x[i] + parameters[2]);
                error += (this.y[i] - yhat) * (this.y[i] - yhat);
                derivativea += (this.y[i] - yhat) * Math.sin(parameters[1] * this.x[i] + parameters[2]);
                derivativeb += (this.y[i] - yhat) * Math.cos(parameters[1] * this.x[i] + parameters[2]) * this.x[i];
                derivativec += (this.y[i] - yhat) * Math.cos(parameters[1] * this.x[i] + parameters[2]);
            }
            // if error too large break out and return empty array
            if (Double.isNaN(error)) {
                break;
            }
            // update parameters
            derivativea *= -2.0 / this.x.length;
            derivativeb *= -2.0 / this.x.length;
            derivativec *= -2.0 / this.y.length;
            parameters[0] -= learningRate * derivativea;
            parameters[1] -= learningRate * derivativeb;
            parameters[2] -= learningRate * derivativec;
            // return RMSE and the parameters
            if (j == 100000) {
                return new double[] { Math.pow(error / this.x.length, .5), parameters[0], parameters[1],
                        parameters[2] };
            }
        }
        return new double[] {};
    }
}