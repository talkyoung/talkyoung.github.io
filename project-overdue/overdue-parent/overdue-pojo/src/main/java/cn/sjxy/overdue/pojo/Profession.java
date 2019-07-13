package cn.sjxy.overdue.pojo;

import java.io.Serializable;

public class Profession implements Serializable {
    

	private Integer proId;

    private String proName;

    private Integer deptId;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    @Override
	public String toString() {
		return "Profession [proId=" + proId + ", proName=" + proName + ", deptId=" + deptId + "]";
	}

    @Override
    public boolean equals(Object obj) {
        return proId == ((Profession)obj).getProId();
    }
}