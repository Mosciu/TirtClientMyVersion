package tirt.tirtclient;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tirt.connection.RestClient;
import tirt.pojos.PojoTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends Fragment {

    private RestClient restClient;
    private TextView taskListText;

    public TaskListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_task_list, container, false);

        taskListText = (TextView) rootView.findViewById(R.id.taskListText);

        restClient = MainActivity.PlaceholderFragment.getRestClient();

        try {
            List<PojoTask> tasks = restClient.getTaskService().collectTasks();

            StringBuilder builder = new StringBuilder();
            for(PojoTask task : tasks){
                builder.append("Description: "+task.getTaskDescription() + " Status: "+task.isStatus()+"\n");
            }

            taskListText.setText(builder.toString());

        }catch(Exception ex){
            taskListText.setText("Błąd połączenia z internetem!");
        }


        return rootView;
    }



}
