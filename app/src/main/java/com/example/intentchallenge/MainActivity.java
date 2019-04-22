package com.example.intentchallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView ivmood,ivphone,ivweb,ivmap;
Button btn1;
final int code=3;
String name="",phone="",url="",address="",mood="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivmood=findViewById(R.id.ivmood);
        ivphone=findViewById(R.id.ivphone);
        ivweb=findViewById(R.id.ivweb);
        ivmap=findViewById(R.id.ivmap);
btn1=findViewById(R.id.btn1);
ivmood.setVisibility(View.GONE);
        ivphone.setVisibility(View.GONE);
        ivweb.setVisibility(View.GONE);
        ivmap.setVisibility(View.GONE);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, com.example.intentchallenge.Main2Activity.class);
                startActivityForResult(intent,code);

            }
        });
        ivphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });
        ivweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+url));
                startActivity(intent);
            }
        });
                ivmap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+address));
                        startActivity(intent);

                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==code){
            if(resultCode==RESULT_OK){
                ivmood.setVisibility(View.VISIBLE);
                ivphone.setVisibility(View.VISIBLE);
                ivweb.setVisibility(View.VISIBLE);
                ivmap.setVisibility(View.VISIBLE);
               name = data.getStringExtra("name");
               phone= data.getStringExtra("phone");
               url= data.getStringExtra("web");
               address=data.getStringExtra("address");
              mood=data.getStringExtra("mood");
              if(mood.equals("happy")){
                  ivmood.setImageResource(R.drawable.happy);
              }else if(mood.equals("ok")){
                  ivmood.setImageResource(R.drawable.ok);
              }else {
                  ivmood.setImageResource(R.drawable.sad);
              }

            }
        }
    }
}
