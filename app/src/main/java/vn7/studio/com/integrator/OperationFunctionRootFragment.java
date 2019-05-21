package vn7.studio.com.integrator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import vn7.studio.com.integrator.math.calculator.MathCalcAlgorithm;
import vn7.studio.com.integrator.utillity.NumberToStringFormatter;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationFunctionRootFragment extends Fragment {
    private IntervalSetUpFragment frInterval;
    private AccuracySetUpFragment frAccuracy;
    private FunctionFieldFragment frFunction;
    private ResultDisplayFragment frResultDisplay;
    private FrameLayout btnStart;

    public OperationFunctionRootFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operation_function_root_vertical, container, false);

        FragmentManager frManager = getChildFragmentManager();
        frInterval = (IntervalSetUpFragment) frManager.findFragmentById(R.id.frIntervalSetUp);
        frAccuracy = (AccuracySetUpFragment) frManager.findFragmentById(R.id.frAccuracySetUp);
        frFunction = (FunctionFieldFragment) frManager.findFragmentById(R.id.frFunctionField);

        frResultDisplay = (ResultDisplayFragment) frManager.findFragmentById(R.id.frResultDisplay);

        btnStart = view.findViewById(R.id.btnStartOperation);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    frInterval.prepareInterval();
                    double from = frInterval.getFromX();
                    double to = frInterval.getToX();
                    double pointsNumber = frAccuracy.getAccuracy();
                    String function = frFunction.getFunction();

                    double result = MathCalcAlgorithm.findFunctionRootOnRangeDichotomy(function, from, to, (int) pointsNumber);

                    frResultDisplay.setResult(NumberToStringFormatter.formatNumber(result));
                } catch (RuntimeException e) {
                    Toast.makeText(getActivity(), getString(R.string.arithmetical_exception), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
