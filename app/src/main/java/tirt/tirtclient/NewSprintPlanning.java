package tirt.tirtclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class NewSprintPlanning extends Fragment implements View.OnClickListener {

    private Button saveSprintPlanning;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    private PojoSprint sprint;
    private RestClient restClient;


    public NewSprintPlanning() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_new_sprint_planning, container, false);

        restClient = MainActivity.PlaceholderFragment.getRestClient();

        sprint = new PojoSprint();


        saveSprintPlanning = (Button) rootView.findViewById(R.id.sprintPlanningSaveButton);
        saveSprintPlanning.setOnClickListener(this);
        startDatePicker = (DatePicker) rootView.findViewById(R.id.startDatePicker);
        endDatePicker = (DatePicker) rootView.findViewById(R.id.endDatePicker);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sprintPlanningSaveButton:

                try{
                    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

                    int startMonth = startDatePicker.getMonth() + 1;
                    String startDateString = startDatePicker.getDayOfMonth() + "-"+startMonth+"-"+startDatePicker.getYear();
                    Date startDate = formatter.parse(startDateString);

                    int endMonth = endDatePicker.getMonth() + 1;
                    String endDateString = endDatePicker.getDayOfMonth() + "-"+endMonth+"-"+endDatePicker.getYear();
                    Date endDate = formatter.parse(endDateString);



                    if(startDate.after(endDate)){
                        Toast.makeText(getActivity(), "Błędny zakres dat!", Toast.LENGTH_LONG).show();
                        break;

                    }
                    else {
                        sprint.setStartDate(startDate);
                        sprint.setEndDate(endDate);
                        sprint.setStatus(false);

                        restClient.getSprintService().saveSprint(sprint,new Callback<PojoSprint>() {
                            @Override
                            public void success(PojoSprint pojoSprint, Response response) {

                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
                    }

                }catch(Exception ex){
                    Toast.makeText(getActivity(), "Błąd", Toast.LENGTH_SHORT).show();

                }

                break;

        }
    }
}
