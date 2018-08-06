package com.learn.sumit.kaunbanegacrorepati;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity {
    EditText name,email;
    ImageView play;
    MediaPlayer mp;
    boolean flag=false;

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mp.start();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        mp.stop();
        mp=MediaPlayer.create(this,R.raw.register);
        AlertDialog.Builder ab= new AlertDialog.Builder(RegisterActivity.this);
        ab.setTitle("You want to quit?");
        ab.setMessage("Any progress made will be lost");

        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                //System.exit(0);

            }
        });
        ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mp.start();
            }
        });
        ab.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name= findViewById(R.id.name);
        email= findViewById(R.id.email);
        play= findViewById(R.id.play);
        mp=MediaPlayer.create(this,R.raw.register);
        mp.start();
        mp.setLooping(true);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")||email.getText().toString().equals("")||flag==false){
                    if(name.getText().toString().equals("")) name.setError("Please enter name");
                    if(email.getText().toString().equals("")) email.setError("Please Enter Email");
                    if(flag==false) email.setError("not valid email");
                }
                else {
                    mp.stop();
                    mp=MediaPlayer.create(RegisterActivity.this,R.raw.register);

                    Intent intent=new Intent(RegisterActivity.this,PlayActivity.class);
                    intent.putExtra("name",name.getText().toString());
                    intent.putExtra("email",email.getText().toString());
                    /*name.setText("");
                    email.setText("");*/
                    finish();
                    startActivity(intent);
                }

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!email.getText().toString().contains("@")||!email.getText().toString().contains(".")) {
                    email.setError("not valid email");
                    flag=false;
                }
                else {
                    flag=true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
