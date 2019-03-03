import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestQue03{
    private ObjectPool<Integer> pool;
    private AtomicInteger processNo=new AtomicInteger(0);
    public void setUp() {

        pool = new ObjectPool<Integer>(4)
        {
            protected Integer createObject()
            {
                // create a test object which takes some time for creation
                return new Integer(processNo.incrementAndGet());
            }
        };
    }

    public void testObjectPool() {
        ExecutorService executor = Executors.newFixedThreadPool(4);


        executor.execute(new ExportingTask(pool, 1));
        executor.execute(new ExportingTask(pool, 2));
        executor.execute(new ExportingTask(pool, 3));
        executor.execute(new ExportingTask(pool, 4));


    }
    public static void main(String args[])  {
        TestQue03 test=new TestQue03();
        test.setUp();
        test.testObjectPool();
    }
}