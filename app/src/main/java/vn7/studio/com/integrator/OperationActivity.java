package vn7.studio.com.integrator;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn7.studio.com.integrator.operation.IntegratorOperationType;

public class OperationActivity extends AppCompatActivity {
    public final static String OPERATION_KEY = "operation_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        String opKey = getIntent().getExtras().getString(OPERATION_KEY);

        IntegratorOperationType opType = IntegratorOperationType.valueOf(opKey);

        Fragment fragment = null;

        try {
            fragment = (Fragment) opType.getFragmentClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.operationContainer, fragment)
                .commit();
    }
}