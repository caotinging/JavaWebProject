package gip.domain;

/*
 * 来封装账务信息的JavaBean。
 */

public class ZhangWu {
	private int zwid;
	private String flname;
	private double money;
	private String zhangHu;
	private String createtime;
	private String description;
	
	public ZhangWu() {}

	public ZhangWu(int zwid, String flname, double money, String zhangHu,
			String createtime, String description) {
		super();
		this.zwid = zwid;
		this.flname = flname;
		this.money = money;
		this.zhangHu = zhangHu;
		this.createtime = createtime;
		this.description = description;
	}

	public int getZwid() {
		return zwid;
	}

	public void setZwid(int zwid) {
		this.zwid = zwid;
	}

	public String getFlname() {
		return flname;
	}

	public void setFlname(String flname) {
		this.flname = flname;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getZhangHu() {
		return zhangHu;
	}

	public void setZhangHu(String zhangHu) {
		this.zhangHu = zhangHu;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "ZhangWu [zwid=" + zwid + ", flname=" + flname + ", money="
				+ money + ", zhangHu=" + zhangHu + ", createtime=" + createtime
				+ ", description=" + description + "]";
	}
}
