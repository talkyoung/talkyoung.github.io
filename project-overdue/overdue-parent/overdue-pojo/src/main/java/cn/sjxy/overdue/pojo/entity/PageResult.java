package cn.sjxy.overdue.pojo.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 鍒嗛〉缁撴灉绫�
 * @author Administrator
 *
 */
public class PageResult implements Serializable{

	private long total;//鎬昏褰曟暟
	private List rows;//褰撳墠椤佃褰�
		
	public PageResult(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageResult [total=" + total + ", rows=" + rows + "]";
	}
	
}
