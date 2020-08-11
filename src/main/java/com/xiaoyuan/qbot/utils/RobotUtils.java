package com.xiaoyuan.qbot.utils;

import cn.hutool.core.collection.ConcurrentHashSet;
import net.mamoe.mirai.utils.FileCacheStrategy;

/**
 * @author ：quziwei
 * @date ：06/08/2020 19:37
 * @description：
 */

public class RobotUtils {
    private static RobotUtils instance;

    public static final ConcurrentHashSet<Long> adminGroups = new ConcurrentHashSet<>();

    public static FileCacheStrategy.MemoryCache memoryCache;

    private RobotUtils(){}

    public static RobotUtils getInstance() {
        if (instance == null){
            synchronized (RobotUtils.class){
                if (instance == null){
                    instance = new RobotUtils();
                    return instance;
                }
            }
        }
        return instance;
    }

}
