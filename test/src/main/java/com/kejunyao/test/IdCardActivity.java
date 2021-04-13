package com.kejunyao.test;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年04月13日
 */
public class IdCardActivity extends AppCompatActivity {

    private AutoCompleteTextView mCompleteTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.id_card);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            list.add(String.format("ttyS%d", i));
        }

        mCompleteTextView = findViewById(R.id.select);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, list);
        mCompleteTextView.setAdapter(adapter);
        mCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCompleteTextView.showDropDown();
            }
        });

        mCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), adapter.getItem(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        findViewById(R.id.read).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), mCompleteTextView.getText().toString().trim(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
