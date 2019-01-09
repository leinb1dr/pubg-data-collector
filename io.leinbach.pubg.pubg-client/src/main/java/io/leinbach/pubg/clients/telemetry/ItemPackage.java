package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class ItemPackage {
    @JsonProperty("itemPackageId")
    private final String itemPackageId;
    @JsonProperty("location")
    private final Location location;
    @JsonProperty("items")
    private final List<Item> items;

    public ItemPackage(String itemPackageId, Location location, List<Item> items) {
        this.itemPackageId = itemPackageId;
        this.location = location;
        this.items = items;
    }

    public String getItemPackageId() {
        return itemPackageId;
    }

    public Location getLocation() {
        return location;
    }

    public List<Item> getItems() {
        return items;
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
