package mobappdev.lecture20.loopernetwork;

/**
 * Created by Bobby on 11/18/2015.
 *
 * A Runnable capable of sending a work progress update to a JobListener.
 */
public class WorkPoster<W> implements Runnable {
    private final W mWork;
    private final JobListener<W> mListener;

    public WorkPoster(W work, JobListener<W> listener) {
        mWork = work;
        mListener = listener;
    }

    @Override
    public void run() {
        mListener.someWorkCompleted(mWork);
    }
}
