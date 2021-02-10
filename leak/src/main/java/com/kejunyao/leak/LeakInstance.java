package com.kejunyao.leak;

import android.content.Context;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年02月03日
 */
public final class LeakInstance {

    private static volatile LeakInstance sInstance;

    private final Context mContext;

    private LeakInstance(final Context context) {
        mContext = context;
    }

    public static LeakInstance getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LeakInstance.class) {
                if (sInstance == null) {
                    sInstance = new LeakInstance(context);
                }
            }
        }
        return sInstance;
    }

}
