package io.leinbach.pubg.domain;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/9/2019
 */
public class ItemDto {
    private String itemId;
    private int stackCount;
    private String category;
    private String subCategory;
    private List<String> attachedItems;
    private int fireCount;

    public int getFireCount() {
        return fireCount;
    }

    public ItemDto fireCount(int fireCount) {
        this.fireCount = fireCount;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public ItemDto itemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public int getStackCount() {
        return stackCount;
    }

    public ItemDto stackCount(int stackCount) {
        this.stackCount = stackCount;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ItemDto category(String category) {
        this.category = category;
        return this;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public ItemDto subCategory(String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public List<String> getAttachedItems() {
        return attachedItems;
    }

    public ItemDto attachedItems(List<String> attachedItems) {
        this.attachedItems = attachedItems;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ItemDto.class.getSimpleName() + "[", "]")
                .add("itemId='" + itemId + "'")
                .add("stackCount=" + stackCount)
                .add("category='" + category + "'")
                .add("subCategory='" + subCategory + "'")
                .add("attachedItems=" + attachedItems)
                .add("fireCount=" + fireCount)
                .toString();
    }
}
