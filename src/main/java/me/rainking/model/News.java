package me.rainking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class News {

    /**
     *
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     *
     */
    private String title;
    /**
     *
     */
    private String content;

    private Date publishTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "id:" + id + "\ttitle:" + title + "\tcontent:" + content + "\tpublishTime:" + publishTime;
    }
}
