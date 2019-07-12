package com.zarrouk.anis.mynews.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


/**
 * Created by Anis Zarrouk on 06/07/2019
 */
public class ResponseModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Long totalResults;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;
    private final static long serialVersionUID = 5368039946997183573L;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
