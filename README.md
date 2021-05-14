# CPE593DataAnalysis
In this project I create a automated data analysis driver.
Given a set of input and output data it tries to fit the data to a constant value, linear function, quadratic function, exponential function and a sine wave.
It works for both Integer[] and double[] datasets.
It also works for 2 Dimensional data as well.
## Running the project
There are two different ways to run the project.
The first is by creating an array of data and utilizing the DataAnalysis object on your array.
I have already done an example of this for each of the possible functions and I added normally distributed noise to each of the functions so that the data is more realistic.
To run my sample data go to CPE593DataAnalysis in your terminal. Than do the following commands:
```bash
cd demo
mvn clean install
mvn compile exec:java -Dexec.mainClass="jack.App" 
```
The second way to run the project is by creating a binary file for both your input and output variable. 
If you do not wish to create your own I have provided 1 binary input file "input.dat" and 3 binary output files "lin.dat" "quad.dat" and "sin.dat"
When running the project this way the project will give you some instructions and than ask you for the name of your input file and your output file.
Make sure that both of these files are in the repository and exist/spelled correctly otherwise it will cause an error. 
It will ask you some other questions like do you want to add a second input and is the binary file a file of double[] or Integer[]. Answer honestly.
To run the project this way go to CPE593DataAnalysis in your terminal. Than do the following commands:
```bash
cd demo
mvn clean install
mvn compile exec:java -Dexec.mainClass="jack.Input" 
```
