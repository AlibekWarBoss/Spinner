package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] autoBr = {"Toyota Camry","Mercedes Benz", "Subaru"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> autoBrAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, autoBr);

        autoBrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spAuto = (Spinner) findViewById(R.id.spAuto);

        spAuto.setAdapter(autoBrAdapter);

        spAuto.setPrompt("Top popularity car in The Repulic of Qazaqstan");

        spAuto.setOnItemSelectedListener(onItemSelectedListener());
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener(){
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                Toast.makeText(getBaseContext(),parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

}