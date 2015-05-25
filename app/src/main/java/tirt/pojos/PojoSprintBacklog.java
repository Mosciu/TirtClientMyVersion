package tirt.pojos;

/**
 * Created by Marcin on 2015-05-25.
 */
public class PojoSprintBacklog {

    private long id;
    private String description;
    private long sprintid;

    public long getSprintid() {
        return sprintid;
    }

    public void setSprintid(long sprintid) {
        this.sprintid = sprintid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public PojoSprintBacklog(){}


}
