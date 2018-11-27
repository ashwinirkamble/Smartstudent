package com.example.ashwini.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashwini on 29/10/18.
 */


public class VerifyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    EditText adharNo,passport,studentName,email,mobile;
    Button create,cancel;
    TextView login,adhar,Passport;
    Spinner nationality;
    public String fullname,phone,EmailId,adharNumber;
    int nation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify);

        //find view by id
        nationality=(Spinner)findViewById(R.id.spinner);
        adharNo=(EditText)findViewById(R.id.adharno);
        studentName=(EditText)findViewById(R.id.stud_name);
        email=(EditText)findViewById(R.id.email);
        mobile=(EditText)findViewById(R.id.mobile);
        passport=(EditText)findViewById(R.id.Passport);

        //tb=(Toolbar)findViewById(R.id.toolbar);

        login=(TextView)findViewById(R.id.login);
        adhar=(TextView)findViewById(R.id.adhar);
        Passport=(TextView)findViewById(R.id.passport);

        create=(Button)findViewById(R.id.create);
        cancel=(Button)findViewById(R.id.cancel);

        //country_arraysc
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select");
        categories.add("Indian");
        categories.add("Afghan");
        categories.add("British");
        categories.add("Italian");
        //  categories.add("Personal");
        //categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        nationality.setAdapter(dataAdapter);

        nationality.setOnItemSelectedListener(this);

        /*Intent in=getIntent();
        Bundle b=in.getExtras();

        //getting data from bundle
        //fullname=b.getString("StudName");
        phone=b.getString("phone");
        EmailId=b.getString("EmailId");
       // adharNumber=b.getString("AdharNumber");
       // nation=b.getInt("Nation");

       //adharNo.setText(adharNumber);
       //mobile.setText(phone);
       email.setText(EmailId);
       studentName.setText(fullname);

       mobile.setText(nation);
       boolean national=nationality.isSelected();

        Toast.makeText(getApplicationContext(),"nationality"+national,Toast.LENGTH_LONG);
       //nationality.setSelection(nation);*/

    create.setOnClickListener(this);
    cancel.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if(v==create)
        {
            Intent in=new Intent(VerifyActivity.this,AccountSuccess.class);
            startActivity(in);
        }
        if (v==cancel)
        {
            Intent in=new Intent(VerifyActivity.this,MainActivity.class);
            startActivity(in);

        }

    }
}