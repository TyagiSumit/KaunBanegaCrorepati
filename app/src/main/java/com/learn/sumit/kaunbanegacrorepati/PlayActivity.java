package com.learn.sumit.kaunbanegacrorepati;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    String name,email;
    int question_count=-1,answer;
    TextView options[]=new TextView[4];
    TextView question,lose;
    TextView price[]=new TextView[12];
    Button next;
    Button quit;
    TextView name_tv;
    MediaPlayer background,next_ques,lock_dialog,wrong_answer,right_answer;
    LinearLayout optionsLayout;
    LinearLayout priceLayout;
    @Override
    public void onBackPressed() {
        AlertDialog.Builder ab= new AlertDialog.Builder(PlayActivity.this);
        ab.setTitle("You want to quit?");
        ab.setMessage("Any progress made will be lost");

        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=new Intent(PlayActivity.this,RegisterActivity.class);
                startActivity(i);
                //finish();

            }
        });
        ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ab.show();



    }

    @Override
    protected void onPause() {
        super.onPause();
        background.pause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        background.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Bundle bundle= getIntent().getExtras();
        name=bundle.getString("name");
        email=bundle.getString("email");
        setVariables();
        setQuestionInView();
        animateComponents();
        background.start();
        background.setLooping(true);
        options[0].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                final Dialog dialog= new Dialog(PlayActivity.this);
                dialog.setContentView(R.layout.custom_dialog);
                Button yes,no;
                yes=dialog.findViewById(R.id.yes);
                no=dialog.findViewById(R.id.no);
                lock_dialog.start();
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lock_dialog.stop();
                        lock_dialog=MediaPlayer.create(PlayActivity.this,R.raw.lock_dialog);
                        options[answer].setBackground(getResources().getDrawable(R.drawable.right_ques));
                        if(answer==0&&(question_count+1)<12){
                            right_answer.start();
                            price[question_count+1].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.dot_green),null,null,null);
                            question_count++;
                            won();
                            next.setEnabled(true);

                        }
                        if(answer!=0){
                            wrong_answer.start();
                            options[0].setBackground(getResources().getDrawable(R.drawable.wrong_ques));
                            youLose();

                        }
                        falseEnable();
                        dialog.dismiss();

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lock_dialog.stop();
                        lock_dialog=MediaPlayer.create(PlayActivity.this,R.raw.lock_dialog);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        options[1].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                final Dialog dialog= new Dialog(PlayActivity.this);
                dialog.setContentView(R.layout.custom_dialog);
                Button yes,no;
                yes=dialog.findViewById(R.id.yes);
                no=dialog.findViewById(R.id.no);
                lock_dialog.start();
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lock_dialog.stop();
                        lock_dialog=MediaPlayer.create(PlayActivity.this,R.raw.lock_dialog);
                        options[answer].setBackground(getResources().getDrawable(R.drawable.right_ques));
                        if(answer==1&&(question_count+1)<12){
                            right_answer.start();
                            price[question_count+1].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.dot_green),null,null,null);
                            question_count++;
                            next.setEnabled(true);
                            won();
                        }
                        if(answer!=1) {
                            wrong_answer.start();
                            options[1].setBackground(getResources().getDrawable(R.drawable.wrong_ques));
                            youLose();
                        }
                        falseEnable();
                        dialog.dismiss();

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        lock_dialog.stop();
                        lock_dialog=MediaPlayer.create(PlayActivity.this,R.raw.lock_dialog);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        options[2].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                final Dialog dialog= new Dialog(PlayActivity.this);
                dialog.setContentView(R.layout.custom_dialog);
                Button yes,no;
                yes=dialog.findViewById(R.id.yes);
                no=dialog.findViewById(R.id.no);
                lock_dialog.start();
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lock_dialog.stop();
                        lock_dialog=MediaPlayer.create(PlayActivity.this,R.raw.lock_dialog);
                        options[answer].setBackground(getResources().getDrawable(R.drawable.right_ques));
                        if(answer==2&&(question_count+1)<12){
                            right_answer.start();
                            price[question_count+1].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.dot_green),null,null,null);
                            question_count++;
                            next.setEnabled(true);
                            won();
                        }
                        if(answer!=2) {
                            wrong_answer.start();
                            options[2].setBackground(getResources().getDrawable(R.drawable.wrong_ques));
                            youLose();
                        }
                        falseEnable();
                        dialog.dismiss();

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lock_dialog.stop();
                        lock_dialog=MediaPlayer.create(PlayActivity.this,R.raw.lock_dialog);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        options[3].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                final Dialog dialog= new Dialog(PlayActivity.this);
                dialog.setContentView(R.layout.custom_dialog);
                Button yes,no;
                yes=dialog.findViewById(R.id.yes);
                no=dialog.findViewById(R.id.no);
                lock_dialog.start();
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lock_dialog.stop();
                        lock_dialog=MediaPlayer.create(PlayActivity.this,R.raw.lock_dialog);
                        options[answer].setBackground(getResources().getDrawable(R.drawable.right_ques));
                        if(answer==3&&(question_count+1)<12){
                            right_answer.start();
                            price[question_count+1].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.dot_green),null,null,null);
                            question_count++;
                            next.setEnabled(true);
                            won();
                        }
                        if(answer!=3) {
                            wrong_answer.start();
                            options[3].setBackground(getResources().getDrawable(R.drawable.wrong_ques));
                            youLose();
                        }
                        falseEnable();
                        dialog.dismiss();

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                right_answer.stop();
                right_answer=MediaPlayer.create(PlayActivity.this,R.raw.result);

                for(int i=0;i<4;i++){
                    options[i].setBackground(getResources().getDrawable(R.drawable.question));
                    options[i].setEnabled(true);
                }
                setQuestionInView();
                next.setEnabled(false);
            }
        });



    }

    void  setVariables(){

        next=findViewById(R.id.next);
        next.setEnabled(false);
        options[0]=findViewById(R.id.option_a);
        options[1]=findViewById(R.id.option_b);
        options[2]=findViewById(R.id.option_c);
        options[3]=findViewById(R.id.option_d);
        name_tv=findViewById(R.id.player_name);
        question= findViewById(R.id.question);
        name_tv.setText("Welcome "+name);
        price[0]=findViewById(R.id.p1);
        price[1]=findViewById(R.id.p2);
        price[2]=findViewById(R.id.p3);
        price[3]=findViewById(R.id.p4);
        price[4]=findViewById(R.id.p5);
        price[5]=findViewById(R.id.p6);
        price[6]=findViewById(R.id.p7);
        price[7]=findViewById(R.id.p8);
        price[8]=findViewById(R.id.p9);
        price[9]=findViewById(R.id.p10);
        price[10]=findViewById(R.id.p11);
        price[11]=findViewById(R.id.p12);
        priceLayout=findViewById(R.id.price_layout);
        optionsLayout=findViewById(R.id.options_layout);
        lose=findViewById(R.id.lose);
        lose.setVisibility(View.INVISIBLE);
        background=MediaPlayer.create(this,R.raw.suspense);
        next_ques=MediaPlayer.create(this,R.raw.next_ques);
        lock_dialog=MediaPlayer.create(this,R.raw.lock_dialog);
        wrong_answer=MediaPlayer.create(this,R.raw.wrong_answer);
        right_answer=MediaPlayer.create(this,R.raw.result);

    }

    void setQuestionInView(){
        Questions.setQuestions();
        if(question_count<11){
            question.setText(Questions.getQuestions().get(question_count+1).question);
            for (int i = 0; i < options.length; i++) {
                options[i].setText(Questions.getQuestions().get(question_count+1).options[i]);
            }
            answer=Questions.getQuestions().get(question_count+1).answer;
        }
    }
    void falseEnable(){
        for(int i=0;i<4;i++){
            options[i].setEnabled(false);
        }
    }
    void youLose(){
        background.stop();
        background=MediaPlayer.create(this,R.raw.suspense);
        if(question_count==-1){
            lose.setVisibility(View.VISIBLE);
            lose.setText("You lose, Play again?");
        }
        else {
            lose.setTextColor(getResources().getColor(android.R.color.white));
            lose.setVisibility(View.VISIBLE);
            lose.setText("Congrats You Won: "+price[question_count].getText()+" Play again?");

        }

        lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PlayActivity.this,RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    void won(){
         if(question_count==11) ;

    }
    void animateComponents(){
        int[] optionlocation=new int[2];
        optionsLayout.getLocationOnScreen(optionlocation);
        Animation animateoptions = new TranslateAnimation(optionlocation[0]-800, optionlocation[0]+0,optionlocation[1]+0, optionlocation[1]+0);
        animateoptions.setDuration(1000);
        animateoptions.setFillAfter(true);
        optionsLayout.setAnimation(animateoptions);
        int[] pricelocation=new int[2];
        priceLayout.getLocationOnScreen(pricelocation);
        Animation animateprice=new TranslateAnimation(pricelocation[0]+800,pricelocation[0]+0,pricelocation[1]+0,pricelocation[1]+0);
        animateprice.setDuration(1000);
        animateprice.setFillAfter(true);
        priceLayout.setAnimation(animateprice);
        

    }

}
