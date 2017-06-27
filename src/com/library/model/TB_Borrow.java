package com.library.model;
//������Ϣ

import java.math.BigDecimal;
import java.sql.Date;

public class TB_Borrow {
//	private BigDecimal borrowID;//����˳���
	private int rdID;//�������
	private int bkID;//ͼ�����
	private int idContinueTimes;//�������
	private Date	idDateOut;//��������
	private Date idDateRetPlan;//Ӧ������
	private Date idDateRetAct;//ʵ�ʻ�������
	private int idOverDay;//��������
	private BigDecimal idOverMoney;//Ӧ������
	private BigDecimal idPunishMoney;//������
	private boolean isHasReturn;//�Ƿ���
	private String operatorLend;//�������Ա
	private String operatorRet;//�������Ա
	public TB_Borrow(int rdID, int bkID, int idContinueTimes, Date idDateOut, Date idDateRetPlan, Date idDateRetAct,
			int idOverDay, BigDecimal idOverMoney, BigDecimal idPunishMoney,boolean isHasReturn, String operatorLend,
			String operatorRet) {
		super();
		this.rdID = rdID;
		this.bkID = bkID;
		this.idContinueTimes = idContinueTimes;
		this.idDateOut = idDateOut;
		this.idDateRetPlan = idDateRetPlan;
		this.idDateRetAct = idDateRetAct;
		this.idOverDay = idOverDay;
		this.idOverMoney = idOverMoney;
		this.idPunishMoney = idPunishMoney;
		this.isHasReturn = isHasReturn;
		this.operatorLend = operatorLend;
		this.operatorRet = operatorRet;
	}
	public TB_Borrow(int rdID, int bkID, int idContinueTimes, Date idDateOut, Date idDateRetPlan,boolean isHasReturn,String operatorLend) {
		super();
		this.rdID = rdID;
		this.bkID = bkID;
		this.idContinueTimes = idContinueTimes;
		this.idDateOut = idDateOut;
		this.idDateRetPlan = idDateRetPlan;
		this.isHasReturn = isHasReturn;
		this.operatorLend = operatorLend;
	}
	public TB_Borrow(int rdID, int bkID, int idContinueTimes, Date idDateOut, Date idDateRetPlan,boolean isHasReturn) {
		super();
		this.rdID = rdID;
		this.bkID = bkID;
		this.idContinueTimes = idContinueTimes;
		this.idDateOut = idDateOut;
		this.idDateRetPlan = idDateRetPlan;
		this.isHasReturn = isHasReturn;

	}
	public int getRdID() {
		return rdID;
	}
	public void setRdID(int rdID) {
		this.rdID = rdID;
	}
	public int getBkID() {
		return bkID;
	}
	public void setBkID(int bkID) {
		this.bkID = bkID;
	}
	public int getIdContinueTimes() {
		return idContinueTimes;
	}
	public void setIdContinueTimes(int idContinueTimes) {
		this.idContinueTimes = idContinueTimes;
	}
	public Date getIdDateOut() {
		return idDateOut;
	}
	public void setIdDateOut(Date idDateOut) {
		this.idDateOut = idDateOut;
	}
	public Date getIdDateRetPlan() {
		return idDateRetPlan;
	}
	public void setIdDateRetPlan(Date idDateRetPlan) {
		this.idDateRetPlan = idDateRetPlan;
	}
	public Date getIdDateRetAct() {
		return idDateRetAct;
	}
	public void setIdDateRetAct(Date idDateRetAct) {
		this.idDateRetAct = idDateRetAct;
	}
	public int getIdOverDay() {
		return idOverDay;
	}
	public void setIdOverDay(int idOverDay) {
		this.idOverDay = idOverDay;
	}
	public BigDecimal getIdOverMoney() {
		return idOverMoney;
	}
	public void setIdOverMoney(BigDecimal idOverMoney) {
		this.idOverMoney = idOverMoney;
	}
	public BigDecimal getIdPunishMoney() {
		return idPunishMoney;
	}
	public void setIdPunishMoney(BigDecimal idPunishMoney) {
		this.idPunishMoney = idPunishMoney;
	}
	public boolean isHasReturn() {
		return isHasReturn;
	}
	public void setHasReturn(boolean isHasReturn) {
		this.isHasReturn = isHasReturn;
	}
	
	public String getOperatorLend() {
		return operatorLend;
	}
	public void setOperatorLend(String operatorLend) {
		this.operatorLend = operatorLend;
	}
	public String getOperatorRet() {
		return operatorRet;
	}
	public void setOperatorRet(String operatorRet) {
		this.operatorRet = operatorRet;
	}
	
	
}
