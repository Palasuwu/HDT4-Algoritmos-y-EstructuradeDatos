package uvg.edu.gt;
/**
 * Implementation of the infix calculator
 * Reference: https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 */
public class InfixCalc implements IInfixCalc {
    private Stack<Character> stack;
    private PosfixCalc postfix;

    /**
     * Constructor of the infix calculator
     * @param stackType the kind
     */
    public InfixCalc(int stackType){
        StackFactory factory = new StackFactory(stackType);
        stack = factory.createStack();
        postfix = new PosfixCalc(stackType);
    }


    @Override
    /***
     * This method is used as a part of the process to evaluate an infix expression, it is used to know the order of Pemdasedence in a operation
     * @param char ch
     * @return the value of the order of Pemdasedence to operate
     */
    public int Pemdas(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    @Override
    /***
     * This method is used to evaluate a postfix expression
     * @param expresion this is a single expression like: 1 2 + 4 * 3 +
     * @return the evaluation of the expression
     */
    public String toPostfix(String expresion){
        // initializing empty String for result
        String result = new String("");



        for (int i = 0; i<expresion.length(); ++i)
        {
            char c = expresion.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c)){
                result += c;
                result += ' ';
            }

            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')',
                // pull and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '('){
                    result += stack.pull();
                    result += ' ';
                }
                stack.pull();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Pemdas(c) <= Pemdas(stack.peek())){
                    result += stack.pull();
                    result += ' ';
                }
                stack.push(c);
            }
        }

        // pull all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pull();
        }

        return result;
    }

    @Override
    public int evaluate(String expression) {
        return postfix.Evaluate(toPostfix(expression));
    }
}
