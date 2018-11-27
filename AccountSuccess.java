package com.example.ashwini.student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ashwini on 19/11/18.
 */

public class AccountSuccess extends Activity implements View.OnClickListener {
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_success);

        login=(TextView)findViewById(R.id.login);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==login)
        {
            Intent in=new Intent(AccountSuccess.this,LoginActivity.class);
            startActivity(in);
        }
    }
}
