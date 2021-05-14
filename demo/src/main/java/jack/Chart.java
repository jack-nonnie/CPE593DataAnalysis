// :(
// This is a file I was working on in order to graph the data of the algorithms
// and compare it to the rawa data
// It did not work because my Visual Studio Code was not compatible with the
// library
// I am only keeping this on the project for my own personal use and I want to
// come back to this in the future when my Visual Studio Code is up to date and
// can work with the library
// :(

/*
 * package jack;
 * 
 * import java.awt.image.BufferedImage; import java.io.File; import
 * java.io.FileOutputStream; import java.io.IOException; import
 * java.io.OutputStream;
 * 
 * import javax.imageio.ImageIO;
 * 
 * import org.jfree.chart.ChartFactory; import org.jfree.chart.JFreeChart;
 * import org.jfree.data.xy.XYSeries; import
 * org.jfree.chart.plot.PlotOrientation; import
 * org.jfree.data.xy.XYSeriesCollection; import org.jfree.chart.ChartUtilities;
 * 
 * public class Chart { private double[] x; private double[] y; private
 * double[][] alg; private final XYSeries rawData = new XYSeries("Raw Data");
 * final XYSeriesCollection dataset = new XYSeriesCollection();
 * 
 * public Chart(double[] x, double[] y, double[][] alg) { this.x = x; this.y =
 * y; this.alg = alg; for (int i = 0; i < x.length; i++) { rawData.add(x[i],
 * y[i]); } dataset.addSeries(rawData); }
 * 
 * public void constantChart() { final XYSeries constant = new
 * XYSeries("Constant Value"); for (int i = 0; i < this.x.length; i++) {
 * constant.add(this.x[i], this.alg[0][1]); } dataset.addSeries(constant); }
 * 
 * public void linearChart() { final XYSeries linear = new
 * XYSeries("Linear Sequence"); for (int i = 0; i < this.x.length; i++) {
 * linear.add(this.x[i], this.alg[1][1] * this.x[i] + this.alg[1][2]); }
 * dataset.addSeries(linear); }
 * 
 * public void quadraticChart() { final XYSeries quadratic = new
 * XYSeries("Quadratic Sequence"); for (int i = 0; i < this.x.length; i++) {
 * quadratic.add(this.x[i], this.alg[2][1] * this.x[i] * this.x[i] +
 * this.alg[2][2] * this.x[i] + this.alg[2][3]); } dataset.addSeries(quadratic);
 * }
 * 
 * public void sineChart() { final XYSeries sin = new XYSeries("Sine Wave"); for
 * (int i = 0; i < this.x.length; i++) { sin.add(this.x[i], this.alg[3][1] *
 * Math.sin(this.alg[3][2] * this.x[i] + this.alg[3][3])); }
 * dataset.addSeries(sin); }
 * 
 * public void exponentialChart() { final XYSeries exp = new
 * XYSeries("Exponential Fit"); for (int i = 0; i < this.x.length; i++) {
 * exp.add(this.x[i], this.alg[4][1] * Math.exp(this.alg[4][2] * this.x[i])); }
 * dataset.addSeries(exp); }
 * 
 * public void makeChart(String file) throws IOException {
 * 
 * JFreeChart plot = ChartFactory.createXYLineChart("Data Analysis",
 * "Input Variable", "Output Variable", dataset, PlotOrientation.VERTICAL, true,
 * true, false); BufferedImage chartImg = plot.createBufferedImage(640, 480);
 * try (OutputStream out = new FileOutputStream(file)) { ImageIO.write(chartImg,
 * "png", out); } catch (IOException e) { throw new
 * IllegalArgumentException("Failed writing chart file"); } /* File XYChart =
 * new File(file); ChartUtilities.saveChartAsJPEG(XYChart, plot, 640, 480);
 * 
 * }
 * 
 * }
 */