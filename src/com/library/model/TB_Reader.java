package com.library.model;
//������Ϣ
import java.sql.Date;

public class TB_Reader {
	private int rdId;//���߱��
	private String rdName;//����
	private String rdSex;//�Ա�
	private int rdType;//�������
	private String rdDept;//��λ����
	private String rdPhone;//��������
	private String rdEmail;//���ߵǼ�����
	private Date rdDateReg;//��Ƭ
	private String rdPhoto;//֤����Ƭ
	private String rdStatus;//֤��״̬
	private int rdBorrowQty;//�ѽ�������
	private String rdPwd;//��������
	private int rdAdminRoles;//�����ɫ
	public TB_Reader(int rdId, String rdName, String rdSex, int rdType, String rdDept, String rdPhone, String rdEmail,
			Date rdDateReg, String rdPhoto, String rdStatus, int rdBorrowQty, String rdPwd, int rdAdminRoles) {
		super();
		this.rdId = rdId;
		this.rdName = rdName;
		this.rdSex = rdSex;
		this.rdType = rdType;
		this.rdDept = rdDept;
		this.rdPhone = rdPhone;
		this.rdEmail = rdEmail;
		this.rdDateReg = rdDateReg;
		this.rdPhoto = rdPhoto;
		this.rdStatus = rdStatus;
		this.rdBorrowQty = rdBorrowQty;
		this.rdPwd = rdPwd;
		this.rdAdminRoles = rdAdminRoles;
	}
	public int getRdId() {
		return rdId;
	}
	public void setRdId(int rdId) {
		this.rdId = rdId;
	}
	public String getRdName() {
		return rdName;
	}
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	public String getRdSex() {
		return rdSex;
	}
	public void setRdSex(String rdSex) {
		this.rdSex = rdSex;
	}
	public int getRdType() {
		return rdType;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	public String getRdDept() {
		return rdDept;
	}
	public void setRdDept(String rdDept) {
		this.rdDept = rdDept;
	}
	public String getRdPhone() {
		return rdPhone;
	}
	public void setRdPhone(String rdPhone) {
		this.rdPhone = rdPhone;
	}
	public String getRdEmail() {
		return rdEmail;
	}
	public void setRdEmail(String rdEmail) {
		this.rdEmail = rdEmail;
	}
	public Date getRdDateReg() {
		return rdDateReg;
	}
	public void setRdDateReg(Date rdDateReg) {
		this.rdDateReg = rdDateReg;
	}
	public String getRdPhoto() {
		return rdPhoto;
	}
	public void setRdPhoto(String rdPhoto) {
		this.rdPhoto = rdPhoto;
	}
	public String getRdStatus() {
		return rdStatus;
	}
	public void setRdStatus(String rdStatus) {
		this.rdStatus = rdStatus;
	}
	public int getRdBorrowQty() {
		return rdBorrowQty;
	}
	public void setRdBorrowQty(int rdBorrowQty) {
		this.rdBorrowQty = rdBorrowQty;
	}
	public String getRdPwd() {
		return rdPwd;
	}
	public void setRdPwd(String rdPwd) {
		this.rdPwd = rdPwd;
	}
	public int getRdAdminRoles() {
		return rdAdminRoles;
	}
	public void setRdAdminRoles(int rdAdminRoles) {
		this.rdAdminRoles = rdAdminRoles;
	}
	
	
	
	
}
