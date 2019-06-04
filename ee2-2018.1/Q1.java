import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Vetor euzinho = new Vetor(2000);
        Thread t1 = new Thread(euzinho);
        Thread t2 = new Thread(euzinho);
        t1.start();
        t2.start();
    }
}

class Vetor implements Runnable {
    private int[] vetor;
    private int threadu;

    public Vetor(int tamanho) {
        this.vetor = new int[tamanho];
        this.threadu = 0;
    }

    public int get(int posicao) {
        synchronized (this) {
            return this.vetor[posicao];
        }
    }

    public void set(int posicao, int valor) {
        synchronized (this) {
            this.vetor[posicao] = valor;
        }
    }

    public void swap(int posicao1, int posicao2) {
        synchronized (this) {
            int valor1 = this.vetor[posicao1];
            int valor2 = this.vetor[posicao2];
            this.vetor[posicao1] = valor2;
            this.vetor[posicao2] = valor1;
        }
    }

    @Override
    public void run() {
        int aux;
        synchronized (this) {
            this.threadu = this.threadu + 1;
            aux = this.threadu;
        }
        for (int i = 0; i < this.vetor.length; i++) {
            synchronized (this) {
                this.set(i, aux);
            }
        }
        for (int i = 0; i < this.vetor.length; i++) {
            synchronized (this) {
                System.out.println("thread: " + aux + " posicao: " + i + " valor: " + this.get(i));
            }
        }
    }
}