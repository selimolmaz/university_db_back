package com.hibernate.demo.dto;

import lombok.Data;


public class AdvisorDTO {
    private String sId;  // Danışmanın ID'si
    private String iId;  // Eğitmenin ID'si

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }
}
