package tirt.services;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import tirt.pojos.PojoDailyScrum;


/**
 * Created by Marcin on 2015-05-25.
 */
public interface DailyScrumService {

    @GET("/dailyscrums/{id}.json")
    public PojoDailyScrum getDailyScrum (@Path("id") Long id);

    @GET("/dailyscrums/list.json")
    public void getAllDailyScrums(Callback<List<PojoDailyScrum>> callback);

    @POST("/dailyscrums/new")
    public void saveDailyScrum(@Body PojoDailyScrum pojoDailyScrum, Callback<PojoDailyScrum> callback);

}
