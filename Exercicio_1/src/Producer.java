public class Producer extends Thread {
    private CircularBuffer buff;

    public void run(){
        int counter = 0;

        while(counter < (buff.getMaxSize()*5)) {

            int value = (int)(Math.random()*10+1);
            buff.add(value);
            counter+=1;
            try{
                Thread.sleep((int)(Math.random()*100));
            }catch (InterruptedException e) {
                e.getStackTrace();
            }

        }
    }

    Producer(CircularBuffer buff){
        this.buff = buff;
    }
}
