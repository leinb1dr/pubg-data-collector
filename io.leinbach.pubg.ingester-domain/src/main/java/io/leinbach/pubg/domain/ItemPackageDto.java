package io.leinbach.pubg.domain;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 1/9/2019
 */
public class ItemPackageDto {
    private String itemPackageId;
    private LocationDto location;
    private List<ItemDto> items;

    public String getItemPackageId() {
        return itemPackageId;
    }

    public ItemPackageDto itemPackageId(String itemPackageId) {
        this.itemPackageId = itemPackageId;
        return this;
    }

    public LocationDto getLocation() {
        return location;
    }

    public ItemPackageDto location(LocationDto location) {
        this.location = location;
        return this;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public ItemPackageDto items(List<ItemDto> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ItemPackageDto.class.getSimpleName() + "[", "]")
                .add("itemPackageId='" + itemPackageId + "'")
                .add("location=" + location)
                .add("items=" + items)
                .toString();
    }
}
