USE [Library]
GO
/****** Object:  Table [dbo].[TB_Book]    Script Date: 2017.1.1.星期日 03:31:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TB_Book](
	[bkID] [int] IDENTITY(1,1) NOT NULL,
	[bkCode] [nvarchar](20) NOT NULL,
	[bkName] [nvarchar](50) NOT NULL,
	[bkAuthor] [nvarchar](30) NOT NULL,
	[bkPress] [nvarchar](50) NOT NULL,
	[bkDatePress] [date] NOT NULL,
	[bkISBN] [nvarchar](15) NOT NULL,
	[bkCatalog] [nvarchar](30) NOT NULL,
	[bkLanguage] [smallint] NOT NULL,
	[bkPages] [int] NOT NULL,
	[bkPrice] [money] NOT NULL,
	[bkDateIn] [date] NOT NULL,
	[bkBrief] [text] NOT NULL,
	[bkStatus] [nchar](2) NOT NULL,
	[bkCover] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK__TB_Book__5138954E4CAAC3E8] PRIMARY KEY CLUSTERED 
(
	[bkID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TB_Borrow]    Script Date: 2017.1.1.星期日 03:31:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TB_Borrow](
	[borrowID] [numeric](12, 0) IDENTITY(1,1) NOT NULL,
	[rdID] [int] NULL,
	[bkID] [int] NULL,
	[idContinueTimes] [int] NULL,
	[idDateOut] [datetime] NULL,
	[idDateRetPlan] [datetime] NULL,
	[idDateRetAct] [datetime] NULL,
	[idOverDay] [int] NULL,
	[idOverMoney] [money] NULL,
	[idPunishMoney] [money] NULL,
	[isHasReturn] [bit] NULL,
	[operatorLend] [nvarchar](20) NULL,
	[operatorRet] [nvarchar](20) NULL,
 CONSTRAINT [PK__TB_Borro__4295F85F0476C2C8] PRIMARY KEY CLUSTERED 
(
	[borrowID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TB_Reader]    Script Date: 2017.1.1.星期日 03:31:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TB_Reader](
	[rdID] [int] NOT NULL,
	[rdName] [nvarchar](20) NOT NULL,
	[rdSex] [nchar](1) NOT NULL,
	[rdType] [smallint] NOT NULL,
	[rdDept] [nvarchar](20) NOT NULL,
	[rdPhone] [nvarchar](25) NOT NULL,
	[rdEmail] [nvarchar](25) NOT NULL,
	[rdDateReg] [date] NOT NULL,
	[rdStatus] [nchar](2) NOT NULL,
	[rdBorrowQty] [int] NOT NULL,
	[rdPwd] [nvarchar](20) NOT NULL,
	[rdAdminRoles] [smallint] NOT NULL,
	[rdPhoto] [nvarchar](25) NOT NULL,
 CONSTRAINT [PK__TB_Reade__C5665C68D318886A] PRIMARY KEY CLUSTERED 
(
	[rdID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TB_ReaderType]    Script Date: 2017.1.1.星期日 03:31:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TB_ReaderType](
	[rdType] [smallint] NOT NULL,
	[rdTypeName] [nvarchar](20) NOT NULL,
	[canLendQty] [int] NULL,
	[canLendDay] [int] NULL,
	[canContinueTimes] [int] NULL,
	[punishRate] [numeric](18, 2) NULL,
	[dateValid] [smallint] NULL,
 CONSTRAINT [PK__TB_Reade__C5367B40A4DB46F7] PRIMARY KEY CLUSTERED 
(
	[rdType] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[TB_Book] ON 

INSERT [dbo].[TB_Book] ([bkID], [bkCode], [bkName], [bkAuthor], [bkPress], [bkDatePress], [bkISBN], [bkCatalog], [bkLanguage], [bkPages], [bkPrice], [bkDateIn], [bkBrief], [bkStatus], [bkCover]) VALUES (1, N'2016', N'2016', N'2016', N'2016', CAST(0x593B0B00 AS Date), N'206', N'20', 0, 45, 18.0000, CAST(0x433C0B00 AS Date), N'22222', N'借出', N'2016.jpg')
INSERT [dbo].[TB_Book] ([bkID], [bkCode], [bkName], [bkAuthor], [bkPress], [bkDatePress], [bkISBN], [bkCatalog], [bkLanguage], [bkPages], [bkPrice], [bkDateIn], [bkBrief], [bkStatus], [bkCover]) VALUES (2, N'015', N'2015', N'2015', N'2015', CAST(0xEA390B00 AS Date), N'2', N'20', 0, 4, 45.0000, CAST(0x3E3C0B00 AS Date), N'1111', N'在馆', N'2015.jpg')
INSERT [dbo].[TB_Book] ([bkID], [bkCode], [bkName], [bkAuthor], [bkPress], [bkDatePress], [bkISBN], [bkCatalog], [bkLanguage], [bkPages], [bkPrice], [bkDateIn], [bkBrief], [bkStatus], [bkCover]) VALUES (3, N'015', N'2015', N'2015', N'2015', CAST(0xEA390B00 AS Date), N'2', N'20', 0, 4, 45.0000, CAST(0x3E3C0B00 AS Date), N'1111', N'在馆', N'2015.jpg')
INSERT [dbo].[TB_Book] ([bkID], [bkCode], [bkName], [bkAuthor], [bkPress], [bkDatePress], [bkISBN], [bkCatalog], [bkLanguage], [bkPages], [bkPrice], [bkDateIn], [bkBrief], [bkStatus], [bkCover]) VALUES (4, N'2016', N'2016', N'2016', N'2016', CAST(0x593B0B00 AS Date), N'206', N'20', 0, 45, 18.0000, CAST(0x433C0B00 AS Date), N'22222', N'在馆', N'2016.jpg')
SET IDENTITY_INSERT [dbo].[TB_Book] OFF
SET IDENTITY_INSERT [dbo].[TB_Borrow] ON 

INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(1 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E600000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(2 AS Numeric(12, 0)), 1, 3, 3, CAST(0x0000A6E600000000 AS DateTime), CAST(0x0000A7D800000000 AS DateTime), CAST(0x0000A6E800000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, NULL)
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(3 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E700000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(4 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E700000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(5 AS Numeric(12, 0)), 1, 3, 3, CAST(0x0000A6E700000000 AS DateTime), CAST(0x0000A7D800000000 AS DateTime), CAST(0x0000A6E800000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, NULL)
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(6 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E700000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(7 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E700000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(8 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E700000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(9 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E700000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(10 AS Numeric(12, 0)), 1, 3, 3, CAST(0x0000A6E700000000 AS DateTime), CAST(0x0000A7D800000000 AS DateTime), CAST(0x0000A6E800000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, NULL)
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(11 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(12 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(13 AS Numeric(12, 0)), 1, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(14 AS Numeric(12, 0)), 2, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(15 AS Numeric(12, 0)), 2, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(16 AS Numeric(12, 0)), 2, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(17 AS Numeric(12, 0)), 2, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(18 AS Numeric(12, 0)), 2, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(19 AS Numeric(12, 0)), 2, 3, 3, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A7D800000000 AS DateTime), CAST(0x0000A6E800000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, NULL)
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(20 AS Numeric(12, 0)), 2, 3, 3, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A7D800000000 AS DateTime), CAST(0x0000A6E800000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, NULL)
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(21 AS Numeric(12, 0)), 2, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(22 AS Numeric(12, 0)), 2, 2, 2, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A79C00000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(23 AS Numeric(12, 0)), 2, 2, 0, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A72400000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(24 AS Numeric(12, 0)), 2, 2, 0, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A72400000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(25 AS Numeric(12, 0)), 2, 2, 0, CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A72400000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, NULL, N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(26 AS Numeric(12, 0)), 1, 2, 0, CAST(0x0000A6E900000000 AS DateTime), CAST(0x0000A72500000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, N'1', N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(27 AS Numeric(12, 0)), 1, 1, 1, CAST(0x0000A6E900000000 AS DateTime), CAST(0x0000A76100000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, N'1', N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(28 AS Numeric(12, 0)), 1, 1, 0, CAST(0x0000A6E900000000 AS DateTime), CAST(0x0000A6E800000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, N'1', N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(29 AS Numeric(12, 0)), 1, 1, 0, CAST(0x0000A6E900000000 AS DateTime), CAST(0x0000A72500000000 AS DateTime), CAST(0x0000A6E900000000 AS DateTime), 0, 0.0000, NULL, 1, N'1', N'1')
INSERT [dbo].[TB_Borrow] ([borrowID], [rdID], [bkID], [idContinueTimes], [idDateOut], [idDateRetPlan], [idDateRetAct], [idOverDay], [idOverMoney], [idPunishMoney], [isHasReturn], [operatorLend], [operatorRet]) VALUES (CAST(30 AS Numeric(12, 0)), 1, 1, 0, CAST(0x0000A6E900000000 AS DateTime), CAST(0x0000A72500000000 AS DateTime), NULL, NULL, NULL, NULL, 0, N'1', NULL)
SET IDENTITY_INSERT [dbo].[TB_Borrow] OFF
INSERT [dbo].[TB_Reader] ([rdID], [rdName], [rdSex], [rdType], [rdDept], [rdPhone], [rdEmail], [rdDateReg], [rdStatus], [rdBorrowQty], [rdPwd], [rdAdminRoles], [rdPhoto]) VALUES (1, N'李明', N'男', 10, N'计算机学院', N'135135135135', N'135135135135@gmail.com', CAST(0x433C0B00 AS Date), N'有效', 1, N'1234', 0, N'1.jpg')
INSERT [dbo].[TB_Reader] ([rdID], [rdName], [rdSex], [rdType], [rdDept], [rdPhone], [rdEmail], [rdDateReg], [rdStatus], [rdBorrowQty], [rdPwd], [rdAdminRoles], [rdPhoto]) VALUES (2, N'天命', N'男', 10, N'计算机学院', N'11111', N'11111', CAST(0x433C0B00 AS Date), N'有效', 0, N'123', 1, N'2.jpg')
INSERT [dbo].[TB_Reader] ([rdID], [rdName], [rdSex], [rdType], [rdDept], [rdPhone], [rdEmail], [rdDateReg], [rdStatus], [rdBorrowQty], [rdPwd], [rdAdminRoles], [rdPhoto]) VALUES (3, N'3', N'女', 20, N'计算机学院', N'111', N'1111', CAST(0x493C0B00 AS Date), N'有效', 0, N'123', 2, N'3.jpg')
INSERT [dbo].[TB_Reader] ([rdID], [rdName], [rdSex], [rdType], [rdDept], [rdPhone], [rdEmail], [rdDateReg], [rdStatus], [rdBorrowQty], [rdPwd], [rdAdminRoles], [rdPhoto]) VALUES (4, N'4', N'女', 30, N'计算机学院', N'1111', N'111', CAST(0x493C0B00 AS Date), N'有效', 0, N'123', 3, N'4.jpg')
INSERT [dbo].[TB_Reader] ([rdID], [rdName], [rdSex], [rdType], [rdDept], [rdPhone], [rdEmail], [rdDateReg], [rdStatus], [rdBorrowQty], [rdPwd], [rdAdminRoles], [rdPhoto]) VALUES (5, N'5', N'男', 20, N'计算机学院', N'222', N'222', CAST(0x493C0B00 AS Date), N'有效', 0, N'123', 4, N'5.jpg')
INSERT [dbo].[TB_ReaderType] ([rdType], [rdTypeName], [canLendQty], [canLendDay], [canContinueTimes], [punishRate], [dateValid]) VALUES (10, N'教师', 12, 60, 2, CAST(0.05 AS Numeric(18, 2)), 0)
INSERT [dbo].[TB_ReaderType] ([rdType], [rdTypeName], [canLendQty], [canLendDay], [canContinueTimes], [punishRate], [dateValid]) VALUES (20, N'本科生', 8, 30, 1, CAST(0.05 AS Numeric(18, 2)), 4)
INSERT [dbo].[TB_ReaderType] ([rdType], [rdTypeName], [canLendQty], [canLendDay], [canContinueTimes], [punishRate], [dateValid]) VALUES (21, N'专科生', 8, 30, 1, CAST(0.05 AS Numeric(18, 2)), 3)
INSERT [dbo].[TB_ReaderType] ([rdType], [rdTypeName], [canLendQty], [canLendDay], [canContinueTimes], [punishRate], [dateValid]) VALUES (30, N'硕士研究生', 8, 30, 1, CAST(0.05 AS Numeric(18, 2)), 3)
INSERT [dbo].[TB_ReaderType] ([rdType], [rdTypeName], [canLendQty], [canLendDay], [canContinueTimes], [punishRate], [dateValid]) VALUES (31, N'博士研究生', 8, 30, 1, CAST(0.05 AS Numeric(18, 2)), 4)
SET ANSI_PADDING ON

GO
/****** Object:  Index [uq_tn]    Script Date: 2017.1.1.星期日 03:31:48 ******/
ALTER TABLE [dbo].[TB_ReaderType] ADD  CONSTRAINT [uq_tn] UNIQUE NONCLUSTERED 
(
	[rdTypeName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[TB_Borrow] ADD  CONSTRAINT [DF__TB_Borrow__IsHas__1ED998B2]  DEFAULT ((0)) FOR [isHasReturn]
GO
ALTER TABLE [dbo].[TB_Reader] ADD  CONSTRAINT [DF__TB_Reader__rdBor__164452B1]  DEFAULT ((0)) FOR [rdBorrowQty]
GO
ALTER TABLE [dbo].[TB_Reader] ADD  CONSTRAINT [DF__TB_Reader__rdPwd__173876EA]  DEFAULT ('123') FOR [rdPwd]
GO
ALTER TABLE [dbo].[TB_Borrow]  WITH CHECK ADD  CONSTRAINT [FK__TB_Borrow__bkID__1DE57479] FOREIGN KEY([bkID])
REFERENCES [dbo].[TB_Book] ([bkID])
GO
ALTER TABLE [dbo].[TB_Borrow] CHECK CONSTRAINT [FK__TB_Borrow__bkID__1DE57479]
GO
ALTER TABLE [dbo].[TB_Borrow]  WITH CHECK ADD  CONSTRAINT [FK__TB_Borrow__rdID__1CF15040] FOREIGN KEY([rdID])
REFERENCES [dbo].[TB_Reader] ([rdID])
GO
ALTER TABLE [dbo].[TB_Borrow] CHECK CONSTRAINT [FK__TB_Borrow__rdID__1CF15040]
GO
ALTER TABLE [dbo].[TB_Reader]  WITH CHECK ADD  CONSTRAINT [FK__TB_Reader__rdTyp__145C0A3F] FOREIGN KEY([rdType])
REFERENCES [dbo].[TB_ReaderType] ([rdType])
GO
ALTER TABLE [dbo].[TB_Reader] CHECK CONSTRAINT [FK__TB_Reader__rdTyp__145C0A3F]
GO
ALTER TABLE [dbo].[TB_Book]  WITH CHECK ADD  CONSTRAINT [CK__TB_Book__bkStatu__1A14E395] CHECK  (([bkStatus]='销毁' OR [bkStatus]='变卖' OR [bkStatus]='遗失' OR [bkStatus]='借出' OR [bkStatus]='在馆'))
GO
ALTER TABLE [dbo].[TB_Book] CHECK CONSTRAINT [CK__TB_Book__bkStatu__1A14E395]
GO
ALTER TABLE [dbo].[TB_Reader]  WITH CHECK ADD  CONSTRAINT [CK__TB_Reader__rdSex__1367E606] CHECK  (([rdSex]='女' OR [rdSex]='男'))
GO
ALTER TABLE [dbo].[TB_Reader] CHECK CONSTRAINT [CK__TB_Reader__rdSex__1367E606]
GO
ALTER TABLE [dbo].[TB_Reader]  WITH CHECK ADD  CONSTRAINT [CK__TB_Reader__rdSta__15502E78] CHECK  (([rdStatus]='注销' OR [rdStatus]='挂失' OR [rdStatus]='有效'))
GO
ALTER TABLE [dbo].[TB_Reader] CHECK CONSTRAINT [CK__TB_Reader__rdSta__15502E78]
GO
