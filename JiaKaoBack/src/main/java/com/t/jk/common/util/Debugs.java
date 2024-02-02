package com.t.jk.common.util;

/**
 * ClassName: Debugs
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/2 16:18
 * @Version: 1.0
 */
public class Debugs {
    public static final boolean DEBUG = true;

    public static void run(Runnable runnable) {
        if (!DEBUG) return;
        if (runnable == null) return;;
        runnable.run();
    }
}
