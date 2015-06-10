package tirt.services;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import tirt.pojos.PojoTask;

/**
 * Created by Arek on 16.05.15.
 */
public interface TaskService {

    @GET("tasks/{id}.json")
    public PojoTask getTask(@Path("id") Long id);

    @POST("/tasks/new")
    public void saveTask(@Body PojoTask pojoTask, Callback<PojoTask> callback);

    @GET("/tasks/list")
    public List<PojoTask> collectTasks();
}
