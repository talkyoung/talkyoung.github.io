package cn.sjxy.overdue.pojo;

import java.io.Serializable;

public class Picture  implements Serializable {
    private Integer pId;

    private String pName;

    private Integer tId;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

	@Override
	public String toString() {
		return "Picture [pId=" + pId + ", pName=" + pName + ", tId=" + tId + "]";
	}
    
}