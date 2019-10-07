/* 
Author: Victor Figueira
Date:  02/10/2019
Task: 01. Faça um programa em Java que use Threads para encontrar os números primos dentro de um intervalo.  O método que contabiliza os números primos deve possuir como entrada: valor inicial e final do intervalo, número de threads.
*/

import java.util.ArrayList;


class Counter{
    public  int count = 0;
}

//Doesn't work since there's no use of synchronization in the counter method.
public class Exercicio_01 {
    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        int n = 10000;

        ArrayList<primeThread> threads = new ArrayList<primeThread>();

        int jump = n/cores;

        int up_limit = jump;

        Counter counter = new Counter();
        for(int i = 0; i <=n-jump; i+=jump){
            threads.add(new primeThread(i, i+jump,counter));
        }

        System.out.printf("prime numbers up to %d: %n%n",n);

        for (Thread t: threads){
            t.start();
        }

        for (Thread t: threads){
            t.join();
        }

        System.out.println("interval has " + counter.count + " primes");

    }

}

