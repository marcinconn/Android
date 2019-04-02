package com.example.marcin.projectv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class Result extends AppCompatActivity {

    List<Record> listRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Connect c = new Connect(this);
        if(Find.sScpecific==true) {listRec = c.getSpecific(); Find.sScpecific = false;} else
        if(Find.sAll==true) {listRec = c.getAll(); Find.sAll = false;}

        ListView lV = findViewById(R.id.resList);

        RecordAdapter recAd = new RecordAdapter(this,R.layout.adapter_view_layout, listRec);
        lV.setAdapter(recAd);
    }
}
