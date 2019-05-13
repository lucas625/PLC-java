public class Aula02 {
    public static void main(String args[]) {
        System.out.println("hello world");
    }

}
public class Counter {
    private long valor;

    Counter() {
        this.valor = 0;
    }

    public long getAndIncrement() {
        long temp;
        synchronized(this){
            temp = this.valor;
            this.valor = temp + 1;
        }
        return temp;
    }
}