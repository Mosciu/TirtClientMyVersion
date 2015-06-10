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

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        restClient = MainActivity.PlaceholderFragment.getRestClient();
        dailyScrum = new PojoDailyScrum();

        View rootView = inflater.inflate(R.layout.fragment_daily_scrum, container, false);

        dailyScrumText = (EditText) rootView.findViewById(R.id.DailyScrumText);
        saveDailyScrum = (Button) rootView.findViewById(R.id.DailyScrumButton);
        saveDailyScrum.setOnClickListener(this);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        return rootView;
    }


    @Override
    public void onClick(View v) {
       switch(v.getId()){
            case R.id.DailyScrumButton:

                dailyScrum.setDescription(dailyScrumText.getText().toString());

                if(!dailyScrum.getDescription().equals("")){
                    restClient.getDailyScrumService().saveDailyScrum(dailyScrum, new Callback<PojoDailyScrum>() {
                        @Override
                        public void success(PojoDailyScrum pojoDailyScrum, Response response) {
                            Toast.makeText(getActivity(), "Dodano daily scrum", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(getActivity(), "Error :(", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
                break;
            default:
                break;
        }

    }
}
