package com.example.testapp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Usd_result extends AppCompatActivity {

    WebView webView;
    private Button check;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usd_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        webView = findViewById(R.id.webview);
        check = findViewById(R.id.check);
        textView = findViewById(R.id.text);

        webView.getSettings().setJavaScriptEnabled(true);

        Bundle argument = getIntent().getExtras();
        String name = argument.get("usd").toString();
        textView.setText("Текущее значение доллара США: " + name);
        check.setText("Проверить");



        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewClient wcClient = new WebViewClient();
                webView.setWebViewClient(wcClient);
                webView.loadUrl("http://www.banki.ru/products/currency/cash/moskva/");

            }
        });
    }
}
