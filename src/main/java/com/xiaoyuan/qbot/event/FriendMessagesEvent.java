package com.xiaoyuan.qbot.event;

import com.xiaoyuan.qbot.QbotApplication;
import kotlin.coroutines.experimental.CoroutineContext;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.message.FriendMessageEvent;
import net.mamoe.mirai.message.data.*;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.Iterator;

/**
 * @author zhengjiayuan
 * @Create 2020-08-10
 */
@Slf4j
public class FriendMessagesEvent extends SimpleListenerHost {

    /**
     * 全局异常捕获！
     */
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        System.out.println(context + " " + exception);
    }

    @EventHandler
    public ListeningStatus message(FriendMessageEvent friendMessageEvent) {

        log.info("message: {}", friendMessageEvent.getMessage().toString());

        MessageChain messages = friendMessageEvent.getMessage();

        Iterator<SingleMessage> singleMessageIterator = messages.iterator();
        while (singleMessageIterator.hasNext()) {
            SingleMessage singleMessage = singleMessageIterator.next();
        }
        FriendImage flashImage = messages.first(FriendImage.Key);
        if (flashImage != null) {
            log.info("image url: {}", QbotApplication.bot.queryImageUrl(flashImage));
        }

        return ListeningStatus.LISTENING;
    }

}
