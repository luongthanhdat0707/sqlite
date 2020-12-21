package com.example.sqllife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class TacGiaActivity extends AppCompatActivity {

    EditText edtmaso, edtten, edtdiachi, edtemail;
    Button btnthoat, btntruyvan, btnxoa, btnluu, btnsua;
    GridView gvlist;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tac_gia);

        edtmaso = (EditText) findViewById(R.id.edtms);
        edtdiachi = (EditText) findViewById(R.id.edtdc);
        edtten = (EditText) findViewById(R.id.edtten);
        edtemail = (EditText) findViewById(R.id.edtemail);
        btnluu = (Button) findViewById(R.id.btnluu);
        btnsua = (Button) findViewById(R.id.btnsua);
        btnthoat = (Button) findViewById(R.id.btnthoat);
        btntruyvan = (Button) findViewById(R.id.btntruyvan);
        btnxoa = (Button) findViewById(R.id.btnxoa);
        gvlist = (GridView) findViewById(R.id.grvlist);
        dbHelper = new DBHelper(this);

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TacGia tg = new TacGia();
                tg.setMaso(Integer.parseInt(edtmaso.getText().toString()));
                tg.setTen(edtten.getText().toString());
                tg.setDiachi(edtdiachi.getText().toString());
                tg.setEmail(edtemail.getText().toString());
                if (dbHelper.insertTacgia(tg) > 0)
                    Toast.makeText(TacGiaActivity.this, "Đã lưu thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(TacGiaActivity.this, "Lưu không thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btntruyvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<TacGia> list_tacgia;
                ArrayList<String> list_string = new ArrayList<>();
                list_tacgia = dbHelper.getAllTacgia();
                for (TacGia tg : list_tacgia) {
                    list_string.add(tg.getMaso() + "");
                    list_string.add(tg.getTen());
                    list_string.add(tg.getDiachi());
                    list_string.add(tg.getEmail());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(TacGiaActivity.this, android.R.layout.simple_list_item_1, list_string);
                gvlist.setAdapter(adapter);
            }
        });
    }
}
