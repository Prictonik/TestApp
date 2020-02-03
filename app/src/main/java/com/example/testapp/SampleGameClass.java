package com.example.testapp;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SampleGameClass extends AppCompatActivity{

    private int width = 9, helth = 9;  // Размеры игрового поля

    LinearLayout linearLayout;
    TableLayout tableLayout;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_game_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tableLayout =  findViewById(R.id.table);
        linearLayout = findViewById(R.id.linearlayout);

        int kid = 0;

        View.OnClickListener onClickListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton imageButton = (ImageButton) v;
                imageButton.setImageResource(R.drawable.scorpion);
                AlertDialog.Builder builder = new AlertDialog.Builder(SampleGameClass.this);
                    builder.setTitle("Вы проиграли!").setMessage("Еще разок?").setIcon(R.drawable.white).setCancelable(false).setNegativeButton("Ок, го", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            finish();
                            onRestart();
                        }
                    });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        };

        View.OnClickListener onClickListener = new View.OnClickListener() {

            int start_point=76;

            @Override
            public void onClick(View v) {
                int k = v.getId();
                Toast toast = Toast.makeText(getApplicationContext(), "Нажата кнопка", Toast.LENGTH_SHORT);
                toast.show();


                if( k==(start_point-9) || k==(start_point-1) || k==(start_point+1) || k==(start_point+9))
                    {
                        if( k==4 ){
                            AlertDialog.Builder builder = new AlertDialog.Builder(SampleGameClass.this);
                            builder.setTitle("Вы победили!").setMessage("Еще разок?").setIcon(R.drawable.white).setCancelable(false).setNegativeButton("Ок, го", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    finish();
                                    onRestart();
                                }
                            });

                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }

                        if( k==(start_point-9)) start_point-=9;
                        if( k==(start_point-1)) start_point-=1;
                        if( k==(start_point+1)) start_point+=1;
                        if( k==(start_point+9)) start_point+=9;

                        ImageButton imageButton = (ImageButton) v;
                        imageButton.setImageResource(R.drawable.monkey);
                    } else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Вы не можете сюда пойти", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        };

        for( int i=0; i<helth; i++)
        {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            for( int j=0; j<width; j++)
            {
                ImageButton imageView = new ImageButton(this);
                if( kid == 4)
                {
                    imageView.setImageResource(R.drawable.gold);
                } else if( kid == 76)
                        {
                              imageView.setImageResource(R.drawable.monkey);
                        } else imageView.setImageResource(R.drawable.question);

                imageView.setId(kid);
                if ( i%3!=0 && j%3!=0) {
                    imageView.setOnClickListener(onClickListener2);
                } else imageView.setOnClickListener(onClickListener);

                ++kid;
                tableRow.addView(imageView);
            }

            tableLayout.addView(tableRow);
        }
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

}
