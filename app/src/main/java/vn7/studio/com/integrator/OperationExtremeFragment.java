package vn7.studio.com.integrator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;

import vn7.studio.com.integrator.math.calculator.MathCalcAlgorithm;
import vn7.studio.com.integrator.math.calculator.cord.Cord2D;
import vn7.studio.com.integrator.math.calculator.cord.CordExtreme2D;
import vn7.studio.com.integrator.utillity.NumberToStringFormatter;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationExtremeFragment extends Fragment {
    private IntervalSetUpFragment frInterval;
    private AccuracySetUpFragment frAccuracy;
    private FunctionFieldFragment frFunction;
    private ResultDisplayFragment frMinDisplay, frMaxDisplay;
    private FrameLayout btnStart;

    public OperationExtremeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operation_extreme, container, false);

        FragmentManager frManager = getChildFragmentManager();
        frInterval = (IntervalSetUpFragment) frManager.findFragmentById(R.id.frIntervalSetUp);
        frAccuracy = (AccuracySetUpFragment) frManager.findFragmentById(R.id.frAccuracySetUp);
        frFunction = (FunctionFieldFragment) frManager.findFragmentById(R.id.frFunctionField);

        frMinDisplay = (ResultDisplayFragment) frManager.findFragmentById(R.id.frMinDisplay);
        frMaxDisplay = (ResultDisplayFragment) frManager.findFragmentById(R.id.frMaxDisplay);

        frMinDisplay.setTitle(getString(R.string.min));
        frMaxDisplay.setTitle(getString(R.string.max));

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

                    CordExtreme2D result = MathCalcAlgorithm.findMinMax(function, from, to, (int) pointsNumber);
                    Cord2D min = result.getMin();
                    Cord2D max = result.getMax();

                    frMinDisplay.setResult(NumberToStringFormatter.formatNDDot(min.getX(), min.getY()));
                    frMaxDisplay.setResult(NumberToStringFormatter.formatNDDot(max.getX(), max.getY()));
                } catch (RuntimeException e) {
                    Toast.makeText(getActivity(), getString(R.string.arithmetical_exception), Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }

}
