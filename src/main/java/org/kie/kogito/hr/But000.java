package org.kie.kogito.hr;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class But000 {

    @JsonProperty("PARTNER")
    private String partner;

    @JsonProperty("TYPE")
    private String type;

    @JsonProperty("XCPDTEXT")
    private String xcpdText;

    @JsonProperty("MC_NAME1")
    private String mcName1;

    @JsonProperty("MC_NAME2")
    private String mcName2;

    @JsonProperty("MC_CITY1")
    private String mcCity1;

    @JsonProperty("NAME_LAST")
    private String nameLast;

    @JsonProperty("NAME_FIRST")
    private String nameFirst;

    @JsonProperty("NAME_LST2")
    private String nameLst2;

    @JsonProperty("TITLE_KEY")
    private String titleKey;

    @JsonProperty("TITLE_P")
    private String titleP;

    @JsonProperty("BU_SORT1")
    private String buSort1;

    @JsonProperty("BU_SORT2")
    private String buSort2;

    @JsonProperty("BU_GROUP")
    private String buGroup;

    @JsonProperty("CREATED_BY")
    private String createdBy;

    @JsonProperty("CREATED_ON")
    private Date createdOn;

    @JsonProperty("CHANGED_BY")
    private String changedBy;

    @JsonProperty("CHANGED_ON")
    private Date changedOn;

    @JsonProperty("AUTH_GROUP")
    private String authGroup;

    @JsonProperty("BU_BPEXT")
    private String buBpExt;

    @JsonProperty("INDUSTRY")
    private String industry;

    @JsonProperty("LANGU")
    private String langu;

    @JsonProperty("LANGU_ISO")
    private String languIso;

    @JsonProperty("DATA_ORIGIN")
    private String dataOrigin;

    @JsonProperty("VALID_FROM")
    private Date validFrom;

    @JsonProperty("VALID_TO")
    private Date validTo;

    @JsonProperty("MARKED_FOR_DELETION")
    private String markedForDeletion;

    // Standard-Konstruktor
    public But000() {
    }

    // Getter & Setter
    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getXcpdText() {
        return xcpdText;
    }

    public void setXcpdText(String xcpdText) {
        this.xcpdText = xcpdText;
    }

    public String getMcName1() {
        return mcName1;
    }

    public void setMcName1(String mcName1) {
        this.mcName1 = mcName1;
    }

    public String getMcName2() {
        return mcName2;
    }

    public void setMcName2(String mcName2) {
        this.mcName2 = mcName2;
    }

    public String getMcCity1() {
        return mcCity1;
    }

    public void setMcCity1(String mcCity1) {
        this.mcCity1 = mcCity1;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getChangedOn() {
        return changedOn;
    }

    public void setChangedOn(Date changedOn) {
        this.changedOn = changedOn;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Override
    public String toString() {
        return "But000{" +
                "partner='" + partner + '\'' +
                ", type='" + type + '\'' +
                ", xcpdText='" + xcpdText + '\'' +
                ", mcName1='" + mcName1 + '\'' +
                ", mcName2='" + mcName2 + '\'' +
                ", mcCity1='" + mcCity1 + '\'' +
                ", nameLast='" + nameLast + '\'' +
                ", nameFirst='" + nameFirst + '\'' +
                ", nameLst2='" + nameLst2 + '\'' +
                ", titleKey='" + titleKey + '\'' +
                ", titleP='" + titleP + '\'' +
                ", buSort1='" + buSort1 + '\'' +
                ", buSort2='" + buSort2 + '\'' +
                ", buGroup='" + buGroup + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", changedBy='" + changedBy + '\'' +
                ", changedOn='" + changedOn + '\'' +
                ", authGroup='" + authGroup + '\'' +
                ", buBpExt='" + buBpExt + '\'' +
                ", industry='" + industry + '\'' +
                ", langu='" + langu + '\'' +
                ", languIso='" + languIso + '\'' +
                ", dataOrigin='" + dataOrigin + '\'' +
                ", validFrom='" + validFrom + '\'' +
                ", validTo='" + validTo + '\'' +
                ", markedForDeletion='" + markedForDeletion + '\'' +
                '}';
    }
}
