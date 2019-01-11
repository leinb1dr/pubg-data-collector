package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.ItemDto;

import java.util.List;
import java.util.Objects;

public class Item {
    @JsonProperty("itemId")
    private String itemId;
    @JsonProperty("stackCount")
    private int stackCount;
    @JsonProperty("category")
    private String category;
    @JsonProperty("subCategory")
    private String subCategory;
    @JsonProperty("attachedItems")
    private List<String> attachedItems;

    public ItemDto to(){
        return new ItemDto()
                .itemId(itemId)
                .stackCount(stackCount)
                .category(category)
                .subCategory(subCategory)
                .attachedItems(attachedItems);
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getStackCount() {
        return stackCount;
    }

    public void setStackCount(int stackCount) {
        this.stackCount = stackCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public List<String> getAttachedItems() {
        return attachedItems;
    }

    public void setAttachedItems(List<String> attachedItems) {
        this.attachedItems = attachedItems;
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
