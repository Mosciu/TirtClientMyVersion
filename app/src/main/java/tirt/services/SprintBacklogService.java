package tirt.services;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import tirt.pojos.PojoSprintBacklog;

/**
 * Created by Marcin on 2015-05-25.
 */
public interface SprintBacklogService {
    @GET("sprintbacklogs/{id}.json")
    public PojoSprintBacklog getSprintBacklog (@Path("id") Long id);

    @POST("/sprintbacklogs/new")
    public void saveSprintBacklog(@Body PojoSprintBacklog pojoSprintBacklog, Callback<PojoSprintBacklog> callback);

    @POST("/sprintbacklogs/list")
    public List<PojoSprintBacklog> collectSprintBacklogs();
}
