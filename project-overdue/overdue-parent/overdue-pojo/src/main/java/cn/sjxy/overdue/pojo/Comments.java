package cn.sjxy.overdue.pojo;

import java.io.Serializable;
import java.util.Date;

public class Comments implements Serializable{
    private Integer comId;

    private String comContent;

    private String comJudge;

    private Integer comTeaid;

    private Integer comStuid;

    private Date comDate;

    private String comStuname;

    private String couTeaname;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent == null ? null : comContent.trim();
    }

    public String getComJudge() {
        return comJudge;
    }

    public void setComJudge(String comJudge) {
        this.comJudge = comJudge == null ? null : comJudge.trim();
    }

    public Integer getComTeaid() {
        return comTeaid;
    }

    public void setComTeaid(Integer comTeaid) {
        this.comTeaid = comTeaid;
    }

    public Integer getComStuid() {
        return comStuid;
    }

    public void setComStuid(Integer comStuid) {
        this.comStuid = comStuid;
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public String getComStuname() {
        return comStuname;
    }

    public void setComStuname(String comStuname) {
        this.comStuname = comStuname == null ? null : comStuname.trim();
    }

    public String getCouTeaname() {
        return couTeaname;
    }

    public void setCouTeaname(String couTeaname) {
        this.couTeaname = couTeaname == null ? null : couTeaname.trim();
    }

	@Override
	public String toString() {
		return "Comments [comId=" + comId + ", comContent=" + comContent + ", comJudge=" + comJudge + ", comTeaid="
				+ comTeaid + ", comStuid=" + comStuid + ", comDate=" + comDate + ", comStuname=" + comStuname
				+ ", couTeaname=" + couTeaname + "]";
	}
    
}