package vn7.studio.com.integrator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import vn7.studio.com.integrator.operation.IntegratorOperationType;

public class MainActivity extends AppCompatActivity {
    private ListView centralElements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        centralElements = findViewById(R.id.centralElements);
        centralElements.setAdapter(new OperationMenuItemsAdapter(this, IntegratorOperationType.getValuesWithoutIgnored()));
        centralElements.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                IntegratorOperationType[] operations = IntegratorOperationType.getValuesWithoutIgnored();
                String name = operations[i].name();
                Intent intent = new Intent(MainActivity.this, OperationActivity.class);
                intent.putExtra(OperationActivity.OPERATION_KEY, name);
                startActivity(intent);
            }
        });
    }
}
