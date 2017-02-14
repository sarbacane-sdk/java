package com.sarbacane.api.Lists;

public class SBSmsLists extends ListsManager {
    public String id = null;
    public String name = null;

    @Override
    public String toString() {
        return "PTList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}