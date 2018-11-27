package com.example.ashwini.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class
MainActivity extends AppCompatActivity  implements View.OnClickListener , AdapterView.OnItemSelectedListener, View.OnTouchListener {

    //declaration

    EditText adharNo,passport,studentName,email,mobile;
    Button verify,cancel;
    TextView login,adhar,Passport;
    Spinner nationality;
    Toolbar tb;
    public String fullname,phone,EmailId,adharNumber,pp;
    int nation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        verify=(Button)findViewById(R.id.verify);
        cancel=(Button)findViewById(R.id.cancel);



        //listener
        verify.setOnClickListener(this);
        cancel.setOnClickListener(this);
        login.setOnTouchListener(this);

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


    }
  public void getDataFromForm()
  {


      nation=nationality.getSelectedItemPosition();
      EmailId=email.getText().toString();
      phone=mobile.getText().toString();
      adharNumber=adharNo.getText().toString();
      fullname=studentName.getText().toString();
      pp=passport.getText().toString();
  }
   @Override
   public void onClick(View v) {

        if(v==verify) {
            getDataFromForm();

            if(fullname.equals(""))
            {
                Toast.makeText(getApplicationContext(),"Enter the name",Toast.LENGTH_LONG ).show();
                studentName.requestFocus();

            }
            else if(phone.length()!=10)
            {
                Toast.makeText(getApplicationContext(),"Please Enter the correct mobile Number",Toast.LENGTH_LONG ).show();
                mobile.requestFocus();

            }
            else if (EmailId.length()==0 ||EmailId.equals("") )
            {
                Toast.makeText(getApplicationContext(),"Please Enter email ID",Toast.LENGTH_LONG ).show();
                email.requestFocus();

            }
            else if (adharNumber.length()==0)
            {
                Toast.makeText(getApplicationContext(),"Please Enter ADHAR No",Toast.LENGTH_LONG ).show();
                adharNo.requestFocus();

            }
            else if (nation==0)
            {
                Toast.makeText(getApplicationContext(),"Please Select your Nationality ",Toast.LENGTH_LONG ).show();

            }
            else if(pp.length()==0)
            {
                Toast.makeText(getApplicationContext(),"Please Enter Passport No",Toast.LENGTH_LONG ).show();

            }

else
            {
            Toast.makeText(getApplicationContext(),"OTP has been successfully send on your mobile number and emailID",Toast.LENGTH_LONG ).show();
            //Toast.makeText(getApplicationContext(),nation,Toast.LENGTH_SHORT);

            //bundle
                Bundle b=new Bundle();
                b.putString("StudName",fullname);
                b.putInt("Nation",nation);
                b.putString("EmailId",EmailId);
                b.putString("phone",phone);

                if(nationality.getSelectedItemPosition()==1) {
                    b.putString("AdharNumber", adharNumber);
                }
                else
                    b.putInt("PassNo", Integer.parseInt(pp));

                Intent in=new Intent(MainActivity.this,VerifyActivity.class);
                in.putExtras(b);
                startActivity(in);

        }
         if(v==cancel)
            {

                Intent in=new Intent(MainActivity.this,Main2Activity.class);

                startActivity(in);
            }
    }}


     @Override
     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         String country = parent.getSelectedItem().toString();
         if (country.equals("Indian"))
         {
        adharNo.setVisibility(view.VISIBLE);
        adhar.setVisibility(view.VISIBLE);
        passport.setVisibility(view.INVISIBLE);
        Passport.setVisibility(view.INVISIBLE);
         }

         else if (country.equals("Select"))
         {
             adharNo.setVisibility(view.INVISIBLE);
             adhar.setVisibility(view.INVISIBLE);
             passport.setVisibility(view.INVISIBLE);
             Passport.setVisibility(view.INVISIBLE);
         }
         else
             {
             adhar.setVisibility(view.INVISIBLE);
             adharNo.setVisibility(view.INVISIBLE);
             passport.setVisibility(view.VISIBLE);
            Passport.setVisibility(view.VISIBLE);
     }}

     @Override
     public void onNothingSelected(AdapterView<?> parent) {

     }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == login) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }       return false;

    }
}

