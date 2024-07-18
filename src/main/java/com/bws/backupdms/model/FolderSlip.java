/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bws.backupdms.model;

import java.util.Date;

/**
 *
 * @author adminapp
 */
public class FolderSlip {
    private long id;
    private String namazipfile;
    private String source_location;
    private int flag_process_upload;
    private Date created_at;
    private Date updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamazipfile() {
        return namazipfile;
    }

    public void setNamazipfile(String namazipfile) {
        this.namazipfile = namazipfile;
    }

    public String getSource_location() {
        return source_location;
    }

    public void setSource_location(String source_location) {
        this.source_location = source_location;
    }
    

    public int getFlag_process_upload() {
        return flag_process_upload;
    }

    public void setFlag_process_upload(int flag_process_upload) {
        this.flag_process_upload = flag_process_upload;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
