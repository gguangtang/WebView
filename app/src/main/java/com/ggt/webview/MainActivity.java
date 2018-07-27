package com.ggt.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText mEdtUrl;
    private Button mBtnSreach;
    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }

    private void initViews() {
        mEdtUrl = (EditText) findViewById(R.id.edt_url);
        mBtnSreach = (Button) findViewById(R.id.btn_sreach);
    }

    private void initEvents() {
        mBtnSreach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sreachUrl();
            }
        });
        mEdtUrl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    sreachUrl();
                }
                return false;
            }
        });
    }

    private void sreachUrl() {
        String edt = mEdtUrl.getText().toString().trim();
        mUrl = "https://" + edt;
        Html5Activity.loadUrl(MainActivity.this,mUrl);
    }
}
