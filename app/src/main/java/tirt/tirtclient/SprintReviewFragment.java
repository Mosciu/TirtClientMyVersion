package tirt.tirtclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tirt.pojos.PojoSprintReview;
import tirt.connection.RestClient;
import tirt.pojos.PojoTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class SprintReviewFragment extends Fragment implements View.OnClickListener {

    private RestClient restClient;
    private PojoSprintReview sprintReview;
    private Fragment fragment;

    private EditText sprintReviewEditText;

    private Button saveSprintReview;

    public SprintReviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        restClient = MainActivity.PlaceholderFragment.getRestClient();
        sprintReview = new PojoSprintReview();

        View rootView = inflater.inflate(R.layout.fragment_sprint_review, container, false);

        sprintReviewEditText = (EditText) rootView.findViewById(R.id.sprintReviewEditText);
        saveSprintReview = (Button) rootView.findViewById(R.id.saveSprintReviewButton);
        saveSprintReview.setOnClickListener(this);
        return rootView;

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.saveSprintReviewButton:
                sprintReview.setReview(sprintReviewEditText.getText().toString());
                //sprintReview.setSprintId(Long.parseLong("1"));
                if (!sprintReview.getReview().equals("")) {
                restClient.getSprintReviewService().saveSprintReview(sprintReview,new Callback<PojoSprintReview>() {
                    @Override
                    public void success(PojoSprintReview pojoSprintReview, Response response) {
                        //Toast.makeText(getActivity(), "Sprint Review saved!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                });
                }
                break;
            default:
                break;
        }

    }

}
