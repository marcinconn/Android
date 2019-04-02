package com.example.marcin.projectv1;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Marcin on 12.05.2018.
 */
@DatabaseTable(tableName="record")
public class Record {

    @DatabaseField(columnName = "ID", generatedId = true)
    private Integer rec_id;

    @DatabaseField(columnName = "QUALITY")
    private Integer quality;

    @DatabaseField(columnName = "REPORT")
    private Integer report;

    @DatabaseField(columnName = "PROMPTNESS")
    private Integer promptness;

    @DatabaseField(columnName = "COMPLAINT")
    private  Integer complaint;

    @DatabaseField(columnName = "CURRENT_COOPERATION")
    private Integer currentCooperation;

    @DatabaseField(columnName = "CONTACT")
    private Integer contact;

    @DatabaseField(columnName = "WARNINGS")
    private String warnings;

    @DatabaseField(columnName = "DATE")
    private String date;

    @DatabaseField(columnName = "NICK")
    private String nick;

    public Record(){}

    public Integer getRec_id() {
        return rec_id;
    }

    public void setRec_id(Integer rec_id) {
        this.rec_id = rec_id;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getREPORT() {
        return report;
    }

    public void setREPORT(String REPORT) {
        this.report = report;
    }

    public Integer getPromptness() {
        return promptness;
    }

    public void setPromptness(Integer promptness) {
        this.promptness = promptness;
    }

    public Integer getComplaint() {
        return complaint;
    }

    public void setComplaint(Integer complaint) {
        this.complaint = complaint;
    }

    public Integer getCurrentCooperation() {
        return currentCooperation;
    }

    public void setCurrentCooperation(Integer currentCooperation) {
        this.currentCooperation = currentCooperation;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Record(Integer quality, Integer report, Integer promptness, Integer complaint, Integer currentCooperation, Integer contact, String warnings, String date, String nick) {
        this.quality = quality;
        this.report = report;
        this.promptness = promptness;
        this.complaint = complaint;
        this.currentCooperation = currentCooperation;
        this.contact = contact;
        this.warnings = warnings;
        this.date = date;
        this.nick = nick;
    }
}
