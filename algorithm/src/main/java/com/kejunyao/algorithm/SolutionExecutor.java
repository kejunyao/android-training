package com.kejunyao.algorithm;

import android.widget.TextView;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年02月11日
 */
public class SolutionExecutor {

    // private Solution solution;

    private TextView showResultView;

    public SolutionExecutor(TextView showResultView) {
        this.showResultView = showResultView;
    }

    public void execute(Class<? extends Solution> clazz) {
        try {
            Solution solution = clazz.newInstance();
            showResultView.setText(solution.getResult());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
