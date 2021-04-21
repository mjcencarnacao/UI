package com.mjceo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Dashboard2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void openApp(View view) {
        Intent launch;
        Uri sms;
        switch (view.getId()) {
            case R.id.back:
                launch = new Intent(this, MainActivity.class);
                break;
            case R.id.person1:
                sms = Uri.parse("smsto:" + "+3519123456781");
                launch = new Intent(Intent.ACTION_SENDTO, sms);
                launch.setPackage("com.whatsapp");
                break;
            case R.id.person2:
                sms = Uri.parse("smsto:" + "+3519123456782");
                launch = new Intent(Intent.ACTION_SENDTO, sms);
                launch.setPackage("com.whatsapp");
                break;
            case R.id.person3:
                sms = Uri.parse("tel:+3519123456783");
                launch = new Intent(Intent.ACTION_DIAL, sms);
                break;
            case R.id.person4:
                sms = Uri.parse("tel:+3519123456784");
                launch = new Intent(Intent.ACTION_DIAL, sms);
                break;
            case R.id.person5:
                sms = Uri.parse("tel:+3519123456785");
                launch = new Intent(Intent.ACTION_DIAL, sms);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        if (launch != null)
            startActivity(launch);
        else
            Toast.makeText(this, "App does not exist", Toast.LENGTH_LONG);
    }
}
