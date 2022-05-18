package com.lauterbach.karte;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewWordActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.lauterbach.karte";

    private EditText mEditWordView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word_);
        mEditWordView = findViewById(R.id.edit_word);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(mEditWordView.getText())){
                    Toast.makeText(NewWordActivity.this, "empty_not_saved", Toast.LENGTH_LONG).show();
                }else{
                    Intent replyIntent = new Intent();
                    String word = mEditWordView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                    finish();
                }
            }
        });
    }
}
