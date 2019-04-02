package com.example.marcin.projectv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3Activity extends AppCompatActivity implements android.view.View.OnClickListener {

    public static Record dataToChange = new Record();
    public static String nickU, warningsU;

    private Integer qualityU, reportU, promptnessU, complaintU, currentCooperationU, contactU, idChanged;
    EditText et1, et2, et3, et4, et5, et6, et7, et8;
    private boolean b1=true, b2=true, b3=true, b4=true, b5=true, b6=true, emptyNick=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et1 = findViewById(R.id.editText18);
        et2 = findViewById(R.id.editText20);
        et3 = findViewById(R.id.editText21);
        et4 = findViewById(R.id.editText22);
        et5 = findViewById(R.id.editText23);
        et6 = findViewById(R.id.editText24);
        et7 = findViewById(R.id.editText25);
        et8 = findViewById(R.id.editText26);

        et1.setText(dataToChange.getQuality().toString());
        et2.setText(dataToChange.getREPORT().toString());
        et3.setText(dataToChange.getPromptness().toString());
        et4.setText(dataToChange.getComplaint().toString());
        et5.setText(dataToChange.getCurrentCooperation().toString());
        et6.setText(dataToChange.getContact().toString());
        et7.setText(dataToChange.getNick().toString());
        et8.setText(dataToChange.getWarnings().toString());

        idChanged = dataToChange.getRec_id();

        findViewById(R.id.button11).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            Pattern p = Pattern.compile("[1-5]");
            Matcher m;

            m = p.matcher(et1.getText().toString());
            if(!m.matches()) b1 = false; else qualityU = Integer.parseInt(et1.getText().toString());

            m = p.matcher(et2.getText().toString());
            if(!m.matches()) b2 = false; else reportU = Integer.parseInt(et2.getText().toString());

            m = p.matcher(et3.getText().toString());
            if(!m.matches()) b3 = false; else promptnessU = Integer.parseInt(et3.getText().toString());

            m = p.matcher(et4.getText().toString());
            if(!m.matches()) b4 = false; else complaintU = Integer.parseInt(et4.getText().toString());

            m = p.matcher(et5.getText().toString());
            if(!m.matches()) b5 = false; else currentCooperationU = Integer.parseInt(et5.getText().toString());

            m = p.matcher(et6.getText().toString());
            if(!m.matches()) b6 = false; else contactU = Integer.parseInt(et6.getText().toString());

            if(et7.getText().toString().equals("")) emptyNick=true; else nickU = et7.getText().toString();

            warningsU = et8.getText().toString();

            if(b1==false || b2==false || b3==false || b4==false || b5==false || b6==false || emptyNick==true){
                Toast toast = Toast.makeText(getApplicationContext(), "NIEPRAWIDŁOWE DANE WEJŚCIOWE", Toast.LENGTH_LONG);
                toast.show();
            } else {
                Connect c = new Connect(this);
                c.updateRecord(idChanged,qualityU,reportU,promptnessU,complaintU,currentCooperationU,contactU,nickU,warningsU);
                Toast toast = Toast.makeText(getApplicationContext(), "ZAMIENIONE", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);
            }
        }
        catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
