package com.example.note;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCountryActivity extends Activity implements View.OnClickListener {

    private Button addToDoBtn;
    private EditText subjectEditText;
    private EditText descEditText;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        subjectEditText=findViewById(R.id.subject_edittext);
        descEditText=findViewById(R.id.description_edittext);
        addToDoBtn=findViewById(R.id.add_record);

        dbManager=new DBManager(this);
        dbManager.open();
        addToDoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_record:
                final String name=subjectEditText.getText().toString();
                final String desc=descEditText.getText().toString();
                dbManager.insert(name,desc);
                Toast.makeText(getApplicationContext(),"Note Added..", Toast.LENGTH_SHORT).show();
                Intent main=new Intent(AddCountryActivity.this,MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
        }
    }
}