package com.gcit.training.library.domain;

import java.util.ArrayList;
import java.util.List;

public class Publisher extends AbstractDomain {
/**
	 * 
	 */
	private static final long serialVersionUID = 249472914117953232L;
int publisherid;
public int getPublisherid() {
	return publisherid;
}
public void setPublisherid(int publisherid) {
	this.publisherid = publisherid;
}
public String getPublishername() {
	return publishername;
}
public void setPublishername(String publishername) {
	this.publishername = publishername;
}
public String getPublisheraddress() {
	return publisheraddress;
}
public void setPublisheraddress(String publisheraddress) {
	this.publisheraddress = publisheraddress;
}
public String getPublisherphone() {
	return publisherphone;
}
public void setPublisherphone(String publisherphone) {
	this.publisherphone = publisherphone;
}
public List<String> getBookid() {
	return bookid;
}
public void setBookid(List<String> bookid) {
	this.bookid = bookid;
}
String publishername;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
	result = prime * result
			+ ((publisheraddress == null) ? 0 : publisheraddress.hashCode());
	result = prime * result + publisherid;
	result = prime * result
			+ ((publishername == null) ? 0 : publishername.hashCode());
	result = prime * result
			+ ((publisherphone == null) ? 0 : publisherphone.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Publisher other = (Publisher) obj;
	if (bookid == null) {
		if (other.bookid != null)
			return false;
	} else if (!bookid.equals(other.bookid))
		return false;
	if (publisheraddress == null) {
		if (other.publisheraddress != null)
			return false;
	} else if (!publisheraddress.equals(other.publisheraddress))
		return false;
	if (publisherid != other.publisherid)
		return false;
	if (publishername == null) {
		if (other.publishername != null)
			return false;
	} else if (!publishername.equals(other.publishername))
		return false;
	if (publisherphone == null) {
		if (other.publisherphone != null)
			return false;
	} else if (!publisherphone.equals(other.publisherphone))
		return false;
	return true;
}
String publisheraddress;
String publisherphone;
List<String> bookid = new ArrayList<String>();
}

