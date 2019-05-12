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

    public void printer() throws InterruptedException {
        
        while(!this.acabou) {
            System.out.println(this.i);
            try{
            wait(100);
            }
            catch(InterruptedException e){
                acabou = true;
                System.out.println("unable to wait");
            }
        } 
    }

    public void run() {
        this.acabou = false;
        this.printer();
        while(!acabou) {
            i = in.nextInt();
            if (i == 0) {
                this.acabou = false;
            }
        }
    }

}