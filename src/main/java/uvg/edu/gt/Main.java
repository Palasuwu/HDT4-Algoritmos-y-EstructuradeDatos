package uvg.edu.gt;
public class Main {

    static CalculatorSimulator calc;
    public static void main(String[] args) {
        try{
            calc = CalculatorSimulator.getInstance();
        }catch(Exception e){

        }
        calc.execute();
    }
}
