Atividades 3

0_1. Faça um programa em Java que use Threads para encontrar os números primos dentro de um intervalo.  O método que contabiliza os números primos deve possuir como entrada: valor inicial e final do intervalo, número de threads. 

0_2a. Modifique o código para garantir que será thread-safe. Implemente três versões:  Usando Atomic, sincronizando o método e sincronizando o bloco. 
Compare o desempenho medindo o tempo de início e término para processar o intervalo.

0_2b. Modifique o código para garantir que será thread-safe. Implemente três versões:  Usando Atomic, sincronizando o método e sincronizando o bloco. 
Compare o desempenho medindo o tempo de início e término para processar o intervalo.

0_2c. Modifique o código para garantir que será thread-safe. Implemente três versões:  Usando Atomic, sincronizando o método e sincronizando o bloco. 
Compare o desempenho medindo o tempo de início e término para processar o intervalo.

0_3. Implemente o problema do produtor-consumidor que ha um buffer compartilhado entre threads. Ha uma unica thread produtora e uma unica consumidora. O buffer e preenchido em tempos aleatorios pela thread produtora. Assim que for produzido algo, a thread consumidora deve ser comunicada para obter o valor

1. Implemente uma solução com monitor para o problema do Produtor-Consumidor usando um buffer circular.

2. Escreva uma monitor Counter que possibilita um processo dormir até o contador alcançar um valor. A classe Counter
permite duas operações: increment() e sleepUntil(int x).

3. Escreva um monitor BoundedCounter que possui um valor
mínimo e máximo. A classe possui dois métodos: increment()
e decrement(). Ao alcançar os limites mínimo ou máximo, a
thread que alcançou deve ser bloqueada.

4. Implemente uma solução para o problema do Barbeiro
Dorminhoco usando monitores.
