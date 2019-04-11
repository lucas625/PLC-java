import java.util.Scanner;

public class Q1 {
    static Scanner in = new Scanner(System.in);
    public static void main(String args[]) {
        int valor = in.nextInt();
        MeRode c1 = new MeRode(valor, "Thread 1");
        MeRode c2 = new MeRode(valor, "Thread 2");
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();
    }
}
class MeRode implements Runnable {
    int limite = 0;
    String nome;

    MeRode(int a, String nome) {
        this.limite = a;
        this.nome = nome;
    }

    @Override
    public void run() {
        for (int i=0; i<= this.limite; i++) {
            System.out.println(this.nome+" "+i);
        }
    }
}