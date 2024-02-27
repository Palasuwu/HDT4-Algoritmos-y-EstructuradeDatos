package uvg.edu.gt;
public class InfixCalc implements IInfixCalc {
    private Stack<Character> stack;
    private PosfixCalc postfix;

    public InfixCalc(int stackType){
        StackFactory factory = new StackFactory(stackType);
        stack = factory.createStack();
        postfix = new PosfixCalc(stackType);
    }


    @Override

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

    public String toPostfix(String expresion){

        String result = new String("");



        for (int i = 0; i<expresion.length(); ++i)
        {
            char c = expresion.charAt(i);


            if (Character.isLetterOrDigit(c)){
                result += c;
                result += ' ';
            }

            else if (c == '(')
                stack.push(c);


            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '('){
                    result += stack.pull();
                    result += ' ';
                }
                stack.pull();
            }
            else
            {
                while (!stack.isEmpty() && Pemdas(c) <= Pemdas(stack.peek())){
                    result += stack.pull();
                    result += ' ';
                }
                stack.push(c);
            }
        }


        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Expresion Invalida";
            result += stack.pull();
        }

        return result;
    }

    @Override
    public int evaluate(String expression) {
        return postfix.Evaluate(toPostfix(expression));
    }
}
