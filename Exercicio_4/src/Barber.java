

public class Barber{
    private int num_chairs;
    private int num_waiting_clients = 0;
    private boolean signal = false;


    synchronized  void remove_waiting_customer(){
        this.num_waiting_clients -= 1;

    }

    synchronized  boolean isEmpty(){
        return this.num_waiting_clients==0;
    }
    synchronized boolean isFull(){
        return this.num_waiting_clients >= this.num_chairs;
    }
    private boolean is_attending_client(){
        return signal;
    }
    synchronized void setOccupied(boolean sig){
        this.signal =  sig;
    }

    void attend(){
        //Attend for 3 seconds
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        setOccupied(false);
        System.out.println("[barber]> Done, bye client");
    }

    synchronized void add_waiting_client(){
        this.num_waiting_clients+=1;

        while(is_attending_client()){
            try {
                wait();//client waiting
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("[barber]> Wait no more!");
        setOccupied(true);
        notifyAll();//With only notify() a waiting client could end up waking another waiting client. Because of the occupied flag, notifyAll will only affect the barber(consumer()).
        remove_waiting_customer();

    }

    //attend client
     public void consumer(){
        while(!is_attending_client()){
            try{
                synchronized(this) {
                    wait();//barber sleeping
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("[barber]> Come client");
        attend();
         synchronized(this) {
             notify();//Call _one_ waiting client
         }
    }

    //incoming client
    public void producer(){
        System.out.printf("(New)");
        if(!isFull()) {
            if (!is_attending_client() && isEmpty()) {
                setOccupied(true);
                synchronized(this) {
                    notify();//Because of isEmpty()'s condition it will not notify a waiting client.
                }
                System.out.println("[client]> I don't need to wait");
            } else {
                System.out.println("[client]> I'm going to wait");
                add_waiting_client();
            }
        }
        else {
            System.out.println("Very busy!");
        }
    }

    Barber(int num_chairs){
        this.num_chairs = num_chairs;
        this.num_waiting_clients = 0;
    }
}
