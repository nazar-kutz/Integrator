package vn7.studio.com.integrator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationInputCalculatorFragment extends OperationInputFunctionFragment {


    public OperationInputCalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        currentMode = CALCULATOR_MODE;
        View view = super.onCreateView(inflater, container, savedInstanceState);

        return view;
    }

}
