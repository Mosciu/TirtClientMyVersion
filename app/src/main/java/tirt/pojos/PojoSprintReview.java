package tirt.pojos;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import retrofit.*;

/**
 * Created by Marcin on 2015-04-15.
 */

/*
Test POJO
 */
@Parcel
public class PojoSprintReview {

    public String review;
    public long sprintId;
    public long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSprintId() {
        return sprintId;
    }

    public void setSprintId(long sprintId) {
        this.sprintId = sprintId;
    }



    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }



    public PojoSprintReview(){};


    }
