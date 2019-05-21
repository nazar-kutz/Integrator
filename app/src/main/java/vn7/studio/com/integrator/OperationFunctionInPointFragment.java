package vn7.studio.com.integrator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import vn7.studio.com.integrator.math.calculator.MathCalcAlgorithm;
import vn7.studio.com.integrator.utillity.NumberToStringFormatter;

public class OperationFunctionInPointFragment extends Fragment {
    private FunctionFieldFragment frFunction;
    private InputPointFragment frArgument;
    private ResultDisplayFragment frResultDisplay;
    private FrameLayout btnStart;

    public OperationFunctionInPointFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operation_function_in_point_vertical, container, false);

        FragmentManager frManager = getChildFragmentManager();
        frFunction = (FunctionFieldFragment) frManager.findFragmentById(R.id.frFunctionField);
        frArgument = (InputPointFragment) frManager.findFragmentById(R.id.frArgumentSetUp);
        frResultDisplay = (ResultDisplayFragment) frManager.findFragmentById(R.id.frResultDisplay);

        btnStart = view.findViewById(R.id.btnStartOperation);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String function = frFunction.getFunction();
                    Number nArgument = frArgument.getX();
                    double x = (double) nArgument;
                    double result = MathCalcAlgorithm.findFunctionForArgument(function, x);
                    frResultDisplay.setResult(NumberToStringFormatter.formatNumber(result));
                } catch (RuntimeException e) {
                    Toast.makeText(getActivity(), getString(R.string.arithmetical_exception), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
