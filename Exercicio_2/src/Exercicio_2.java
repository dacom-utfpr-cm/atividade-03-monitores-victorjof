/* 
Author: Victor Figueira
Date:  02/10/2019
Task: 2. Escreva uma monitor Counter que possibilita um processo dormir até o contador alcançar um valor. A classe Counter
permite duas operações: increment() e sleepUntil(int x).
*/

public class Exercicio_2
{
    public static void main(String[] args) {
        monitorCounter mc = new monitorCounter();

        //sleep.
        new Thread(() ->{take_nap(mc,5); }).start();

        //Incrementing counter to wake up
        new Thread(() ->{control_sleep(mc);}).start();
        new Thread(() ->{control_sleep(mc);}).start();

    }

    public static void control_sleep(monitorCounter mc){
        int unit;
        while(!mc.is_wakeup_time()){
            mc.increment();
            try{
                //random unit of time ([0,3] second)
                unit = (int)(Math.random()*3000);
                System.out.printf("(warning) I may wait  %.2f seconds. %n",(float)unit/1000);
                Thread.sleep(unit);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public static void take_nap(monitorCounter mc,int units){
        System.out.printf("Sleeping up to %d warnings%n%n",units);
        mc.sleep_until(5);
        System.out.printf("%n%n%d warnings. Time to wake up. %n",units);

    }




}
