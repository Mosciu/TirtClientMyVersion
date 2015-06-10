package tirt.services;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import tirt.pojos.PojoSprint;

/**
 * Created by Marcin on 2015-06-09.
 */
public interface SprintService {

    @GET("/sprints/{id}.json")
    public PojoSprint getSprint(@Path("id") Long id);

    @POST("/sprints/new")
    public void saveSprint(@Body PojoSprint pojoSprint, Callback<PojoSprint> callback);

    @GET("/sprints/list")
    public List<PojoSprint> collectSprints();
}
