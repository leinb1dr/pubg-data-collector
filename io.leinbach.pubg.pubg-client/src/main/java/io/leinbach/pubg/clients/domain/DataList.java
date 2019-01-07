package io.leinbach.pubg.clients.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author leinb
 * @since 12/24/2018
 */
public class DataList<T> {

    private List<T> data;
    private Links links;
    private Map<String, Object> meta;

    @Override
    public String toString() {
        return new StringJoiner(", ", DataList.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("links=" + links)
                .add("meta=" + meta)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataList<?> dataList = (DataList<?>) o;
        return Objects.equals(data, dataList.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public List<T> getData() {
        return data;
    }

    public DataList<T> setData(List<T> data) {
        this.data = data;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public DataList<T> setLinks(Links links) {
        this.links = links;
        return this;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public DataList<T> setMeta(Map<String, Object> meta) {
        this.meta = meta;
        return this;
    }
}
