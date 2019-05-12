import java.util.Scanner;

public class Aula01 {
    static Scanner in = new Scanner(System.in);
    public static void main(String args[]) {
        System.out.println("hello world");
        PrinterI tester = new PrinterI();
        Thread t1 = new Thread(tester);
        t1.start();
    }

}

class PrinterI implements Runnable{
    static Scanner in = new Scanner(System.in);
    int i;
    boolean acabou;

    PrinterI() {
        this.i = 0;
        this.acabou = false;
    }

    public void printer() {
        
        while(!this.acabou) {
            System.out.println(this.i);
            try{
                Thread.sleep(100);
            }catch (InterruptedException ie) {
                this.acabou = true;
                System.out.println("unable to interrupt");
            }
            
        } 
    }

    public void run() {
        this.acabou = false;
        printer();
        while(!this.acabou) {
            i = in.nextInt();
            if (i == 0) {
                this.acabou = true;
            }
        }
    }

}