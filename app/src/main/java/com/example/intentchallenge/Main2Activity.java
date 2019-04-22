package com.example.intentchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    EditText etname,etphone,etweb,etaddress;
    ImageView ivhappy,ivsad,ivok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etname=findViewById(R.id.etname);
        etphone=findViewById(R.id.etphone);
        etweb=findViewById(R.id.etweb);
        etaddress=findViewById(R.id.etaddress);
        ivhappy.setOnClickListener(this);
        ivsad.setOnClickListener(this);
        ivok.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent();
        if(etname.getText().toString().trim().isEmpty() || etphone.getText().toString().trim().isEmpty() || etweb.getText().toString().trim().isEmpty() ||
        etaddress.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Enter all data", Toast.LENGTH_SHORT).show();

        }else {
            intent.putExtra("name",etname.getText().toString().trim());
            intent.putExtra("phone",etphone.getText().toString().trim());
            intent.putExtra("web",etweb.getText().toString().trim());
            intent.putExtra("address",etaddress.getText().toString().trim());
            if(view.getId()== R.id.ivhappy){
                intent.putExtra("mood","happy");
            }else if(view.getId()==R.id.ivok){
                intent.putExtra("mood","ok");
            }else{
                intent.putExtra("mood","sad");
            }

        }setResult(RESULT_OK,intent);
        Main2Activity.this.finish();

    }

}
