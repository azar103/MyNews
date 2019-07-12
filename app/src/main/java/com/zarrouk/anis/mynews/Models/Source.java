package com.zarrouk.anis.mynews.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Anis Zarrouk on 10/07/2019
 */
public class Source {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = -5060855296955643907L;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
