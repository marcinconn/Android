package com.example.marcin.projectv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AskForId extends AppCompatActivity implements android.view.View.OnClickListener {

    public static boolean change=false, delSpecific=false;
    private String idToDo;
    private Integer intID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_id);

        if(change==true) findViewById(R.id.button2).setEnabled(true);
        if(change==false) findViewById(R.id.button2).setEnabled(false);
        if(delSpecific==true) findViewById(R.id.button10).setEnabled(true);
        if(delSpecific==false) findViewById(R.id.button10).setEnabled(false);

        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            EditText et = findViewById(R.id.editText17);
            idToDo = et.getText().toString();
            intID = Integer.parseInt(idToDo);
            Intent intent;
            switch (view.getId()) {
                case R.id.button2:
                    Connect c = new Connect(this);
                    boolean b = c.ifIdExists(intID);
                    if(b){
                        c.getRecortToChange(intID);
                        intent = new Intent(AskForId.this, Main3Activity.class);
                        startActivity(intent);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "BRAK SZUKANEGO ID", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    break;
                case R.id.button10:
                    Connect c2 = new Connect(this);
                    boolean b2 = c2.ifIdExists(intID);
                    if(b2) {
                        c2.deleteSpecific(intID);
                        intent = new Intent(AskForId.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "BRAK SZUKANEGO ID", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    break;
            }
        }
        catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
