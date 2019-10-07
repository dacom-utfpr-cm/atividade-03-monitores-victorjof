public class Consumer extends Thread {
    private SharedBuffer shared_buff;
    private int value;
    public void run(){
        int until = shared_buff.getUntil();
        while(true){
            value = shared_buff.getBuffer();
            System.out.println("Consumer obtained: "+value);

            if(value == until){
                break;
            }
        }
    }

    Consumer(SharedBuffer s){
        this.shared_buff = s;
    }


}
