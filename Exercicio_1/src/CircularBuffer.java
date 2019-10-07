import java.util.Arrays;

//Based on the description from https://en.wikipedia.org/wiki/Circular_buffer
/*

buffer start in memory -> 0
buffer end in memory, or buffer capacity -> size
start of valid data (index) -> starts 0
end of valid data (index) ->  starts 0

 */
public class CircularBuffer {

    private int begin;
    private int max_size;
    private int last;
    private int actual_size;


    private int[] buff_list;



     synchronized int getMaxSize(){
        return this.max_size;
    }
     synchronized boolean isFull(){
        return(actual_size==max_size);
    }

     synchronized boolean isEmpty(){
            return(actual_size==0);
    }

    //'fill' value
    synchronized void add(int value) {
        while(isFull()){
           try{
               wait();
           }catch (InterruptedException e){
                e.getStackTrace();
           }
        }

        buff_list[this.last] = value;
        this.actual_size+=1;
        //update last -> increment +1 then moves in a circle
        this.last = (this.last + 1) % this.max_size;
        notifyAll();
        System.out.printf("add %d%n",value);
        System.out.println(Arrays.toString(this.buff_list));


    }
    //extract head
    synchronized int get() {

        while(isEmpty()){
            try{
                wait();
            }catch(InterruptedException e){}

        }
        int value = this.buff_list[this.begin];



        //update begin after head extraction -> increment then moves in a circle
        this.begin= (this.begin + 1) % this.max_size;
        this.actual_size-=1;
        notifyAll();
        System.out.printf("get %d%n",value);
        return (value);

    }

    CircularBuffer(int size){
        this.begin = 0;
        this.max_size = size;
        this.actual_size = 0;
        this.last = 0;
        this.buff_list = new int[size];
    }

}
