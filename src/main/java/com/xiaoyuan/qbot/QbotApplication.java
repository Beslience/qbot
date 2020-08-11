package com.xiaoyuan.qbot;

import com.xiaoyuan.qbot.event.FriendMessagesEvent;
import com.xiaoyuan.qbot.event.GroupMessagesEvent;
import com.xiaoyuan.qbot.utils.RobotUtils;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactoryJvm;
import net.mamoe.mirai.event.Events;
import net.mamoe.mirai.utils.BotConfiguration;
import net.mamoe.mirai.utils.FileCacheStrategy;
import net.mamoe.mirai.utils.SystemDeviceInfoKt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class QbotApplication {

    public static Bot bot = null;

    public static void main(String[] args) {

        Long qq = 2693587758L;
        String password = "qaz877804730";
        bot = BotFactoryJvm.newBot(
                qq,
                password,
                new BotConfiguration() {{
                    // 设备缓存信息
                    //setProtocol(MiraiProtocol.ANDROID_PHONE);
                    setDeviceInfo(context -> SystemDeviceInfoKt.loadAsDeviceInfo(new File("deviceInfo.json"), getJson(), context));
                    setFileCacheStrategy(FileCacheStrategy.MemoryCache.INSTANCE);
                    RobotUtils.memoryCache = FileCacheStrategy.MemoryCache.INSTANCE;

                }}
        );
        // 登录
        bot.login();

        Events.registerEvents(new GroupMessagesEvent());
        Events.registerEvents(new FriendMessagesEvent());

        SpringApplication.run(QbotApplication.class, args);

    }
}
