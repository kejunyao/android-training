package com.kejunyao.algorithm;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.kejunyao.algorithm.array.SortColors;
import com.kejunyao.base.SolutionExecutor;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年02月11日
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView showResultView = findViewById(R.id.show_result_view);
        SolutionExecutor executor = new SolutionExecutor(showResultView);
        executor.execute(SortColors.class);
        // executor.execute(MergeSortedArray.class);
    }


}
