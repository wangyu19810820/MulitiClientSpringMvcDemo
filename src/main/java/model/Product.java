package model;

import java.util.Date;

/**
 * Created by admin on 2017/6/17.
 */
public class Product {
    protected Long id;
    protected String name;
    protected String desc;
    protected Date publishDate;

    public Product() {
    }

    public Product(Long id, String name, String desc, Date publishDate) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
