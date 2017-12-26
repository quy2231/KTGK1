package com.daiktam.ktgiuaky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMKH,edtTenKH,edtCSC,edtCSM;
    Button btnXoa,btnThem;
    ArrayList<Nguoi>arr=null;
    ArrayAdapter adapter;
    RadioGroup rdgr;
    RadioButton rd1,rd2,rd3;
    ListView lv;
    int vt=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addC();
        addE();
    }

    private void addE() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMKH.setText("");
                edtTenKH.setText("");
                edtCSC.setText("");
                edtCSM.setText("");
                edtTenKH.requestFocus();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vt=position;
                return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maKH=edtMKH.getText().toString();
                String tenKH=edtTenKH.getText().toString();
                String cu=edtCSC.getText().toString();
                String moi=edtCSM.getText().toString();
                int kieu=0;
                if(maKH.length()<1 ||tenKH.length()<1 ||cu.length()<1 || moi.length()<1)
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ!", Toast.LENGTH_SHORT).show();
                else
                {
                    switch (rdgr.getCheckedRadioButtonId())
                    {
                        case R.id.rd1:
                            kieu=1;
                            break;
                        case R.id.rd2:
                            kieu=2;
                            break;
                        case R.id.rd3:
                            kieu=3;
                            break;
                    }
                    arr.add(new Nguoi(maKH,tenKH,kieu,Integer.parseInt(cu),Integer.parseInt(moi)));
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void addC() {
        edtMKH=(EditText)findViewById(R.id.edtMaKH);
        edtTenKH=(EditText)findViewById(R.id.edtTenKH);
        edtCSC=(EditText)findViewById(R.id.edtCSC);
        edtCSM=(EditText)findViewById(R.id.edtCSM);
        btnXoa=(Button)findViewById(R.id.btnXoa);
        btnThem=(Button)findViewById(R.id.btnThem);
        lv=(ListView)findViewById(R.id.lv);
        rdgr=(RadioGroup)findViewById(R.id.rdgr);
        rd1=(RadioButton)findViewById(R.id.rd1);
        rd2=(RadioButton)findViewById(R.id.rd2);
        rd3=(RadioButton)findViewById(R.id.rd3);
        arr=new ArrayList<Nguoi>();
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.xoa:
                arr.remove(vt);
                adapter.notifyDataSetChanged();
                break;
            case R.id.xem:
                Intent intent = new Intent(this,Main2Activity.class);
                intent.putExtra("cc",arr.get(vt));
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
