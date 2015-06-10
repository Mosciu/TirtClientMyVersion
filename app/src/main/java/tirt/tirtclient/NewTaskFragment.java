package tirt.tirtclient;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tirt.connection.RestClient;
import tirt.pojos.PojoTask;



public class NewTaskFragment extends Fragment implements View.OnClickListener {


    private RestClient restClient;
    private PojoTask pojoTask;
    private EditText newTaskEditText;
    private Button saveNewTaskButton;


    //TO DO: przechowywanie aktualnego sprintu - ID

    public NewTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        restClient = MainActivity.PlaceholderFragment.getRestClient();
        pojoTask = new PojoTask();

        View rootView = inflater.inflate(R.layout.fragment_new_task, container, false);

        newTaskEditText = (EditText) rootView.findViewById(R.id.newTaskEditText);
        saveNewTaskButton = (Button) rootView.findViewById(R.id.newTaskSaveButton);
        saveNewTaskButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.newTaskSaveButton:
                pojoTask.setTaskDescription(newTaskEditText.getText().toString());
                pojoTask.setStatus(false);
                if (!pojoTask.getTaskDescription().equals("")) {
                    restClient.getTaskService().saveTask(pojoTask, new Callback<PojoTask>() {
                        @Override
                        public void success(PojoTask pojoTask, Response response) {
                            Toast.makeText(getActivity(), "Task saved", Toast.LENGTH_SHORT).show();
                            newTaskEditText.setText(null);
                        }

                        @Override
                        public void failure(RetrofitError error) {
                           newTaskEditText.setText(null);

                        }
                    });
                }
                break;
            default:
                break;
        }
    }

}
