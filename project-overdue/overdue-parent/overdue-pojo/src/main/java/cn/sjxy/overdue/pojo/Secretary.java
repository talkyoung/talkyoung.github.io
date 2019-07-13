package cn.sjxy.overdue.pojo;

import java.io.Serializable;

public class Secretary implements Serializable {
    private Integer secId;

    private String secName;

    private String secPassword;

    public Integer getSecId() {
        return secId;
    }

    @Override
	public String toString() {
		return "Secretary [secId=" + secId + ", secName=" + secName + ", secPassword=" + secPassword + "]";
	}

	public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName == null ? null : secName.trim();
    }

    public String getSecPassword() {
        return secPassword;
    }

    public void setSecPassword(String secPassword) {
        this.secPassword = secPassword == null ? null : secPassword.trim();
    }
}