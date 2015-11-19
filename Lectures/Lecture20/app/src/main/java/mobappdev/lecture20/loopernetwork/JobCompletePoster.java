package mobappdev.lecture20.loopernetwork;

/**
 * Created by Bobby on 11/18/2015.
 */
public class JobCompletePoster implements Runnable {
    private final JobListener<?> mListener;

    public JobCompletePoster(JobListener<?> listener) {
        mListener = listener;
    }

    @Override
    public void run() {
        mListener.jobComplete();
    }
}
