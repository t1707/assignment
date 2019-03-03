import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;

public abstract class ObjectPool<T> {  

    private ConcurrentLinkedQueue<T> pool;

    private ScheduledExecutorService executorService;

    public ObjectPool(final int numObjects) {
        // initialize pool  
        initialize(numObjects);
    }

    public T borrowObject() {
        T object;
        if ((object = pool.poll()) == null)
        {
            object = createObject();
        }
        return object;
    }

    public void returnObject(T object) {
        if (object == null) {
            return;
        }
        this.pool.offer(object);
    }

    protected abstract T createObject();

    private void initialize(final int numObjects)  {
        pool = new ConcurrentLinkedQueue<T>();
        for (int i = 0; i < numObjects; i++) {
            pool.add(createObject());
        }
    }
}