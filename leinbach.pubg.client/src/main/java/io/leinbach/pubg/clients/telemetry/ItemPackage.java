package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.leinbach.pubg.domain.ItemPackageDto;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ItemPackage {
    @JsonProperty("itemPackageId")
    private String itemPackageId;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("items")
    private List<Item> items;

    public String getItemPackageId() {
        return itemPackageId;
    }

    public void setItemPackageId(String itemPackageId) {
        this.itemPackageId = itemPackageId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public ItemPackageDto to() {
        return new ItemPackageDto()
                .itemPackageId(itemPackageId)
                .location(location.to())
                .items(items.stream()
                        .map(Item::to)
                        .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPackage that = (ItemPackage) o;
        return Objects.equals(itemPackageId, that.itemPackageId) &&
                Objects.equals(location, that.location) &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemPackageId, location, items);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ItemPackage.class.getSimpleName() + "[", "]")
                .add("itemPackageId='" + itemPackageId + "'")
                .add("location=" + location)
                .add("items=" + items)
                .toString();
    }
}
