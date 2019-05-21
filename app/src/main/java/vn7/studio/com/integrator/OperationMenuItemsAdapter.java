package vn7.studio.com.integrator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import vn7.studio.com.integrator.operation.IntegratorOperationType;

public class OperationMenuItemsAdapter extends ArrayAdapter<IntegratorOperationType> {
    private final Context context;
    private final IntegratorOperationType[] values;

    public OperationMenuItemsAdapter(Context context, IntegratorOperationType[] values) {
        super(context, R.layout.operation_item, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.operation_item, parent, false);
        TextView tvOperationType = view.findViewById(R.id.tvOperationType);
        TextView tvOperationDescription = view.findViewById(R.id.tvOperationDescription);
        tvOperationType.setText(values[position].getName());
        tvOperationDescription.setText(values[position].getName());
        return view;

    }

    @Override
    public int getCount() {
        return values.length;
    }
}
