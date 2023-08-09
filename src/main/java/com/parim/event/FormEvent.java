package com.parim.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.parim.event.chat.chatList.ChatListEvent;
import com.parim.event.chat.block.ListOfBlockedUsernamesEvent;
import com.parim.event.chat.message.MessageEvent;
import com.parim.event.chat.message.SendMessageEvent;
import com.parim.event.chat.block.BlockUserEvent;
import com.parim.event.chat.block.UnblockUserEvent;
import com.parim.event.notification.NotificationEvent;
import com.parim.event.notification.UserNotifications;
import com.parim.event.room.RoomEvent;
import com.parim.event.shop.BuyItemEvent;
import com.parim.event.shop.ComboBuyItemEvent;
import com.parim.event.shop.ItemEvent;
import com.parim.event.shop.UserShopEvent;
import com.parim.event.user.UserEvent;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserEvent.class, name = "UserEvent"),
        @JsonSubTypes.Type(value = ItemEvent.class, name = "ItemEvent"),
        @JsonSubTypes.Type(value = BuyItemEvent.class, name = "BuyItemEvent"),
        @JsonSubTypes.Type(value = ChatListEvent.class, name = "ChatListEvent"),
        @JsonSubTypes.Type(value = MessageEvent.class, name = "MessageEvent"),
        @JsonSubTypes.Type(value = SendMessageEvent.class, name = "SendMessageEvent"),
        @JsonSubTypes.Type(value = ListOfBlockedUsernamesEvent.class, name = "ListOfBlockedUsernamesEvent"),
        @JsonSubTypes.Type(value = BlockUserEvent.class, name = "BlockUserEvent"),
        @JsonSubTypes.Type(value = UnblockUserEvent.class, name = "UnblockUserEvent"),
        @JsonSubTypes.Type(value = RoomEvent.class, name = "RoomEvent"),
        @JsonSubTypes.Type(value = NotificationEvent.class, name = "NotificationEvent"),
        @JsonSubTypes.Type(value = UserNotifications.class, name = "UserNotifications"),
        @JsonSubTypes.Type(value = UserShopEvent.class, name = "UserShopEvent"),
        @JsonSubTypes.Type(value = ComboBuyItemEvent.class, name = "ComboBuyItemEvent"),
})
public interface FormEvent {
}

