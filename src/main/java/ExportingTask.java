public class ExportingTask implements Runnable {
    private ObjectPool<Integer> pool;
    private int threadNo;
    public ExportingTask(ObjectPool<Integer> pool, int threadNo){
        this.pool = pool;
        this.threadNo = threadNo;
    }

    public void run() {
        Integer i = pool.borrowObject();
        System.out.println("Thread " + threadNo + ": Object with process no. "
                + i + " was borrowed");

        pool.returnObject(i);

        System.out.println("Thread " + threadNo +": Object with process no. "
                + i + " was returned");
    }

}