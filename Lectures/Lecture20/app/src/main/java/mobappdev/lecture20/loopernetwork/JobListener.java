package mobappdev.lecture20.loopernetwork;

/**
 * Created by Bobby on 11/18/2015.
 */
public interface JobListener<W> {
    public void someWorkCompleted(W work);

    public void jobComplete();
}
