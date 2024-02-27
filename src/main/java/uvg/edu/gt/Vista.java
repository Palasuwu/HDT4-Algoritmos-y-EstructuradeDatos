package uvg.edu.gt;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Vista {
    private Scanner scan;


    public Vista(){
        scan = new Scanner(System.in);
    }


    private void prnt(String text){
        System.out.println(text);
    }


    private void separation(){
        prnt("--------------------------------------------------------------------------------");
    }


    public void start(){
        separation();
        prnt("Bienvenido a la calculadora POSTFIX");
        prnt("* leyendo 'datos.txt' *");
    }


    public void invalidOption(){
        prnt("Ha ingresado una opcion invalida. Intente de nuevo.");
    }


    public int askStackType(){
        separation();
        prnt("Ingrese el tipo de Stack que desea usar :) : ");
        prnt("1. Stack de ArrayList");
        prnt("2. Stack de Vectores");
        prnt("3. Stack de Listas");
        while(true){
            try{
                int option = scan.nextInt();
                scan.nextLine();
                if(option == 1 || option == 2){
                    return option;
                }else if(option == 3){
                    String temp = "3" + askList();
                    return Integer.parseInt(temp);
                }else {
                    throw new InputMismatchException();
                }
            }catch(InputMismatchException e){
                scan.next();
                invalidOption();
            }
        }
    }


    private int askList(){
        prnt("Que tipo de Listas desea usar?");
        prnt("1. Simplemente encadenadas");
        prnt("2. Doblemente encadenadas");
        while(true){
            try{
                int option = scan.nextInt();
                scan.nextLine();
                if(option == 1 || option == 2){
                    return option;
                }else{
                    throw new InputMismatchException();
                }
            }catch(InputMismatchException e){
                scan.next();
                invalidOption();
            }
        }
    }


    public void successfullyRead(){
        prnt("Leido exitosamente");
        separation();
    }


    public void fileNotFound(){
        prnt("NO SE HA ENCONTRADO EL ARCHIVO 'datos.txt'. ");
        prnt("QUE en la carpeta donde se encuentra 'main.java'.");
    }


    public void showResult(String expression, String postfix, int result){
        prnt("Se ha evaluado la siguiente expresion: " + expression);
        prnt("Se ha convertido a: " + postfix);
        prnt("Resultado: " + result);
        separation();
    }
}
