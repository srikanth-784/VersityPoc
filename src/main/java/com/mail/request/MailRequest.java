package com.mail.request;

import com.mail.model.MailModel;

public class MailRequest {

	MailModel mail;
	String notificationType;
	
	public MailModel getMail() {
		return mail;
	}
	public void setMail(MailModel mail) {
		this.mail = mail;
	}
	public String getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((notificationType == null) ? 0 : notificationType.hashCode());
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
		MailRequest other = (MailRequest) obj;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (notificationType == null) {
			if (other.notificationType != null)
				return false;
		} else if (!notificationType.equals(other.notificationType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MailRequest [mail=" + mail + ", notificationType=" + notificationType + "]";
	}
	
	
	
}
