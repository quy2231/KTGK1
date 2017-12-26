package com.daiktam.ktgiuaky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView ma,ten,cu,moi,kieu,tien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ma=(TextView)findViewById(R.id.txtMKH);
        ten=(TextView)findViewById(R.id.txtTKH);
        cu=(TextView)findViewById(R.id.txtCu);
        moi=(TextView)findViewById(R.id.txtMoi);
        kieu=(TextView)findViewById(R.id.txtKieu);
        tien=(TextView)findViewById(R.id.txtTT);
        Intent intent=getIntent();
        Nguoi a=(Nguoi)intent.getSerializableExtra("cc");
        ma.setText(ma.getText()+" "+a.maKH);
        ten.setText(ten.getText()+" "+a.getTenKH());
        cu.setText(cu.getText()+" "+a.getSoCu());
        moi.setText(moi.getText()+" "+a.getSoMoi());
        tien.setText(tien.getText()+" "+a.tinhTien());
        String s="";
        int b=a.getKieu();
        if(b==1)
            s="Hộ gia đình";
        else if(b==2)
            s="Cơ quan hành chính";
        else
            s="Đơn vị sản xuất";
        kieu.setText(kieu.getText()+" "+s);
    }
}
