package tirt.tirtclient;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import tirt.connection.RestClient;
import tirt.pojos.PojoSprint;


/**
 * A simple {@link Fragment} subclass.
 */
public class SprintPlannedFragment extends Fragment {


    private PojoSprint pojoSprint;
    private RestClient restClient;

    private TextView sprintInformations;

    public SprintPlannedFragment(){}



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sprint_planned, container, false);
        sprintInformations = (TextView) rootView.findViewById(R.id.SprintInformationTextView);
        try {
            restClient = MainActivity.PlaceholderFragment.getRestClient();
            pojoSprint = MainActivity.PlaceholderFragment.getCurrentSprintID(restClient);
            StringBuilder builder = new StringBuilder();

            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String startDate = df.format(pojoSprint.getStartDate());
            String endDate = df.format(pojoSprint.getEndDate());

            builder.append("Sprint ID: "+pojoSprint.getId()+"\nStart Date: \n"+startDate+"\nDeadline: \n"+endDate);
            sprintInformations.setText(builder.toString());
            return rootView;

        }catch(Exception ex){
            sprintInformations.setText("Błąd połączenia z internetem");
            return rootView;

        }
    }


}
