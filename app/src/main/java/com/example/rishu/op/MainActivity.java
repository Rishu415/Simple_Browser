package com.example.rishu.op;

import android.content.Context;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        WebView web;
    EditText ed1;
    Button go,forward,back,refresh,clear;
    ProgressBar pb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb=(ProgressBar)findViewById(R.id.pb1);
        web=(WebView)findViewById(R.id.wv1);

        ed1 =(EditText)findViewById(R.id.url1);
        go=(Button)findViewById(R.id.btngo);
        forward=(Button)findViewById(R.id.bfor);
        back=(Button)findViewById(R.id.bbac);
        refresh=(Button)findViewById(R.id.bref);
        clear=(Button)findViewById(R.id.bcle);
        web.loadUrl("http://www.gmail.com");
        web.setWebViewClient(new web1());

        web.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pb.setProgress(newProgress);
                if(newProgress==100){
                    pb.setVisibility(View.GONE);
                }
                else {
                    pb.setVisibility(View.VISIBLE);
                }

            }
        });
        WebSettings ws1=web.getSettings();
        ws1.setJavaScriptEnabled(true);

        go.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                       String Edittextvalue = ed1.getText().toString();
                                      if(!Edittextvalue.startsWith("http://"))
                                          Edittextvalue="http://" +Edittextvalue;

                                      String url=Edittextvalue;
                                      web.loadUrl(url);
                                      InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                                      imm.hideSoftInputFromWindow(ed1.getWindowToken(),0);
                                  }
                              }) ;
        forward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(web.canGoForward())
                    web.goForward();


            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(web.canGoBack())
                    web.goBack();

            }
        });

        refresh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                web.reload();

            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                web.clearHistory();

            }
        });



    }

    }

