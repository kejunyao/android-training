package com.kejunyao.robotium;

import android.widget.EditText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * Robotium白盒测试
 *
 * @author kejunyao
 * @since 2021年02月10日
 */
@RunWith(AndroidJUnit4.class)
public class RobotiumWhiteBoxTest {
    @Rule
    public ActivityTestRule<RobotiumActivity> activityTestRule =
            new ActivityTestRule<>(RobotiumActivity.class);

    private Solo solo;

    @Before
    public void setUp() throws Exception {
        /**
         * 初始化工作，放在这里执行
         */
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),
                activityTestRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        /**
         * 资源回收工作，放在这里执行
         */
        solo.finishOpenedActivities();
    }

    @Test
    public void testLogin() throws Exception {
        solo.unlockScreen();
        EditText username = (EditText) solo.getView(R.id.user_name);
        EditText password = (EditText) solo.getView(R.id.pass_word);
        solo.clearEditText(username);
        solo.clearEditText(password);
        solo.enterText(username, "admin");
        solo.enterText(password, "123456");

        solo.clickOnView(solo.getView(R.id.login));

        boolean success = solo.waitForText("登录成功");
        assertTrue( "无法获取预期结果", success);

        solo.sleep(10000);
    }

    @Test
    public void testCaptureScreen() {
        // /sdcard/Robotium-Screenshots/
        solo.takeScreenshot("robotium_shot");
        solo.sleep(5000);
    }
}
