package bcgdv.com.taskapplication;

/**
 * Created by Akshay on 12/16/2015.
 */
public class Task {
    private String mTaskName;
    private boolean mTaskStatus;

    public Task(){
        mTaskName = null;
        mTaskStatus = false;
    }

    public Task(String taskName, boolean taskStatus) {
        super();
        mTaskName = taskName;
        mTaskStatus = taskStatus;
    }

    public String getTaskName() {
        return mTaskName;
    }
    public void setTaskName(String taskName) {
        mTaskName = taskName;
    }
    public boolean getStatus() {
        return mTaskStatus;
    }
    public void setStatus(boolean status) {
        mTaskStatus = status;
    }
}
