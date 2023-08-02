package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String fileName="example.txt";
    EditText et;
    EditText et1;
    EditText et2;
    EditText et3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.editTextText);
        et1=findViewById(R.id.editTextText2);
        et2=findViewById(R.id.editTextText3);
        et3=findViewById(R.id.editTextText4);
    }
    public void save(View v){
        String id=et.getText().toString();
        String name=et1.getText().toString();
        String A_name=et2.getText().toString();
        String price=et3.getText().toString();
        FileOutputStream fileOutputStream=null;
        try{
            fileOutputStream=openFileOutput(fileName,MODE_PRIVATE);
            fileOutputStream.write(id.getBytes());
            et.getText().clear();
            et1.getText().clear();
            et2.getText().clear();
            et3.getText().clear();
            Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream!=null){
                try{
                    fileOutputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}