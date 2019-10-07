public class Consumer extends Thread {
    private CircularBuffer buff;

    public void run(){
        int counter = 0;

        while(counter < (buff.getMaxSize()*5)){
            int value = buff.get();

            counter+=1;
        }
    }

    Consumer(CircularBuffer buff){
        this.buff = buff;
    }
}
