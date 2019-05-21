package vn7.studio.com.integrator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import vn7.studio.com.integrator.exception.FillFieldException;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputPointFragment extends Fragment {
    private EditText etValueX;
    private double x;

    public InputPointFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_point, container, false);
        ((TextView) view.findViewById(R.id.tvOperationLabel)).setText(getResources().getString(R.string.for_x));

        etValueX = view.findViewById(R.id.etValueX);

        return view;
    }

    public Double getX() {
        String number = etValueX.getText().toString();
        if (number.equals("")) {
            throw new FillFieldException(etValueX.getId());
        }
        x = Double.parseDouble(etValueX.getText().toString());
        return x;
    }
}
