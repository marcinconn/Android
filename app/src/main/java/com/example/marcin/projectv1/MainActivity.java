package com.example.marcin.projectv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent ;
        switch(view.getId()){
            case R.id.button3:
                intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(MainActivity.this,Find.class);
                startActivity(intent);
                break;
            case R.id.button6:
                Find.sAll=true;
                intent = new Intent(MainActivity.this,Result.class);
                startActivity(intent);
                break;
            case R.id.button7:
                AskForId.change=true;
                AskForId.delSpecific=false;
                intent = new Intent(MainActivity.this,AskForId.class);
                startActivity(intent);
                break;
            case R.id.button8:
                AskForId.change=false;
                AskForId.delSpecific=true;
                intent = new Intent(MainActivity.this,AskForId.class);
                startActivity(intent);
                break;
            case R.id.button9:
                Connect c = new Connect(this);
                c.deleteAllRecords();
                break;
        }
    }
}
