USE master
IF EXISTS(SELECT * FROM SYS.databaseS WHERE name='ASMSOF302')DROP DATABASE ASMSOF302
GO
--tao database 
CREATE DATABASE ASMSOF302
GO 
USE ASMSOF302
GO
/****Table [dbo].[PhongBan]****/
CREATE TABLE [dbo].[PhongBan](
	[MaPB] [varchar](10) primary key NOT NULL,
	[TenPB] [varchar](50) NOT NULL
	)
	go
INSERT INTO[dbo].[PhongBan] ([MaPB], [TenPB]) VALUES (N'CSKH', N'Phong cham soc khach hang')
go
INSERT INTO[dbo].[PhongBan] ([MaPB], [TenPB]) VALUES (N'HC', N'phong Hanh chinh')
go
INSERT INTO[dbo].[PhongBan] ([MaPB], [TenPB]) VALUES (N'IT', N'Phong IT')
go
INSERT INTO[dbo].[PhongBan] ([MaPB], [TenPB]) VALUES (N'KT', N'Phong Ke toan')
go
/****Table [dbo].[NhanVien]****/
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [int] identity primary key,
	[TenNV] [varchar](50) NOT NULL,
	[Gioitinh] [bit] NOT NULL,
	[NgaySinh] [date] NULL,
	[Hinh] [varchar](50) NULL,
	[Email] [varchar](50) NULL,
	[SDT] [varchar](25) NOT NULL,
	[Luong] [float] NOT NULL,
	[Ghichu] [varchar](500) NULL,
	[Capdo] [bit] NOT NULL
	)
	go

/****Table [dbo].[Users]****/
CREATE TABLE [dbo].[Users](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Fullname] [varchar](50) NOT NULL
	)
	go

INSERT INTO[dbo].[Users] ([Username], [Password], [Fullname])
 VALUES (N'vanquang1', N'123', N'Nguyen Van Quang')
 go
INSERT INTO[dbo].[Users] ([Username], [Password], [Fullname])
 VALUES (N'hoanghai', N'abc', N'Truong Hoang Hai')
 go
INSERT INTO[dbo].[Users] ([Username], [Password], [Fullname])
 VALUES (N'minhhieu', N'321', N'Nguyen Minh Hieu')
 go
INSERT INTO[dbo].[Users] ([Username], [Password], [Fullname])
 VALUES (N'huubien', N'123', N'Dang Huu Bien')
 go
INSERT INTO[dbo].[Users] ([Username], [Password], [Fullname])
 VALUES (N'banguyen', N'123', N'Nguyen Ba Nguyen')
 go
INSERT INTO[dbo].[Users] ([Username], [Password], [Fullname])
 VALUES (N'quynhvy', N'abc', N'Tran Quynh Vy')
 go
INSERT INTO[dbo].[Users] ([Username], [Password], [Fullname]) 
VALUES (N'ngoctuyen', N'abc', N'Tran Thi Ngoc Tuyen')
go
INSERT INTO[dbo].[Users] ([Username], [Password], [Fullname]) 
VALUES (N'thanhtu', N'123', N'Nguyen Thanh Tu')
go
INSERT INTO[dbo].[Users] ([Username], [Password], [Fullname]) 
VALUES (N'nhuquynh', N'321', N'Duong Vu Nhu Quynh')
go