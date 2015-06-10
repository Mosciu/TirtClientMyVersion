package tirt.tirtclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tirt.connection.RestClient;
import tirt.pojos.PojoSprint;


/**
 * A simple {@link Fragment} subclass.
 */
public class SprintPlanningFragment extends Fragment {


    public SprintPlanningFragment() { }
    private Fragment fragment;
    private RestClient restClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_sprint_planning, container, false);
        try {
            restClient = MainActivity.PlaceholderFragment.getRestClient();

            PojoSprint currentSprint = MainActivity.PlaceholderFragment.getCurrentSprintID(restClient);

            Fragment fragment = null;
            FragmentManager fragmentManager = getFragmentManager();
            if (currentSprint != null) {
                fragment = new SprintPlannedFragment();

            } else {
                fragment = new NewSprintPlanning();

            }

            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();

        } catch (Exception ex) {
            return rootView;
        }
        return rootView;


    }
    }



