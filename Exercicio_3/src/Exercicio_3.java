/* 
Author: Victor Figueira
Date:  02/10/2019
Task: 3. Escreva um monitor BoundedCounter que possui um valor
mínimo e máximo. A classe possui dois métodos: increment()
e decrement(). Ao alcançar os limites mínimo ou máximo, a
thread que alcançou deve ser bloqueada.
*/
public class Exercicio_3 {
    public static void main(String[] args) {
        BoundedCounter bc = new BoundedCounter(2,-2);
        new Thread(() ->{increase(bc);}).start();
        new Thread(() ->{decrease(bc);}).start();

    }

    public static void increase(BoundedCounter bc){
        while(true){
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){e.printStackTrace();}
            bc.increment();
        }
    }

    public  static void decrease(BoundedCounter bc) {
        while (true){
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch (InterruptedException e){e.printStackTrace();}
            bc.decrement();
        }
    }

}
