package vn7.studio.com.integrator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import vn7.studio.com.integrator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccuracySetUpFragment extends Fragment {
    private int accuracy;
    private Integer[] accuracyLevels = new Integer[]{100, 200, 500, 1000, 5000, 10_000, 50_000, 100_000};

    private Spinner spAccuracy;

    public AccuracySetUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accuracy_set_up, container, false);
        ((TextView) view.findViewById(R.id.tvOperationLabel)).setText(getResources().getString(R.string.accuracy));

        spAccuracy = view.findViewById(R.id.spAccuracy);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_spinner_item, accuracyLevels);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Применяем адаптер к элементу spinner
        spAccuracy.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Integer item = (Integer) parent.getItemAtPosition(position);
                accuracy = item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spAccuracy.setOnItemSelectedListener(itemSelectedListener);

        // Inflate the layout for this fragment
        return view;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}
