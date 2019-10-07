/* 
Author: Victor Figueira
Date:  02/10/2019
Task: 1. Implemente uma solução com monitor para o problema do Produtor-Consumidor usando um buffer circular.
*/
public class Exercicio_1 {
    public static void main(String[] args) {
        CircularBuffer buff = new CircularBuffer(3);
        int num_pc = 50;

        for(int i = 0; i < num_pc; i++){
            new Producer(buff).start();
        }
        //A separated start(), for a better visualization of the algorithm iteration, as there is time to fill(producer) the list first.
        for(int i = 0; i < num_pc; i++){
            new Consumer(buff).start();
        }

    }
}
