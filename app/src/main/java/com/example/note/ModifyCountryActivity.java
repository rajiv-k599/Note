package com.example.note;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class ModifyCountryActivity extends Activity implements View.OnClickListener {

    private EditText titleText;
    private Button updateBtn,deleteBtn;
    private EditText descText;

    private long _ID;
    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Record");
        setContentView(R.layout.activity_modify_country);

        dbManager=new DBManager(this);
        dbManager.open();

        titleText=findViewById(R.id.subject_edittext);
        descText=findViewById(R.id.description_edittext);
        updateBtn=findViewById(R.id.btn_update);
        deleteBtn=findViewById(R.id.btn_delete);

        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        String name=intent.getStringExtra("title");
        String desc=intent.getStringExtra("desc");

        _ID=Long.parseLong(id);
        titleText.setText(name);
        descText.setText(desc);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);



    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_update:
                String title=titleText.getText().toString();
                String desc=descText.getText().toString();
                dbManager.update(_ID,title,desc);
                Toast.makeText(getApplicationContext(),"Note Updated..", Toast.LENGTH_SHORT).show();
                this.returnHome();
                break;

            case R.id.btn_delete:
                dbManager.delete(_ID);
                Toast.makeText(getApplicationContext(),"Note Deleted..", Toast.LENGTH_SHORT).show();
                this.returnHome();
                break;
        }
    }
    public void returnHome(){
        Intent home_intent=new Intent(getApplicationContext(),MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}