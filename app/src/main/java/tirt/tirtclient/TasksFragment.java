package tirt.tirtclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tirt.connection.RestClient;
import tirt.pojos.PojoDailyScrum;
import tirt.pojos.PojoTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class TasksFragment extends Fragment implements View.OnClickListener
{


    private Button newTaskButton;
    private Button taskListButton;


    public TasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_tasks, container, false);

        newTaskButton = (Button) rootView.findViewById(R.id.newTaskButton);
        taskListButton = (Button) rootView.findViewById(R.id.listTaskButton);

        newTaskButton.setOnClickListener(this);
        taskListButton.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        FragmentManager fragmentManager = getFragmentManager();
        switch(v.getId()){
            case R.id.newTaskButton:
                fragment = new NewTaskFragment();
                break;
            case R.id.listTaskButton:
                fragment = new TaskListFragment();
                break;
            default:
                break;

        }
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

    }
}
