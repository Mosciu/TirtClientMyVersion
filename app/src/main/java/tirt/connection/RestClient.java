package tirt.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import tirt.services.DailyScrumService;
import tirt.services.SprintBacklogService;
import tirt.services.SprintReviewService;
import tirt.services.SprintService;
import tirt.services.TaskService;

/**
 * Created by Marcin on 2015-04-15.
 */
public class RestClient {
    private static final String BASE_URL = "http://tirtws-jamsz.rhcloud.com/TiRTWebService/";

    private SprintReviewService sprintReviewService;
    private TaskService taskService;
    private DailyScrumService dailyScrumService;
    private SprintBacklogService sprintBacklogService;
    private SprintService sprintService;


    public RestClient()
    {
        Gson gson = new GsonBuilder()
               // .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .setDateFormat("yyyy-MM-dd")
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        sprintReviewService = restAdapter.create(SprintReviewService.class);
        taskService = restAdapter.create(TaskService.class);
        dailyScrumService = restAdapter.create(DailyScrumService.class);
        sprintBacklogService = restAdapter.create(SprintBacklogService.class);
        sprintService = restAdapter.create(SprintService.class);
    }

    public SprintReviewService getSprintReviewService()
    {
        return sprintReviewService;
    }
    public TaskService getTaskService() { return taskService; }
    public DailyScrumService getDailyScrumService() {return dailyScrumService; }
    public SprintBacklogService getSprintBacklogService(){return sprintBacklogService; }
    public SprintService getSprintService(){return sprintService; }
}
