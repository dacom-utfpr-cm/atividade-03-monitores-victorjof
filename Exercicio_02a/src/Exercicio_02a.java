/* 
Author: Victor Figueira
Date:  02/10/2019
Task: 02. Modifique o código para garantir que será thread-safe. Implemente três versões:  Usando Atomic, sincronizando o método e sincronizando o bloco. Compare o desempenho medindo o tempo de início e término para processar o intervalo.
*/



import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


class Counter{
      AtomicInteger count = new AtomicInteger(0);
}


public class Exercicio_02a {
    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        int n = 10_000_000;

        ArrayList<primeThread> threads = new ArrayList<primeThread>();

        int jump = n/cores;

        int up_limit = jump;

        Counter counter = new Counter();
        for(int i = 0; i <=n-jump; i+=jump){
            threads.add(new primeThread(i, i+jump,counter));
        }

        System.out.printf("prime numbers up to %d: %n%n",n);

        long startTime = System.currentTimeMillis();

        for (Thread t: threads){
            t.start();
        }

        for (Thread t: threads){
            t.join();
        }

        long t_estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("interval has " + counter.count + " primes");
        System.out.printf("Estimated time of %.3f", (float)t_estimatedTime/1000);
    }

}

