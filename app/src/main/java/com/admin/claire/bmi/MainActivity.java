package com.admin.claire.bmi;

import android.content.Intent;
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

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

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
            /*
                Toast.makeText(this, "BMI:" + String.valueOf(bmi) , Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage(bmi + "")
                        .setTitle("BMI專案")
                        .setPositiveButton("OK",null)
                        .setNegativeButton("Cancel",null)
                        .show();
             */
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra(getString(R.string.bmi_extra), bmi);
            startActivity(intent);


        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, R.string.input_weight_height, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
