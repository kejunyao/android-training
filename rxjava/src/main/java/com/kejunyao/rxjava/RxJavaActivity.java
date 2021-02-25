package com.kejunyao.rxjava;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年02月14日
 */
public class RxJavaActivity extends AppCompatActivity {

    public static final String TAG = "RxJavaActivity_";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RxJavaFilterOperator.elementAt();

    }


}
