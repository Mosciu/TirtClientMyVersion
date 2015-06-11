package tirt.tirtclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;


import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tirt.connection.RestClient;
import tirt.pojos.PojoDailyScrum;
import tirt.pojos.PojoSprint;
import tirt.pojos.PojoTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class DailyScrumFragment extends Fragment implements View.OnClickListener {

    private RestClient restClient;
    private PojoDailyScrum dailyScrum;
    private List<PojoDailyScrum> allInOne;
    private TextView dateTextView;
    private EditText dailyScrumText;
    private Button saveDailyScrum;
    private long id;


    public DailyScrumFragment() {
        // Required empty public constructor
    }


    //TO DO: FUNKCJA DO SPRAWDZANIA CZY DODANO JUZ DAILY SCRUMA DO BAZY W DANYCM DNIU

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_daily_scrum, container, false);
        try {
            restClient = MainActivity.PlaceholderFragment.getRestClient();
            dailyScrum = new PojoDailyScrum();



            dailyScrumText = (EditText) rootView.findViewById(R.id.DailyScrumText);
            saveDailyScrum = (Button) rootView.findViewById(R.id.DailyScrumButton);
            saveDailyScrum.setOnClickListener(this);

            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(c.getTime());

           // List<PojoDailyScrum> dailyScrums = restClient.getDailyScrumService().collectDailyScrums();

            PojoSprint currentSprint = MainActivity.PlaceholderFragment.getCurrentSprintID(restClient);
        }catch(Exception ex){
            ex.printStackTrace();
        }


      /*  if(isToday(dailyScrums)){

        } else {

        }*/

        return rootView;
    }


    @Override
    public void onClick(View v) {
       switch(v.getId()){
            case R.id.DailyScrumButton:
                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = sdf.format(c.getTime());

                try {
                    Date date = sdf.parse(currentDate);
                    dailyScrum.setDescription(dailyScrumText.getText().toString());
                    dailyScrum.setId(26);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                /*


                try {
                    Date date = sdf.parse(currentDate);
                    dailyScrum.setDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                */
                if(!dailyScrum.getDescription().equals("")){

                    restClient.getDailyScrumService().editDailyScrum(dailyScrum,new Callback<PojoDailyScrum>() {
                        @Override
                        public void success(PojoDailyScrum pojoDailyScrum, Response response) {

                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });
                    /*
                    restClient.getDailyScrumService().saveDailyScrum(dailyScrum, new Callback<PojoDailyScrum>() {
                        @Override
                        public void success(PojoDailyScrum pojoDailyScrum, Response response) {
                            Toast.makeText(getActivity(), "Dodano daily scrum", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(getActivity(), "Error :(", Toast.LENGTH_SHORT).show();

                        }
                    });*/
                }
                break;
            default:
                break;
        }

    }


    //Deserializacja daty!!!
    public boolean isToday(List<PojoDailyScrum> dailyScrums){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = sdf.format(c.getTime());

        for(PojoDailyScrum item : dailyScrums) {
            String dailyScrumDate = sdf.format(item.getDate());
            if(dailyScrumDate.equals(currentDate)){
                return true;
            }
        }

        return false;
    }
}
