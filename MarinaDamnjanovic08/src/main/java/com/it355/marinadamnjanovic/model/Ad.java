package com.it355.marinadamnjanovic.model;

import java.io.Serializable;

/**
 *
 * @author Marina
 */
public class Ad implements Serializable{
    
    private int id;
    private String title;
    private String description;
    private String deadline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
}
