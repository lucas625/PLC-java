public class Aula02 {
    public static void main(String args[]) {

        System.out.println("hello world");
        Counter c = new Counter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }

}
class Counter implements Runnable {
    private long valor;
    private boolean primeiro;

    Counter() {
        this.valor = 0;
        this.primeiro = true;
    }

    public long getValor() {
        return this.valor;
    }

    public void getAndIncrement() {
        long temp;
        synchronized(this){
            temp = this.valor;
            this.valor = temp + 1;
        }
    }

    public void makerun(int indice) {
        synchronized (this) {
            getAndIncrement();
            System.out.println("t" + indice + " valor: " + getValor());
            try {
                Thread.sleep(100);
            } catch(InterruptedException ie) {
                System.out.println("não deu para parar");
            }
        }
    }

    public void run() {
        int indice = 0;
        if (this.primeiro) {
            this.primeiro = false;
            indice = 1;
        }else {
            indice = 2;
        }
        for(int i=0;i<50;i++) {
            makerun(indice);
        }
    }
}