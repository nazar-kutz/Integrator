package vn7.studio.com.integrator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultDisplayFragment extends Fragment {
    private TextView tvResult;
    private TextView tvTitle;

    public ResultDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_display, container, false);

        tvTitle = view.findViewById(R.id.tvOperationLabel);
        setTitle(getString(R.string.result));

        tvResult = view.findViewById(R.id.tvResult);
        // Inflate the layout for this fragment
        return view;
    }

    public void setResult(String result){
        tvResult.setText(result);
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }
}
