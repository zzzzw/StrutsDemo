package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import common.BaseAction;

import dao.DataDAO;

/*
 * Action相当于DAO层与JSP层中间的传达室，Action有属性和方法，属性 是接发信件的信箱，函数 是接发信件的传达人
 * 
 */

//struts注解
@SuppressWarnings("serial")
@Results( { @Result(name = "p2", location = "/12306/p2.jsp"),
		@Result(name = "p3", location = "/12306/p3.jsp"),
		@Result(name = "p4", location = "/12306/p4.jsp"),
		@Result(name = "p5", location = "/12306/p5.jsp") })
public class DdAction extends BaseAction {

	////////////////////////////////////////////////////////////////以下是属性
	
	//使用属性传参，实现get/set
	private String sfz;
	private String ddz;
	private List<String[]> cclist;
	private String checi;
	private List<String> cklist;
	private String gxck;
	private List<String[]> qdlist;
	private int zonge;

	// 可以定义一个通用的容器参数，供通常使用
	//Action的参数对于每一次客户端发来的请求，都是重新赋值的
	// private String commpar;
	
	
	
	
	
	
    ////////////////////////////////////////////////////////////////以下是方法
	
	// 此方法处理查询车次
	public String cp() throws Exception {
		// 业务逻辑
		System.out.println("开始查询订单.....");

		// 传统的接受参数方法
		// String sfz=this.getRequest().getParameter("sfz");
		// String ddz=this.getRequest().getParameter("ddz");

		// 传统的返回参数方法
		// this.getRequest().setAttribute("list", result);

		// 使用struts属性传参，只需声明get/set方法即可
		cclist = DataDAO.getcclist(sfz, ddz);

		System.out.println("查询订单成功.....结果返回");

		return "p2";
	}

	// 此方法处理订票
	public String yd() throws Exception {
		// 根据登录用户取出自己的乘客信息，并且传到jsp
		String loginuser = "admin";

		cklist = DataDAO.getcklist(loginuser);

		return "p3";
	}

	// 此方法确认订单
	public String qd() throws Exception {

		// 查询选择的用户信息，往Jsp送
		qdlist = DataDAO.getqdlist(gxck);

		return "p4";
	}

	// 支付
	public String zf() throws Exception {
		System.out.println("接受的总和为："+zonge);		
		System.out.println("传到jsp页面");		
		return "p5";
	}

	
	
	
	
	///////////////////////////////////////////// 以下是get/set方法
	public int getZonge() {
		return zonge;
	}

	public void setZonge(int zonge) {
		this.zonge = zonge;
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public String getDdz() {
		return ddz;
	}

	public void setDdz(String ddz) {
		this.ddz = ddz;
	}

	public String getCheci() {
		return checi;
	}

	public void setCheci(String checi) {
		this.checi = checi;
	}

	public List<String[]> getCclist() {
		return cclist;
	}

	public void setCclist(List<String[]> cclist) {
		this.cclist = cclist;
	}

	public List<String> getCklist() {
		return cklist;
	}

	public void setCklist(List<String> cklist) {
		this.cklist = cklist;
	}

	public String getGxck() {
		return gxck;
	}

	public void setGxck(String gxck) {
		this.gxck = gxck;
	}

	public List<String[]> getQdlist() {
		return qdlist;
	}

	public void setQdlist(List<String[]> qdlist) {
		this.qdlist = qdlist;
	}
}