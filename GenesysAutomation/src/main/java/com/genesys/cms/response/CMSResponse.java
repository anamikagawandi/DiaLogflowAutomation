package com.genesys.cms.response;


public class CMSResponse {

private Integer id;
private String name;
private Object views;
private Integer accountId;
private Integer accessibility;
private String description;
private Object email;
private Boolean isPublished;
private String codename;
private Integer languageId;
private Integer position;
private String createdAt;
private String updatedAt;
private String answer=" ";

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Object getViews() {
return views;
}

public void setViews(Object views) {
this.views = views;
}

public Integer getAccountId() {
return accountId;
}

public void setAccountId(Integer accountId) {
this.accountId = accountId;
}

public Integer getAccessibility() {
return accessibility;
}

public void setAccessibility(Integer accessibility) {
this.accessibility = accessibility;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Object getEmail() {
return email;
}

public void setEmail(Object email) {
this.email = email;
}

public Boolean getIsPublished() {
return isPublished;
}

public void setIsPublished(Boolean isPublished) {
this.isPublished = isPublished;
}

public String getCodename() {
return codename;
}

public void setCodename(String codename) {
this.codename = codename;
}

public Integer getLanguageId() {
return languageId;
}

public void setLanguageId(Integer languageId) {
this.languageId = languageId;
}

public Integer getPosition() {
return position;
}

public void setPosition(Integer position) {
this.position = position;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public String getUpdatedAt() {
return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

public String getAnswer() {
return answer;
}

public void setAnswer(String answer) {
this.answer = answer;
}

}