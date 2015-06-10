package tirt.tirtclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tirt.connection.RestClient;
import tirt.pojos.PojoSprintBacklog;
import tirt.pojos.PojoTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class SprintBacklogFragment extends Fragment implements View.OnClickListener {


    public SprintBacklogFragment() { }

    private RestClient restClient;
    private PojoSprintBacklog pojoSprintBacklog;

    private EditText sprintBacklogEditText;
    private Button saveSprintBacklog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        restClient = MainActivity.PlaceholderFragment.getRestClient();
        pojoSprintBacklog = new PojoSprintBacklog();

        View rootView = inflater.inflate(R.layout.fragment_sprint_backlog, container, false);

        sprintBacklogEditText = (EditText) rootView.findViewById(R.id.SprintBacklogEditText);
        saveSprintBacklog = (Button) rootView.findViewById(R.id.SaveSprintBacklogButton);
        saveSprintBacklog.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.SaveSprintBacklogButton:
                pojoSprintBacklog.setDescription(sprintBacklogEditText.getText().toString());
                if(!pojoSprintBacklog.getDescription().equals("")){
                    restClient.getSprintBacklogService().saveSprintBacklog(pojoSprintBacklog,new Callback<PojoSprintBacklog>() {
                        @Override
                        public void success(PojoSprintBacklog pojoSprintBacklog, Response response) {

                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });

                }

                break;

            default:
                break;
        }

    }
}
