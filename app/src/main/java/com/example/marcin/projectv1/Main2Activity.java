
package com.example.marcin.projectv1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Date;

public class Main2Activity extends AppCompatActivity implements android.view.View.OnClickListener{

    String qualityS, reportS, promptnessS, complaintS, currentCooperationS, contactS, warningsS, nick;
    Integer qualityI, reportI, promptnessI, complaintI, currentCooperationI, contactI;
    Boolean b1=true, b2=true, b3=true, b4=true, b5=true, b6=true, empty=true;
    private Connect con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.button).setOnClickListener(this);
        con = new Connect(this);
    }

    @Override
    public void onClick(View view) {
        try{
            EditText et1 = findViewById(R.id.editText7);
            qualityS = et1.getText().toString();
            if (!qualityS.equalsIgnoreCase("")) {
                qualityI = Integer.parseInt(qualityS);
                b1 = false;
            }
            EditText et2 = findViewById(R.id.editText8);
            reportS = et2.getText().toString();
            if (!reportS.equalsIgnoreCase("")) {
                reportI = Integer.parseInt(reportS);
                b2 = false;
            }
            EditText et3 = findViewById(R.id.editText9);
            promptnessS = et3.getText().toString();
            if (!promptnessS.equalsIgnoreCase("")) {
                promptnessI = Integer.parseInt(promptnessS);
                b3 = false;
            }
            EditText et4 = findViewById(R.id.editText10);
            complaintS = et4.getText().toString();
            if (!complaintS.equalsIgnoreCase("")) {
                complaintI = Integer.parseInt(complaintS);
                b4 = false;
            }
            EditText et5 = findViewById(R.id.editText11);
            currentCooperationS = et5.getText().toString();
            if (!currentCooperationS.equalsIgnoreCase("")) {
                currentCooperationI = Integer.parseInt(currentCooperationS);
                b5 = false;
            }
            EditText et6 = findViewById(R.id.editText12);
            contactS = et6.getText().toString();
            if (!contactS.equalsIgnoreCase("")) {
                contactI = Integer.parseInt(contactS);
                b6 = false;
            }
            EditText et7 = findViewById(R.id.editText3);
            warningsS = et7.getText().toString();
            EditText et8 = findViewById(R.id.editText2);
            nick = et8.getText().toString();
            if (!nick.equalsIgnoreCase("")) empty = false;
            if (b1==true||b2==true||b3==true||b4==true||b5==true||b6==true||empty==true) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, "NIEPEŁNE DANE WEJŚCIOWE", duration);
                toast.show();
            } else {
                b1=b2=b3=b4=b5=b6=true;
                if(qualityI==1||qualityI==2||qualityI==3||qualityI==4||qualityI==5) b1 = false;
                if(reportI==1||reportI==2||reportI==3||reportI==4||reportI==5) b2 = false;
                if(promptnessI==1||promptnessI==2||promptnessI==3||promptnessI==4||promptnessI==5) b3 = false;
                if(complaintI==1||complaintI==2||complaintI==3||complaintI==4||complaintI==5) b4 = false;
                if(currentCooperationI==1||currentCooperationI==2||currentCooperationI==3||currentCooperationI==4||currentCooperationI==5) b5 = false;
                if(contactI==1||contactI==2||contactI==3||contactI==4||contactI==5) b6 = false;
                if(b1==true||b2==true||b3==true||b4==true||b5==true||b6==true){
                    Toast toast = Toast.makeText(getApplicationContext(), "NIERAWIDŁOWE DANE WEJŚCIOWE", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    try{
                        Date dat = new Date();
                        String d = dat.toString();
                        con.insertRecord(new Record(qualityI,reportI,promptnessI,complaintI,currentCooperationI,contactI,warningsS,d,nick));
                        con.close();
                        Toast toast = Toast.makeText(getApplicationContext(), "ZAPISANE", Toast.LENGTH_LONG);
                        toast.show();
                        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(intent);
                        }
                        catch (Exception e){
                            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                }
            }
        }
        catch (Exception e){
            Context context = getApplicationContext();
            CharSequence text = e.getMessage();
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}
