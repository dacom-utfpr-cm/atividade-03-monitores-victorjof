public class Producer extends Thread {
    private SharedBuffer shared_buff;

    public void run(){
        int until = shared_buff.getUntil();
        for (int i = 0; i <= until; i++){
            try{
                //Produces values at random time([0,5] seconds)
                Thread.sleep((int)(Math.random()*5000));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            shared_buff.setBuffer(i);
            System.out.println("Producer generated: "+i);
        }
    }

    Producer(SharedBuffer s){
        this.shared_buff = s;
    }


}
