package com.example.dingitakeone;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("result")
    @Expose
    private List<Result> result;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("id")
    @Expose
    private String id;


    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("address")
    @Expose
    private String address;

    public Data(List<Result> result, String source, String id, String type, String address) {
        this.result = result;
        this.source = source;
        this.id = id;
        this.type = type;
        this.address = address;
    }

    public List<Result> getResult() {
        return result;
    }

    public String getSource() {
        return source;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Data{" +
                "result=" + result +
                ", source='" + source + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
