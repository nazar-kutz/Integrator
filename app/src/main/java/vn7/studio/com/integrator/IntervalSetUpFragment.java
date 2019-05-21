package vn7.studio.com.integrator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntervalSetUpFragment extends Fragment {
    private EditText etFromX, etToX;
    private double fromX, toX;

    public IntervalSetUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interval_set_up, container, false);

        //set up label
        ((TextView) view.findViewById(R.id.tvOperationLabel)).setText(getResources().getString(R.string.interval));

        etFromX = view.findViewById(R.id.etFromX);
        etToX = view.findViewById(R.id.etToX);

        // Inflate the layout for this fragment
        return view;
    }

    public double getFromX() {
        return fromX;
    }

    public double getToX() {
        return toX;
    }

    public void prepareInterval(){
        double a, b;
        a = Double.parseDouble(etFromX.getText().toString());
        b = Double.parseDouble(etToX.getText().toString());

        if (a <= b) {
            fromX = a;
            toX = b;
        } else {
            fromX = b;
            toX = a;
            etFromX.setText(String.valueOf(fromX));
            etToX.setText(String.valueOf(toX));
        }
    }
}
