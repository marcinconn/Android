package com.example.marcin.projectv1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Marcin on 02.06.2018.
 */

public class RecordAdapter extends ArrayAdapter<Record> {

    private Context mContaxt;
    int res;

    public RecordAdapter(Context context, int resource, List<Record> objects) {
        super(context, resource, objects);
        mContaxt = context;
        res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String ID = getItem(position).getRec_id().toString();
        String qVal = getItem(position).getQuality().toString();
        String rVal = getItem(position).getREPORT().toString();
        String pVal = getItem(position).getPromptness().toString();
        String coVal = getItem(position).getComplaint().toString();
        String cuVal = getItem(position).getCurrentCooperation().toString();
        String cnVal = getItem(position).getContact().toString();
        String dVal = getItem(position).getDate();
        String nVal = getItem(position).getNick();
        String wVal = getItem(position).getWarnings();

        LayoutInflater inflater = LayoutInflater.from(mContaxt);
        convertView = inflater.inflate(res,parent,false);

        TextView tv1 = convertView.findViewById(R.id.showID);
        TextView tv2 = convertView.findViewById(R.id.showQuality);
        TextView tv3 = convertView.findViewById(R.id.showReport);
        TextView tv4 = convertView.findViewById(R.id.showPromptness);
        TextView tv5 = convertView.findViewById(R.id.showComplaint);
        TextView tv6 = convertView.findViewById(R.id.showCurrentCooperation);
        TextView tv7 = convertView.findViewById(R.id.showContact);
        TextView tv8 = convertView.findViewById(R.id.showDate);
        TextView tv9 = convertView.findViewById(R.id.showNick);
        TextView tv10 = convertView.findViewById(R.id.showWarnings);
        TextView tv11 = convertView.findViewById(R.id.qualityValue);
        TextView tv12 = convertView.findViewById(R.id.reportValue);
        TextView tv13 = convertView.findViewById(R.id.promptnessVal);
        TextView tv14 = convertView.findViewById(R.id.complaintVal);
        TextView tv15 = convertView.findViewById(R.id.currentCooperationVal);
        TextView tv16 = convertView.findViewById(R.id.contactVal);
        TextView tv17 = convertView.findViewById(R.id.dateVal);
        TextView tv18 = convertView.findViewById(R.id.nickVal);
        TextView tv19 = convertView.findViewById(R.id.warningsVal);

        tv1.setText(ID);
        tv2.setText("JAKOŚĆ WYK. BAD.");
        tv3.setText("JAKOŚĆ SPR. Z BAD.");
        tv4.setText("TEMINOWOŚĆ");
        tv5.setText("REKLAMACJE");
        tv6.setText("BIEŻ. WSPÓŁP.");
        tv7.setText("ŁATW. KON.");
        tv8.setText("DATA WYPEŁNIENIA");
        tv9.setText("NICK");
        tv10.setText("UWAGI");
        tv11.setText(qVal);
        tv12.setText(rVal);
        tv13.setText(pVal);
        tv14.setText(coVal);
        tv15.setText(cuVal);
        tv16.setText(cnVal);
        tv17.setText(dVal);
        tv18.setText(nVal);
        tv19.setText(wVal);

        return convertView;
    }
}
