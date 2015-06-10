package tirt.pojos;

import org.parceler.Parcel;

/**
 * Created by Arek on 16.05.15.
 */
@Parcel
public class PojoTask {

    private long id;
    private boolean status;
    private String taskDescription;


    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
