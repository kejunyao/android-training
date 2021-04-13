package com.kejunyao.test;

import com.kejunyao.base.Solution;
import com.kejunyao.base.Utils;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年03月05日
 */
public class Test implements Solution {

    private static final int TOTAL_TIME = 12 * 60 * 60;

    private static final double MV = 1 / 60;
    private static final double HV = 1 / 360;


    @Override
    public String getResult() {
        // 360 / 60 = 6, 两点之间是6度
        // 1、分针度数 - 时针度数 = 正负 6度
        // 分针的速度 1 / 60 个6度 s / 6度
        // 时针的速度 1 / 360 个6度 s / 6度
        // diffV = (1 / 60 - 1 / 360) s / 6度
        // s = vt;
        // s1 - s2 = 6度
        // v1 * t - v2 * t = 6度
        // time = 12 * 60 * 60;
        // count = time / diffV;
        //

        double diffV = MV - HV;
        int count = (int) (TOTAL_TIME / diffV);
        Utils.log("XXXXYYY", "count: ", count);

        int time = 0; // 发生的时刻
        for (int i = 1; i <= count; i++) {
            time = (int) (diffV * count);

            Utils.log("XXXXYYY", "第", time, "秒");
        }

        return "";
    }
}
