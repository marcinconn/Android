package com.example.marcin.projectv1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find extends AppCompatActivity implements android.view.View.OnClickListener {

    private Connect con;
    String qualityS, reportS, promptnessS, complaintS, currentCooperationS, contactS;
    Integer qualityI, reportI, promptnessI, complaintI, currentCooperationI, contactI, zero;
    Boolean b1 = true, b2 = true, b3 = true, b4 = true, b5 = true, b6 = true;

    public static boolean sScpecific=false, sAll=false, emptyNick=false;
    public static Map<Integer,Integer> parameters = new HashMap<>();
    public static String nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find2);
        findViewById(R.id.button5).setOnClickListener(this);
        con = new Connect(this);
    }

    @Override
    public void onClick(View view) {
        try {
            zero=0;
            Pattern p = Pattern.compile("[0-5]");
            Matcher m;
            EditText et1 = findViewById(R.id.editText);
            qualityS = et1.getText().toString();
            m = p.matcher(qualityS);
            if(!m.matches()) b1 = false;

            EditText et2 = findViewById(R.id.editText4);
            reportS = et2.getText().toString();
            m = p.matcher(reportS);
            if(!m.matches()) b2 = false;

            EditText et3 = findViewById(R.id.editText5);
            promptnessS = et3.getText().toString();
            m = p.matcher(promptnessS);
            if(!m.matches()) b3 = false;

            EditText et4 = findViewById(R.id.editText6);
            complaintS = et4.getText().toString();
            m = p.matcher(complaintS);
            if(!m.matches()) b4 = false;

            EditText et5 = findViewById(R.id.editText13);
            currentCooperationS = et5.getText().toString();
            m = p.matcher(currentCooperationS);
            if(!m.matches()) b5 = false;

            EditText et6 = findViewById(R.id.editText14);
            contactS = et6.getText().toString();
            m = p.matcher(contactS);
            if(!m.matches()) b6 = false;

            EditText et8 = findViewById(R.id.editText15);
            nick = et8.getText().toString();
            if(nick.equals("")) emptyNick=true;

            if (b1 == false|| b2 == false || b3 == false || b4 == false || b5 == false || b6 == false) {
                Toast toast = Toast.makeText(getApplicationContext(), "NIEPRAWIDŁOWE DANE WEJŚCIOWE", Toast.LENGTH_LONG);
                toast.show();
            } else {
                qualityI = Integer.parseInt(qualityS);
                reportI = Integer.parseInt(reportS);
                promptnessI = Integer.parseInt(promptnessS);
                complaintI = Integer.parseInt(complaintS);
                currentCooperationI = Integer.parseInt(currentCooperationS);
                contactI = Integer.parseInt(contactS);
                parameters.put(1,qualityI);
                parameters.put(2,reportI);
                parameters.put(3,promptnessI);
                parameters.put(4,complaintI);
                parameters.put(5,currentCooperationI);
                parameters.put(6,contactI);
                Find.sScpecific=true;
                if(qualityI==0) zero++;
                if(reportI==0) zero++;
                if(promptnessI==0) zero++;
                if(complaintI==0) zero++;
                if(currentCooperationI==0) zero++;
                if(contactI==0) zero++;
                if(zero==6 && emptyNick==true) {} else {
                    Intent intent = new Intent(Find.this, Result.class);
                    startActivity(intent);
                }
            }
        } catch (Exception e) {
            Context context = getApplicationContext();
            CharSequence text = e.getMessage();
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}