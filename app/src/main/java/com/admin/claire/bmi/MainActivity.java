package com.admin.claire.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button btnCalculateBMI;
    private Button btnHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI說明")
                        .setMessage("體重(kg)/身高的平方(m)")
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
    }

    private void initView() {
        edWeight = (EditText)findViewById(R.id.edit_Weight);
        edHeight = (EditText)findViewById(R.id.edit_Height);
        btnCalculateBMI = (Button)findViewById(R.id.btn_Calculate);
        btnHelp = (Button)findViewById(R.id.btn_Help);
    }

    public void onClickBmi(View view){
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();

        try{
                //字串轉成float型態
                float weight = Float.parseFloat(w);
                float height = Float.parseFloat(h);
                float bmi = weight / (height * height);
                Toast.makeText(this, "BMI:" + String.valueOf(bmi) , Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage(bmi + "")
                        .setTitle("BMI專案")
                        .setPositiveButton("OK",null)
                        .setNegativeButton("Cancel",null)
                        .show();


        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "請輸入身高體重...", Toast.LENGTH_SHORT).show();
        }


    }
}
