package com.xiaoyuan.qbot.event;

import kotlin.coroutines.experimental.CoroutineContext;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.message.GroupMessageEvent;
import net.mamoe.mirai.message.data.*;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * @author zhengjiayuan
 * @Create 2020-08-08
 */
@Slf4j

public class GroupMessagesEvent extends SimpleListenerHost {

    /**
     * 全局异常捕获！
     */
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        System.out.println(context + " " + exception);
    }

    @EventHandler
    public ListeningStatus message(GroupMessageEvent messageEvent) {

        log.info("message: {}", messageEvent.getMessage().toString());

        // 过滤代写

        // 过滤 java 信息
//        MessageChain messages = messageEvent.getMessage();
//        Message message = MessageUtils.getOrFail(messages, GroupImage.Key);
//
//        Iterator<SingleMessage> singleMessages = messages.iterator();
//        while (singleMessages.hasNext()) {
//            SingleMessage singleMessage = singleMessages.next();
//
//            singleMessage.
//        }
        return ListeningStatus.LISTENING;
    }

}
