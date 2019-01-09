package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Item {
    @JsonProperty("itemId")
    private final String itemId;
    @JsonProperty("stackCount")
    private final int stackCount;
    @JsonProperty("category")
    private final String category;
    @JsonProperty("subCategory")
    private final String subCategory;
    @JsonProperty("attachedItems")
    private final List<String> attachedItems;

    public Item(String itemId, int stackCount, String category, String subCategory, List<String> attachedItems) {
        this.itemId = itemId;
        this.stackCount = stackCount;
        this.category = category;
        this.subCategory = subCategory;
        this.attachedItems = attachedItems;
    }

    public String getItemId() {
        return itemId;
    }

    public int getStackCount() {
        return stackCount;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public List<String> getAttachedItems() {
        return attachedItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return stackCount == item.stackCount &&
                Objects.equals(itemId, item.itemId) &&
                Objects.equals(category, item.category) &&
                Objects.equals(subCategory, item.subCategory) &&
                Objects.equals(attachedItems, item.attachedItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, stackCount, category, subCategory, attachedItems);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", stackCount=" + stackCount +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", attachedItems=" + attachedItems +
                '}';
    }
}
