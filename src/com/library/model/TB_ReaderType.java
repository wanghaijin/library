package com.library.model;
//�������
public class TB_ReaderType {
	private int rdType;//�������
	private String rdTypeName;//�������
	private int canLendQty;//�ɽ�������
	private int canLendDay;//�ɽ�������
	private int canContinueTimes;//���������
	private float punishRate;//������
	private int dateValid;//֤����Ч��
	public TB_ReaderType(int rdType, String rdTypeName, int canLendQty, int canLendDay, int canContinueTimes,
			float punishRate, int dateValid) {
		super();
		this.rdType = rdType;
		this.rdTypeName = rdTypeName;
		this.canLendQty = canLendQty;
		this.canLendDay = canLendDay;
		this.canContinueTimes = canContinueTimes;
		this.punishRate = punishRate;
		this.dateValid = dateValid;
	}
	public int getRdType() {
		return rdType;
	}
	public void setRdType(int rdType) {
		this.rdType = rdType;
	}
	public String getRdTypeName() {
		return rdTypeName;
	}
	public void setRdTypeName(String rdTypeName) {
		this.rdTypeName = rdTypeName;
	}
	public int getCanLendQty() {
		return canLendQty;
	}
	public void setCanLendQty(int canLendQty) {
		this.canLendQty = canLendQty;
	}
	public int getCanLendDay() {
		return canLendDay;
	}
	public void setCanLendDay(int canLendDay) {
		this.canLendDay = canLendDay;
	}
	public int getCanContinueTimes() {
		return canContinueTimes;
	}
	public void setCanContinueTimes(int canContinueTimes) {
		this.canContinueTimes = canContinueTimes;
	}
	public float getPunishRate() {
		return punishRate;
	}
	public void setPunishRate(float punishRate) {
		this.punishRate = punishRate;
	}
	public int getDateValid() {
		return dateValid;
	}
	public void setDateValid(int dateValid) {
		this.dateValid = dateValid;
	}
	
	
}
