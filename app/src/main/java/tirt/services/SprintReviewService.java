package tirt.services;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import tirt.pojos.PojoSprintReview;
import tirt.pojos.PojoTask;

/**
 * Created by Marcin on 2015-04-15.
 */
public interface SprintReviewService {
    @GET("/sprintreviews/{id}.json")
    public PojoSprintReview getSprintReview(@Path("id") Long id);

    @POST("/sprintreviews/new")
    public void saveSprintReview(@Body PojoSprintReview sprintReview, Callback<PojoSprintReview> callback);

    @GET("/sprintreviews/list")
    public List<PojoSprintReview> collectSprintReviews();
}
