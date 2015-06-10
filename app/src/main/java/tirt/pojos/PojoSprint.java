package tirt.pojos;

import java.util.Date;

/**
 * Created by Marcin on 2015-06-09.
 */
public class PojoSprint {

    public PojoSprint(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private Long id;
    private Date startDate;
    private Date endDate;
    private boolean status;

}
