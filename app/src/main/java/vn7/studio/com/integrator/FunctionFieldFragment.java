package vn7.studio.com.integrator;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import vn7.studio.com.integrator.keyboard.FunctionPreparator;
import vn7.studio.com.integrator.operation.IntegratorOperationType;


/**
 * A simple {@link Fragment} subclass.
 */
public class FunctionFieldFragment extends Fragment {
    private TextView tvFunction;
    private FrameLayout btnEditFunction;

    public FunctionFieldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_function_field, container, false);
        ((TextView) view.findViewById(R.id.tvOperationLabel)).setText(getResources().getString(R.string.function));

        tvFunction = view.findViewById(R.id.tvFunction);
        btnEditFunction = view.findViewById(R.id.btnEditFunction);

        refreshFunctionView();

        btnEditFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = IntegratorOperationType.FUNCTION_INPUT.name();
                Intent intent = new Intent(view.getContext(), OperationActivity.class);
                intent.putExtra(OperationActivity.OPERATION_KEY, name);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshFunctionView();
    }

    private void refreshFunctionView(){
        tvFunction.setText(FunctionPreparator.getInstance().getFunction());
    }

    public String getFunction() {
        return FunctionPreparator.getInstance().getFunction();
    }
}
