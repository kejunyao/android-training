package com.kejunyao.leak;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年02月03日
 */
public class LeakActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        mTextView = findViewById(R.id.content);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createMuchMemory();
            }
        });

        LeakInstance.getInstance(this);
    }

    /**
     * 故意造大量的内存
     */
    private void createMuchMemory() {
        int size = 10000;
        String result = "";
        for (int i = 0; i < size; i++) {
            result += "sdsdsdhsdhsdsjdsdhhjsddsjdsjhdsjdsjcreateMuchMemory_";
        }
        System.out.println(result);
    }
}
