import java.util.Scanner;

public class movimiento{
    public static void main(String[] args){

        Scanner teclea = new Scanner(System.in);

        System.out.print("Inserte el nuemero de asteriscos lado cuadrado: ");
        int lado = teclea.nextInt();

        for(int i=1; i<=lado; i++) {
            for(int j=1; j<=lado; j++) {
                System.out.print(" * ");

            }
            System.out.println();
        }

    }
}