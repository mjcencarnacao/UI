package com.mjceo.ui;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openApp(View view) {
        Intent launch;
        Uri sms;
        switch (view.getId()) {
            case R.id.youtube:
                launch = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                break;
            case R.id.person6:
                sms = Uri.parse("tel:+3519123456786");
                launch = new Intent(Intent.ACTION_DIAL, sms);
                break;
            case R.id.news:
                sms = Uri.parse("https://news.google.com/topstories?hl=pt-PT&gl=PT&ceid=PT:pt-150");
                launch = new Intent(Intent.ACTION_VIEW, sms);
                break;
            case R.id.person8:
                sms = Uri.parse("tel:+3519123456789");
                launch = new Intent(Intent.ACTION_DIAL, sms);
                break;
            case R.id.next:
                launch = new Intent(this, Dashboard2.class);
                break;
            case R.id.person7:
                sms = Uri.parse("smsto:" + "+3519123456787");
                launch = new Intent(Intent.ACTION_SENDTO, sms);
                launch.setPackage("com.whatsapp");
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
