public class BoundedCounter {
    private int max_limit;
    private int min_limit;
    private int counter = 0;

    public boolean reached_min_bound(){
        return(this.counter <= this.min_limit);
    }

    public boolean reached_max_bound(){
        return(this.counter >= this.max_limit);
    }
    synchronized public void increment(){
        this.counter += 1;
        System.out.printf("Incremented to %d%n",this.counter);
        while(reached_max_bound()){
            System.out.println("Max limit reached. Increment operation blocked.");
            try{
                wait();
            }catch (InterruptedException e){e.printStackTrace();};
        }
        //Since increment/decrement happens one unit at time, it is guaranteed that counter have returned to the boundaries.
        notify();
    }

    synchronized public void decrement(){
        this.counter -= 1;
        System.out.printf("Decremented to %d%n",this.counter);
        while(reached_min_bound()){
            System.out.println("Min limit reached. Decrement operation blocked.");
            try{
                wait();
            }catch (InterruptedException e){e.printStackTrace();};
        }

        //Since increment/decrement happens one unit at time, it is guaranteed that counter have returned to the boundaries.
        notify();


    }


    BoundedCounter(int max_limit,int min_limit){
        this.max_limit = max_limit;
        this.min_limit = min_limit;
    }

}
