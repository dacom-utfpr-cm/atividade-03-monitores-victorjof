public class monitorCounter {
    private int count = 0;
    private int until_units;

    synchronized boolean is_wakeup_time(){
        //in case there`s not enough time to increase until_units, before the start of a wake up thread
        if(until_units==0){
            return false;
        }
        else{
            return (this.count == until_units);
        }

    }

    synchronized public void increment(){
        this.count+=1;
        if(is_wakeup_time()){
            notify();
        }


    }

    synchronized  public void sleep_until(int units){
        this.until_units = units;
        while(!is_wakeup_time()){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }

}
