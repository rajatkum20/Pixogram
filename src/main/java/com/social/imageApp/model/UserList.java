package com.social.imageApp.model;

import java.util.List;

public class UserList {
private String title;
private String tags;
private String Description;
public List<UserList> usersLists;
public List<UserList> getUsersLists() {
	return usersLists;
}
public void setUsersLists(List<UserList> usersLists) {
	this.usersLists = usersLists;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getTags() {
	return tags;
}
public void setTags(String tags) {
	this.tags = tags;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}

}
