package com.kejunyao.robotium;

import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

/**
 * Robotium黑盒测试
 *
 * @author kejunyao
 * @since 2021年02月10日
 */
@RunWith(AndroidJUnit4.class)
public class RobotiumBlackBoxTest {

    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.kuaikan.main.LaunchActivity";

    private static Class launcherActivityClass;

    private Solo solo;

    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation());
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    @Test
    public void testForwardMine() {
        solo.takeScreenshot("kk");
    }

}
