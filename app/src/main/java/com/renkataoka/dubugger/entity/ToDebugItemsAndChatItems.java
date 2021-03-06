package com.renkataoka.dubugger.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

/**
 * ToDebugItemsとChatItemsを関連付けるデータクラス。
 */
public class ToDebugItemsAndChatItems {
    @Embedded
    public ToDebugItems toDebugItem;
    @Relation(
            parentColumn = "to_debug_item_id",
            entityColumn = "to_debug_id"
    )
    public List<ChatItems> chatItems;
}
