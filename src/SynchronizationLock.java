public class SynchronizationLock {
    private final Object lock = new Object();
    public void waitForCompletion() {
        synchronized(lock){
            try {
                lock.wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void notifyCompletion(){
        synchronized(lock){
            lock.notify();
        }
    }
}
