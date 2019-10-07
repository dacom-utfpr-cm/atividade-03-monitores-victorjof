/* 
Author: Victor Figueira
Date:  02/10/2019
Task: 03. Implemente o problema do produtor-consumidor que ha um buffer compartilhado entre threads. Ha uma unica thread produtora e uma unica consumidora. O buffer e preenchido em tempos aleatorios pela thread produtora. Assim que for produzido algo, a thread consumidora deve ser comunicada para obter o valor
*/
class Exercicio_03{
    public static void main(String[] args) {
        SharedBuffer shared_buff = new SharedBuffer(10);
        new Producer(shared_buff).start();
        new Consumer(shared_buff).start();


    }
}