package com.kejunyao.algorithm;

import com.kejunyao.base.Solution;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年03月04日
 */
public class ClockCoincidence implements Solution {

    private static final int TIME = 24 * 60;

    @Override
    public String getResult() {
        // 时钟一圈用 12 * 60 分钟, 一分钟：1 / 60圈；R / M
        // 分钟一圈用 60 分钟，一分钟：1 / 720圈

        // (1 / 60 - 1 / 720); // 11 / 720

        return null;
    }
}
