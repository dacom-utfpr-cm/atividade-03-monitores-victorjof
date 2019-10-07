/* 
Author: Victor Figueira
Date:  02/10/2019
Task: 4. Implemente uma solução para o problema do Barbeiro
Dorminhoco usando monitores.
*/
public class Exercicio_4 {
    public static void main(String[] args) {
        Barber barber = new Barber(2);

        new Thread( () -> {receiving_clients(barber);}).start();
        new_clients(barber);
    }


    //attend new clients
    public static void receiving_clients(Barber barber){
        while(true){
            barber.consumer();
        }
    }
    //generates new clients
    public static void new_clients(Barber barber){
        //barber servers  1 client every 3 seconds.
        for(int i =0; i<5;i++){
            try {
                //new client every second, there's 2 waiting chairs.
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            new Thread(() -> {barber.producer();}).start();
        }

    }

}
