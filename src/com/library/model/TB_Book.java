package com.library.model;
//图书信息
import java.math.BigDecimal;
import java.sql.Date;

public class TB_Book {
	private int bkId;//图书序号
	private String bkCode;//图书编号
	private String bkName;//书名
	private String bkAuthor;//作者
	private String bkPress;//出版社
	private Date bkDatePress;//出版日期
	private String bkISBN;//ISBN书号
	private String bkCatalog;//分类号
	private int bkLanguage;//语言
	private int bkPages;//页数
	private BigDecimal bkPrice;//价格
	private Date bkDateIn;//入馆日期
	private String bkBrief;//内容介绍
	private String bkCover;//图书封面照片
	private String bkStatus;//图书状态
	public TB_Book(int bkId, String bkCode, String bkName, String bkAuthor, String bkPress, Date bkDatePress,
			String bkISBN, String bkCatalog, int bkLanguage, int bkPages, BigDecimal bkPrice, Date bkDateIn,
			String bkBrief, String bkCover, String bkStatus) {
		super();
		this.bkId = bkId;
		this.bkCode = bkCode;
		this.bkName = bkName;
		this.bkAuthor = bkAuthor;
		this.bkPress = bkPress;
		this.bkDatePress = bkDatePress;
		this.bkISBN = bkISBN;
		this.bkCatalog = bkCatalog;
		this.bkLanguage = bkLanguage;
		this.bkPages = bkPages;
		this.bkPrice = bkPrice;
		this.bkDateIn = bkDateIn;
		this.bkBrief = bkBrief;
		this.bkCover = bkCover;
		this.bkStatus = bkStatus;
	}
	public TB_Book(String bkCode, String bkName, String bkAuthor, String bkPress, Date bkDatePress, String bkISBN,
			String bkCatalog, int bkLanguage, int bkPages, BigDecimal bkPrice, Date bkDateIn, String bkBrief,
			String bkCover, String bkStatus) {
		super();
		this.bkCode = bkCode;
		this.bkName = bkName;
		this.bkAuthor = bkAuthor;
		this.bkPress = bkPress;
		this.bkDatePress = bkDatePress;
		this.bkISBN = bkISBN;
		this.bkCatalog = bkCatalog;
		this.bkLanguage = bkLanguage;
		this.bkPages = bkPages;
		this.bkPrice = bkPrice;
		this.bkDateIn = bkDateIn;
		this.bkBrief = bkBrief;
		this.bkCover = bkCover;
		this.bkStatus = bkStatus;
	}
	public String getBkCode() {
		return bkCode;
	}
	public void setBkCode(String bkCode) {
		this.bkCode = bkCode;
	}
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public String getBkAuthor() {
		return bkAuthor;
	}
	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}
	public String getBkPress() {
		return bkPress;
	}
	public void setBkPress(String bkPress) {
		this.bkPress = bkPress;
	}
	public Date getBkDatePress() {
		return bkDatePress;
	}
	public void setBkDatePress(Date bkDatePress) {
		this.bkDatePress = bkDatePress;
	}
	public String getBkISBN() {
		return bkISBN;
	}
	public void setBkISBN(String bkISBN) {
		this.bkISBN = bkISBN;
	}
	public String getBkCatalog() {
		return bkCatalog;
	}
	public void setBkCatalog(String bkCatalog) {
		this.bkCatalog = bkCatalog;
	}
	public int getBkLanguage() {
		return bkLanguage;
	}
	public void setBkLanguage(int bkLanguage) {
		this.bkLanguage = bkLanguage;
	}
	public int getBkPages() {
		return bkPages;
	}
	public void setBkPages(int bkPages) {
		this.bkPages = bkPages;
	}
	public BigDecimal getBkPrice() {
		return bkPrice;
	}
	public void setBkPrice(BigDecimal bkPrice) {
		this.bkPrice = bkPrice;
	}
	public Date getBkDateIn() {
		return bkDateIn;
	}
	public void setBkDateIn(Date bkDateIn) {
		this.bkDateIn = bkDateIn;
	}
	public String getBkBrief() {
		return bkBrief;
	}
	public void setBkBrief(String bkBrief) {
		this.bkBrief = bkBrief;
	}
	public String getBkCover() {
		return bkCover;
	}
	public void setBkCover(String bkCover) {
		this.bkCover = bkCover;
	}
	public String getBkStatus() {
		return bkStatus;
	}
	public void setBkStatus(String bkStatus) {
		this.bkStatus = bkStatus;
	}
	public int getBkId() {
		return bkId;
	}
	public void setBkId(int bkId) {
		this.bkId = bkId;
	}
	
	
}
