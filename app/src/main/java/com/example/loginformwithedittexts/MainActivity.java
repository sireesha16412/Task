package com.example.loginformwithedittexts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextKey;
    private EditText mEditTextValue;
    Button btn_submit;
    private List<Modelclass> mPrefDataList;
    private SharedPrefAdpter mPrefAdapter;
    RecyclerView recyclerView;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEditTextKey=findViewById(R.id.et_emial);
        mEditTextValue=findViewById(R.id.et_phone_number);
        btn_submit=findViewById(R.id.btn_submit);
       recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mPrefDataList = PrefMethods.getAllValues(MainActivity.this);
        mPrefAdapter = new SharedPrefAdpter(MainActivity.this, mPrefDataList);
        recyclerView.setAdapter(mPrefAdapter);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveValueInPref();
            }
        });

    }
    private void saveValueInPref() {
        String key = mEditTextKey.getText().toString();
        String value = mEditTextValue.getText().toString();
        if (key.isEmpty()) {
            mEditTextKey.setError("Enter Email-id");
        } else if (value.isEmpty()) {
            mEditTextValue.setError("Enter Number");

        } else if(!key.matches(emailPattern)){
            Toast.makeText(MainActivity.this, "Invalid Email Pattern", Toast.LENGTH_SHORT).show();
            mEditTextKey.setError("Please enter valid email id pattern");
        }
        else {
            PrefMethods.saveString(MainActivity.this, key, value);
            mPrefDataList.add(new Modelclass(key,value));
        }
    }
}