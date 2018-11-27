package com.example.ashwini.student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashwini on 25/9/18.
 */

public class LoginActivity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener, View.OnTouchListener {
    Spinner spinner;
    EditText mobile,email,adhar,passport,password;
    TextView tv_mobile,tv_email,tv_adhar,tv_passport,forget_pass,create_acc;
    Button login,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        //find by Id
        spinner=(Spinner)findViewById(R.id.sp2);

        mobile=(EditText)findViewById(R.id.mobile);
        email=(EditText)findViewById(R.id.et_email);
        adhar=(EditText)findViewById(R.id.et_adhar_no);
        passport=(EditText)findViewById(R.id.et_passport_no);
        password=(EditText)findViewById(R.id.password);

        tv_mobile=(TextView)findViewById(R.id.mobile_no);
        tv_email=(TextView)findViewById(R.id.email);
        tv_adhar=(TextView)findViewById(R.id.adhar_no);
        tv_passport=(TextView)findViewById(R.id.tv_passport_no);
        forget_pass=(TextView)findViewById(R.id.tv_forget_pass);
        create_acc=(TextView)findViewById(R.id.tv_create_acc);

        login=(Button)findViewById(R.id.bt_login);
        cancel=(Button)findViewById(R.id.bt_cancel);

        login.setOnClickListener(this);
        cancel.setOnClickListener(this);

        forget_pass.setOnTouchListener(this);
        create_acc.setOnTouchListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("--Select--");
        categories.add("Mobile Number");
        categories.add("Email ID");
        categories.add("Adhar Number");
        categories.add("Passport Number");
        //  categories.add("Personal");
        //categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getSelectedItemPosition()==0)
        {
            mobile.setVisibility(view.INVISIBLE);
            tv_mobile.setVisibility(view.INVISIBLE);
        }
        if (parent.getSelectedItemPosition()==1)
        {
            mobile.setVisibility(view.VISIBLE);
            tv_mobile.setVisibility(view.VISIBLE);

            email.setVisibility(view.INVISIBLE);
            tv_email.setVisibility(view.INVISIBLE);
            adhar.setVisibility(view.INVISIBLE);
            tv_adhar.setVisibility(view.INVISIBLE);
            tv_passport.setVisibility(view.INVISIBLE);
            passport.setVisibility(view.INVISIBLE);

        }
        if (parent.getSelectedItemPosition()==2)
        {
            email.setVisibility(view.VISIBLE);
            tv_email.setVisibility(view.VISIBLE);

            tv_mobile.setVisibility(view.INVISIBLE);
            mobile.setVisibility(view.INVISIBLE);
            adhar.setVisibility(view.INVISIBLE);
            tv_adhar.setVisibility(view.INVISIBLE);
            tv_passport.setVisibility(view.INVISIBLE);
            passport.setVisibility(view.INVISIBLE);

        }
        if(parent.getSelectedItemPosition()==3)
        {
        adhar.setVisibility(view.VISIBLE);
        tv_adhar.setVisibility(view.VISIBLE);

        email.setVisibility(view.INVISIBLE);
        tv_email.setVisibility(view.INVISIBLE);
        mobile.setVisibility(view.INVISIBLE);
        tv_mobile.setVisibility(view.INVISIBLE);
            passport.setVisibility(view.INVISIBLE);
            tv_passport.setVisibility(view.INVISIBLE);
        }
        if (parent.getSelectedItemPosition()==4)
        {
            passport.setVisibility(view.VISIBLE);
            tv_passport.setVisibility(view.VISIBLE);

            adhar.setVisibility(view.INVISIBLE);
            email.setVisibility(view.INVISIBLE);
            mobile.setVisibility(view.INVISIBLE);
            tv_mobile.setVisibility(view.INVISIBLE);
            tv_email.setVisibility(view.INVISIBLE);
            tv_adhar.setVisibility(view.INVISIBLE);




        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if(v==login)
        {
            Intent in=new Intent(LoginActivity.this,AfterLogin.class);
            startActivity(in);

        }
       if (v==cancel)
       {
           Intent in=new Intent(LoginActivity.this,Main2Activity.class);
           startActivity(in);

       }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v==forget_pass)
        {
        Intent in= new Intent(LoginActivity.this,ForgetPassword.class);
        startActivity(in);
        }
        if(v==create_acc)
        {
            Intent in=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(in);
        }
        return false;
    }
}
