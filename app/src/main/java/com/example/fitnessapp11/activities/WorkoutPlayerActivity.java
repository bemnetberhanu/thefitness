package com.example.fitnessapp11.activities;



import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapp11.R;

// activities/WorkoutPlayerActivity.java
public class WorkoutPlayerActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        String videoId = getIntent().getStringExtra("VIDEO_ID"); // Get video ID from intent
        webView = findViewById(R.id.webView);

        setupWebView(videoId);
    }

    private void setupWebView(String videoId) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        // HTML to embed YouTube video
        String html = "<html>" +
                "<body style='margin:0;padding:0;'>" +
                "<iframe width=\"100%\" height=\"100%\" " +
                "src=\"https://www.youtube.com/embed/" + videoId + "?autoplay=1\" " +
                "frameborder=\"0\" allowfullscreen></iframe>" +
                "</body>" +
                "</html>";

        webView.loadData(html, "text/html", "utf-8");
    }

    // From another activity


    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroy();
    }
}