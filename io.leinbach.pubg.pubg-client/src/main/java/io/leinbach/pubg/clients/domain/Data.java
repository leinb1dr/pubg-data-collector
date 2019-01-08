
package io.leinbach.pubg.clients.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;


/**
 * N/A
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data<T> {

    protected T data;
    protected Links links;
    protected Map<String, Object> meta;

    public Data() {
    }

    public Data(T data, Links links, Map<String, Object> meta) {
        this.data = data;
        this.links = links;
        this.meta = meta;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data<?> data1 = (Data<?>) o;
        return Objects.equals(data, data1.data) &&
                Objects.equals(links, data1.links) &&
                Objects.equals(meta, data1.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    public T getData() {
        return data;
    }

    public Data<T> data(T data) {
        this.data = data;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public Data<T> links(Links links) {
        this.links = links;
        return this;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public Data<T> meta(Map<String, Object> meta) {
        this.meta = meta;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Data.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("links=" + links)
                .add("meta=" + meta)
                .toString();
    }
}
