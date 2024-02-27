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
     *
     * @return \
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
     * Driver/
     */
    public void execute(){
        v.start();
        if(readFile()){
            while(!linesStack.isEmpty()){
                String temp = linesStack.pull();
                v.showResult(temp, calc.toPostfix(temp), calc.evaluate(temp));
            }
        }
    }

    private boolean readFile(){
        try{
            File file = new File("src\\datos.txt");
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