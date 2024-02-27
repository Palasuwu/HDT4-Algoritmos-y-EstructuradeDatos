package uvg.edu.gt;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Controlador Infix

public class CalculatorSimulator {
    private static Vista v;
    private static Stack<String> linesStack;
    private static InfixCalc calc;
    static boolean flag = false;
    //static CalculatorSimulator instance;
    private	static CalculatorSimulator instance = new CalculatorSimulator();

    /**
     * Singleton implementation for the creation of the Calculator Simulator
     * @return the instance of the singleton object
     */
    public static CalculatorSimulator getInstance(){
        if (!flag){
            v = new Vista();
            int stackStype = v.askStackType();
            calc = new InfixCalc(stackStype);
            StackFactory st = new StackFactory<String>(stackStype);
            linesStack = st.createStack();
            flag = true;
        }else{

        }
        return instance;
    }

    /**
     * Driver code of the whole project
     */
    public void execute(){
        v.start();
        if(readFile()){ // IF THE FILE WAS SUCCESSFULLY READ
            while(!linesStack.isEmpty()){ // WHILE THERE'S STILL LINES TO BE OPERATED
                String temp = linesStack.pull();
                v.showResult(temp, calc.toPostfix(temp), calc.evaluate(temp));
            }
        }
    }

    /** Tries to read the file 'datos.txt' on the same path.
     * @return boolean TRUE if the file was succesfully read, FALSE if not
     */
    private boolean readFile(){
        try{
            File file = new File("datos.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){
                linesStack.push(fileReader.nextLine());
            }
            fileReader.close();
            v.successfullyRead();
            return true;
        }catch(FileNotFoundException e){
            v.fileNotFound();
            return false;
        }
    }
}