package com.kejunyao.test;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kejunyao.base.SolutionExecutor;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年03月04日
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView showResultView = findViewById(R.id.show_result_view);
        showResultView.setMovementMethod(ScrollingMovementMethod.getInstance());
        // SolutionExecutor executor = new SolutionExecutor(showResultView);
        // executor.execute(Test.class);

        findViewById(R.id.action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), IdCardActivity.class));
            }
        });
    }

}
