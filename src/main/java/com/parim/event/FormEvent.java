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
})
public interface FormEvent {
}

