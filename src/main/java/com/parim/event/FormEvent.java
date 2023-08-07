package com.parim.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
})
public interface FormEvent {
}

