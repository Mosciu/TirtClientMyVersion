package tirt.pojos;

import java.util.Date;

/**
 * Created by Marcin on 2015-05-25.
 */
public class PojoDailyScrum {
    private long id;
    private String description;
    private Date date;
    private PojoSprint sprint;

    public PojoSprint getSprint() {
        return sprint;
    }

    public void setSprint(PojoSprint sprint) {
        this.sprint = sprint;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public PojoDailyScrum(){}

}
