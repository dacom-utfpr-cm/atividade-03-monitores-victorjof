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

        //sleep. Use of thread for non blocking flow.
        new Thread(() ->{take_nap(mc,5); }).start();
        new Thread(() ->{take_nap(mc,2); }).start();


        //Incrementing counter to wake up
        new Thread(() ->{doCount(mc);}).start();
        new Thread(() ->{doCount(mc);}).start();


    }
    //wraper/logger for incremet()
    public static void doCount(monitorCounter mc){
        int unit;
        while(!mc.is_wakeup_time()){

            mc.increment();
            try{
                //random unit of time ([0,3] second)
                unit = (int)(Math.random()*3000);
                System.out.println("Count+1");
                Thread.sleep(unit);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    //wraper/logger for sleepUntil()
    public static void take_nap(monitorCounter mc,int units){
        System.out.printf("Sleeping up to %d%n",units);
        mc.sleep_until(units);
        System.out.printf("Counter reached %d. Time to wake up. %n",units);

    }




}
