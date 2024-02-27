package uvg.edu.gt;
/**
 * Main part of the program, in charge of executing the controller of the Infix calculator
 */

public class Main {
    /**
     * Main function
     * @param args if needed
     */
    static CalculatorSimulator calc;
    public static void main(String[] args) {
        try{
            calc = CalculatorSimulator.getInstance();
        }catch(Exception e){

        }
        calc.execute();
    }
}
