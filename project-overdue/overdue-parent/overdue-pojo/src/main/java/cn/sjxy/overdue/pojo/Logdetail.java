package cn.sjxy.overdue.pojo;

import java.io.Serializable;
import java.util.Date;

public class Logdetail  implements Serializable {
    private Integer logId;

    private String logModule;

    private String logAction;

    private Date logTime;

    private String logRole;

    private String logName;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogModule() {
        return logModule;
    }

    public void setLogModule(String logModule) {
        this.logModule = logModule == null ? null : logModule.trim();
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction == null ? null : logAction.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogRole() {
        return logRole;
    }

    public void setLogRole(String logRole) {
        this.logRole = logRole == null ? null : logRole.trim();
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName == null ? null : logName.trim();
    }

    @Override
    public String toString() {
        return "Logdetail [logId=" + logId + ", logModule=" + logModule + ", logAction=" + logAction + ", logTime="
                + logTime + ", logRole=" + logRole + ", logName=" + logName + "]";
    }
}