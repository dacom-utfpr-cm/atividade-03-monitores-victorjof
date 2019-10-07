public class SharedBuffer {
    private int buff = -1;
    private boolean canProduce = true;
    private int until = 1;

    //producer
    synchronized void setBuffer(int value) {
        while (!canProduce) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        canProduce = false;
        this.buff = value;
        //warns waiting consumer
        notify();
    }
    //consumer
    synchronized int getBuffer() {
        while (canProduce) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        canProduce = true;
        //warns waiting producer
        notify();
        return this.buff;

    }

    public void setUntil(int value){
        this.until = value;
    }

    public int getUntil(){
        return  this.until;
    }



    SharedBuffer(int until){
        setUntil(until);
    }
}


