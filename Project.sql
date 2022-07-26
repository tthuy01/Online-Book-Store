USE [PROJECT_PRJ301]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 3/24/2022 11:07:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[MaTaiKhoan] [int] NULL,
	[SDTNguoiNhan] [nvarchar](24) NULL,
	[TongTien] [money] NULL,
	[DiaChiShip] [nvarchar](100) NULL,
	[NgayDatHang] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 3/24/2022 11:07:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[MaHoaDon] [int] NOT NULL,
	[MaSach] [int] NOT NULL,
	[SoLuong] [int] NULL,
	[Gia] [money] NULL,
 CONSTRAINT [pk_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC,
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NXB]    Script Date: 3/24/2022 11:07:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NXB](
	[MaNXB] [varchar](10) NOT NULL,
	[TenNXB] [nvarchar](100) NULL,
	[DiaChi] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNXB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanQuyen]    Script Date: 3/24/2022 11:07:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanQuyen](
	[MaPhanQuyen] [bit] NOT NULL,
	[TenQuyen] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhanQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 3/24/2022 11:07:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[MaSach] [int] IDENTITY(1,1) NOT NULL,
	[TenSach] [nvarchar](100) NULL,
	[Anh] [nvarchar](255) NULL,
	[MaTheLoai] [varchar](10) NULL,
	[MaTacGia] [int] NULL,
	[MaNXB] [varchar](10) NULL,
	[NgayXB] [datetime] NULL,
	[Gia] [money] NULL,
	[SoLuongTonKho] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TacGia]    Script Date: 3/24/2022 11:07:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TacGia](
	[MaTacGia] [int] IDENTITY(1,1) NOT NULL,
	[TenTacGia] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [datetime] NULL,
	[DiaChi] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTacGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 3/24/2022 11:07:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaTaiKhoan] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [datetime] NULL,
	[SDT] [nvarchar](24) NULL,
	[Email] [varchar](100) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[TenDangNhap] [varchar](20) NULL,
	[MatKhau] [varchar](20) NULL,
	[MaPhanQuyen] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TheLoai]    Script Date: 3/24/2022 11:07:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TheLoai](
	[MaTheLoai] [varchar](10) NOT NULL,
	[TheLoai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTheLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1, 2, N'012345678', 76200.0000, N'Thái Nguyên', CAST(N'2022-02-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (2, 3, N'012345678', 465000.0000, N'Thái Nguyên', CAST(N'2022-02-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (3, 4, N'012345678', 550000.0000, N'Thái Nguyên', CAST(N'2022-02-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (4, 5, N'012345678', 178000.0000, N'Thái Nguyên', CAST(N'2022-02-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (5, 2, N'012345678', 76200.0000, N'Thái Nguyên', CAST(N'2022-02-20T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (6, 2, N'012345678', 183600.0000, N'Thái Nguyên', CAST(N'2022-03-16T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (7, 2, N'012345678', 534000.0000, N'Hà Nội', CAST(N'2022-03-16T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (8, 2, N'012345678', 195800.0000, N'Thái Bình', CAST(N'2022-03-16T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (9, 6, N'012345678', 20000.0000, N'Hà Nội', CAST(N'2022-03-16T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (10, 2, N'012345678', 449000.0000, N'Thái Nguyên', CAST(N'2022-03-16T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (11, 4, N'012345678', 422900.0000, N'Thái Nguyên', CAST(N'2022-03-16T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (12, 2, N'0123456780', 20000.0000, N'Thái Nguyên', CAST(N'2022-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (13, 2, N'0123456780', 61200.0000, N'Thái Nguyên', CAST(N'2022-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (14, 2, N'0123456780', 97900.0000, N'Thái Nguyên', CAST(N'2022-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (15, 2, N'0123456780', 178000.0000, N'Thái Nguyên', CAST(N'2022-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (16, 2, N'0123456780', 178000.0000, N'Thái Nguyên', CAST(N'2022-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (17, 2, N'012345678', 20000.0000, N'Thái Nguyên', CAST(N'2022-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (18, 6, N'012345678', 180000.0000, N'Thái Nguyên', CAST(N'2022-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (19, 2, N'012345678', 38000.0000, N'Thái Nguyên', CAST(N'2022-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (20, 2, N'012345678', 61200.0000, N'Thái Nguyên', CAST(N'2022-03-17T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1002, 2, N'012345678', 76200.0000, N'Thái Nguyên', CAST(N'2022-01-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1003, 3, N'012345678', 465000.0000, N'Thái Nguyên', CAST(N'2022-01-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1004, 4, N'012345678', 550000.0000, N'Thái Nguyên', CAST(N'2022-01-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1005, 5, N'012345678', 178000.0000, N'Thái Nguyên', CAST(N'2022-01-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1006, 2, N'012345678', 76200.0000, N'Thái Nguyên', CAST(N'2022-01-20T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1007, 2, N'012345678', 76200.0000, N'Thái Nguyên', CAST(N'2021-12-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1008, 3, N'012345678', 465000.0000, N'Thái Nguyên', CAST(N'2021-12-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1009, 4, N'012345678', 550000.0000, N'Thái Nguyên', CAST(N'2021-12-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1010, 2, N'012345678', 76200.0000, N'Thái Nguyên', CAST(N'2021-11-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1011, 3, N'012345678', 465000.0000, N'Thái Nguyên', CAST(N'2021-11-14T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1012, 2, N'012345678', 5835000.0000, N'Thái Nguyên', CAST(N'2022-03-22T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1013, 6, N'012345678', 300000.0000, N'Thái Nguyên', CAST(N'2022-03-22T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1015, 2, N'012345678', 61200.0000, N'Thái Nguyên', CAST(N'2022-03-24T00:00:00.000' AS DateTime))
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaTaiKhoan], [SDTNguoiNhan], [TongTien], [DiaChiShip], [NgayDatHang]) VALUES (1016, 2, N'012345678', 61200.0000, N'Thái Nguyên', CAST(N'2022-03-24T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1, 1, 1, 61200.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1, 8, 1, 10000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1, 9, 1, 5000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (2, 3, 1, 135000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (2, 4, 1, 150000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (2, 5, 1, 180000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (3, 6, 1, 550000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (4, 14, 1, 178000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (5, 14, 1, 178000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (6, 1, 3, 61200.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (7, 14, 3, 178000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (8, 2, 2, 97900.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (9, 17, 1, 20000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (10, 12, 1, 250000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (10, 13, 1, 199000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (11, 2, 1, 97900.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (11, 3, 1, 135000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (11, 4, 1, 150000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (11, 16, 1, 20000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (11, 17, 1, 20000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (12, 17, 1, 20000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (13, 1, 1, 61200.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (14, 2, 1, 97900.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (15, 14, 1, 178000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (16, 14, 1, 178000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (17, 17, 1, 20000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (18, 5, 1, 180000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (19, 10, 1, 38000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (20, 1, 1, 61200.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1002, 1, 1, 61200.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1002, 8, 1, 10000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1002, 9, 1, 5000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1003, 3, 1, 135000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1003, 4, 1, 150000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1003, 5, 1, 180000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1004, 6, 1, 550000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1005, 14, 1, 178000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1006, 14, 1, 178000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1007, 1, 1, 61200.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1007, 8, 1, 10000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1007, 9, 1, 5000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1008, 3, 1, 135000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1008, 4, 1, 150000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1008, 5, 1, 180000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1009, 6, 1, 550000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1010, 1, 1, 61200.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1010, 8, 1, 10000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1010, 9, 1, 5000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1011, 3, 1, 135000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1011, 4, 1, 150000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1011, 5, 1, 180000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1012, 3, 9, 135000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1012, 4, 9, 150000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1012, 5, 9, 180000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1012, 6, 3, 550000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1013, 16, 9, 20000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1013, 17, 6, 20000.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1015, 1, 1, 61200.0000)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaSach], [SoLuong], [Gia]) VALUES (1016, 1, 1, 61200.0000)
GO
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'DHQGHN', N'Nhà xuất Đại học Quốc gia Hà Nội', N'16 Hàng Chuối, Hai Bà Trưng, Hà Nội')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'DN', N'Nhà xuất Đà Nẵng', N'Số 3 đường 30 tháng 4, P.Hòa Cường Bắc, Q.Hải Châu, TP.Đà Nẵng')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'GD', N'Nhà xuất bản Giáo dục Việt Nam', N'Số 81 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'HN', N'Nhà xuất bản Hà Nội', N' Số 4, Tống Duy Tân, Hà Nội')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'KD', N'Nhà xuất Kim Đồng', N'Số 55 Quang Trung, Nguyễn Du, Hai Bà Trưng, Hà Nội')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'MT', N'Nhà xuất Mỹ thuật', N'44B Hàm long, Quận Hoàn Kiếm, Hà Nội')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'T', N'Nhà xuất bản Trẻ', N'Số 21 Dãy A11 Khu Đô thị Đầm Trấu, phường Bạch Đằng, quận Hai Bà Trưng, Hà Nội')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'VH', N'Nhà xuất Văn học', N'18 Nguyễn Trường Tộ - Ba Đình - Hà Nội')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [DiaChi]) VALUES (N'VHDT', N'Nhà xuất Văn hóa Dân tộc', N'Số 19 Nguyễn Bỉnh Khiêm,Quận Hai Bà Trưng,TP. Hà Nội')
GO
INSERT [dbo].[PhanQuyen] ([MaPhanQuyen], [TenQuyen]) VALUES (0, N'Khách hàng')
INSERT [dbo].[PhanQuyen] ([MaPhanQuyen], [TenQuyen]) VALUES (1, N'Quản lý')
GO
SET IDENTITY_INSERT [dbo].[Sach] ON 

INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (1, N'Búp sen xanh', N'images/sbsx.jpg', N'VHVN', 1, N'KD', CAST(N'2020-05-13T00:00:00.000' AS DateTime), 61200.0000, 23)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (2, N'Tuổi thơ dữ dội', N'images/sttdd.jpg', N'VHVN', 2, N'VH', NULL, 97900.0000, 26)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (3, N'Harry Potter và hòn đá phù thủy', N'images/shp1.jpg', N'VHNN', 3, N'T', CAST(N'2017-02-27T00:00:00.000' AS DateTime), 135000.0000, 20)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (4, N'Harry Potter và phòng chứa bí mật', N'images/shp2.jpg', N'VHNN', 3, N'T', CAST(N'2017-02-27T00:00:00.000' AS DateTime), 150000.0000, 20)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (5, N'Harry Potter và tên tù nhân ngục Azkaban', N'images/shp3.jpg', N'VHNN', 3, N'T', CAST(N'2017-02-27T00:00:00.000' AS DateTime), 180000.0000, 20)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (6, N'Hợp tuyển truyện cổ tích Việt Nam', N'images/scotich.jpg', N'STN', 4, N'VH', NULL, 550000.0000, 27)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (7, N'Cô bé lọ lem', N'images/scbll.jpg', N'STN', 5, N'MT', CAST(N'2017-04-08T00:00:00.000' AS DateTime), 51500.0000, 30)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (8, N'Đại số 10', N'images/sds10.jpg', N'SGK', 6, N'GD', NULL, 10000.0000, 30)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (9, N'Tin học 10', N'images/sth10.jpg', N'SGK', 6, N'GD', NULL, 5000.0000, 30)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (10, N'Giúp trí nhớ Chuỗi phản ứng hóa học', N'images/scpuhh.jpg', N'STK', 7, N'DHQGHN', NULL, 38000.0000, 29)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (11, N'Bài tập Tiếng Anh 10 (Có đáp án)', N'images/sbtta10.jpg', N'STK', 8, N'DN', CAST(N'2018-08-01T00:00:00.000' AS DateTime), 56000.0000, 30)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (12, N'Đột phá 8+ môn toán tập 1', N'images/dpt1.jpg', N'LTDH', 9, N'DHQGHN', CAST(N'2018-07-01T00:00:00.000' AS DateTime), 250000.0000, 29)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (13, N'Đột phá 8+ môn toán tập 2', N'images/dpt2.jpg', N'LTDH', 9, N'DHQGHN', CAST(N'2018-07-01T00:00:00.000' AS DateTime), 199000.0000, 29)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (14, N'Điều tuyệt vời nhất của chúng ta (Trọn bộ)', N'images/sdtvncct.jpg', N'TNT', 10, N'HN', NULL, 178000.0000, 25)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (15, N'Yêu em từ cái nhìn đầu tiên', N'images/syetcndt.jpg', N'TNT', 11, N'VH', CAST(N'2016-02-23T00:00:00.000' AS DateTime), 106000.0000, 30)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (16, N'Thám tử lừng danh Conan tập 99', N'images/sconan99.jpg', N'TT', 12, N'KD', NULL, 20000.0000, 20)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [Anh], [MaTheLoai], [MaTacGia], [MaNXB], [NgayXB], [Gia], [SoLuongTonKho]) VALUES (17, N'Thám tử lừng danh Conan tập 98', N'images/sconan98.jpg', N'TT', 12, N'KD', NULL, 20000.0000, 20)
SET IDENTITY_INSERT [dbo].[Sach] OFF
GO
SET IDENTITY_INSERT [dbo].[TacGia] ON 

INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (1, N'Sơn Tùng', 0, CAST(N'1928-07-22T00:00:00.000' AS DateTime), N'Ngõ Văn Chương, Hà Nội')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (2, N'Phùng Quán', 0, NULL, N'Xã Thủy Dương, huyện Hương Thủy, tỉnh Thừa Thiên Huế')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (3, N'J.K Rowling', 1, CAST(N'1965-07-31T00:00:00.000' AS DateTime), N'Anh')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (4, N'Lữ Huy Nguyên', 0, NULL, NULL)
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (5, N'Stefania Leonardi Hartley', 1, NULL, NULL)
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (6, N'Bộ Giáo dục và Đào tạo', NULL, NULL, N'Số 35 Đại Cồ Việt, Hà Nội')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (7, N'Ngô Ngọc An', NULL, NULL, NULL)
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (8, N'Mai Lan Hương', 1, NULL, N'Hà Nội')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (9, N'Lê Phương Anh', NULL, NULL, NULL)
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (10, N'Bát Nguyệt Trường An', 1, CAST(N'1987-09-12T00:00:00.000' AS DateTime), N'Cáp Nhĩ Tân, Trung Quốc')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (11, N'Cố Mạn', 1, CAST(N'1981-10-21T00:00:00.000' AS DateTime), N'Giang Tô, Trung Quốc')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (12, N'Gosho Aoyama', 0, CAST(N'1963-06-21T00:00:00.000' AS DateTime), N'Hokuei, tỉnh Tottori, Nhật Bản')
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (13, N'Đặng Văn Lung', 0, NULL, NULL)
INSERT [dbo].[TacGia] ([MaTacGia], [TenTacGia], [GioiTinh], [NgaySinh], [DiaChi]) VALUES (14, N'Nguyễn Thanh Loan', 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[TacGia] OFF
GO
SET IDENTITY_INSERT [dbo].[TaiKhoan] ON 

INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [Ten], [GioiTinh], [NgaySinh], [SDT], [Email], [DiaChi], [TenDangNhap], [MatKhau], [MaPhanQuyen]) VALUES (1, N'Nguyễn Thị Thúy Quỳnh', 1, CAST(N'2001-02-14T00:00:00.000' AS DateTime), N'012345678', N'admin@gmail.com', N'Thái Nguyên', N'admin', N'123456', 1)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [Ten], [GioiTinh], [NgaySinh], [SDT], [Email], [DiaChi], [TenDangNhap], [MatKhau], [MaPhanQuyen]) VALUES (2, N'Trần Thị Thanh Thùy', 1, CAST(N'2001-10-03T00:00:00.000' AS DateTime), N'012345678', N'thuytran01@mail.com', N'Thái Nguyên', N'thuytran01', N'123456', 0)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [Ten], [GioiTinh], [NgaySinh], [SDT], [Email], [DiaChi], [TenDangNhap], [MatKhau], [MaPhanQuyen]) VALUES (3, N'Ngô Thu Hiền', 1, CAST(N'2001-10-08T00:00:00.000' AS DateTime), N'012345678', N'hienngo@gmail.com', N'Thái Nguyên', N'hienngo01', N'123456', 0)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [Ten], [GioiTinh], [NgaySinh], [SDT], [Email], [DiaChi], [TenDangNhap], [MatKhau], [MaPhanQuyen]) VALUES (4, N'Trần Văn Đông', 0, CAST(N'2001-06-30T00:00:00.000' AS DateTime), N'012345678', N'dongtran@gmail.com', N'Hà Nội', N'dongtran01', N'123456', 0)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [Ten], [GioiTinh], [NgaySinh], [SDT], [Email], [DiaChi], [TenDangNhap], [MatKhau], [MaPhanQuyen]) VALUES (5, N'Phạm Minh Đức', 0, CAST(N'2001-11-02T00:00:00.000' AS DateTime), N'012345678', N'ducpham@gmail.com', N'Thái Nguyên', N'ducpham01', N'123456', 0)
INSERT [dbo].[TaiKhoan] ([MaTaiKhoan], [Ten], [GioiTinh], [NgaySinh], [SDT], [Email], [DiaChi], [TenDangNhap], [MatKhau], [MaPhanQuyen]) VALUES (6, N'Bùi Thanh Xuân', 1, CAST(N'2001-05-18T00:00:00.000' AS DateTime), N'012345678', N'xuanbui@gmail.com', N'Thái Nguyên', N'xuanbui01', N'123456', 0)
SET IDENTITY_INSERT [dbo].[TaiKhoan] OFF
GO
INSERT [dbo].[TheLoai] ([MaTheLoai], [TheLoai]) VALUES (N'LTDH', N'Sách luyện thi đại học')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TheLoai]) VALUES (N'SGK', N'Sách giáo khoa')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TheLoai]) VALUES (N'STK', N'Sách tham khảo')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TheLoai]) VALUES (N'STN', N'Sách dành cho thiếu nhi')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TheLoai]) VALUES (N'TNT', N'Truyện ngôn tình')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TheLoai]) VALUES (N'TT', N'Truyện tranh')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TheLoai]) VALUES (N'VHNN', N'Văn học nước ngoài')
INSERT [dbo].[TheLoai] ([MaTheLoai], [TheLoai]) VALUES (N'VHVN', N'Văn học Việt Nam')
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [fk_HoaDon_TaiKhoan] FOREIGN KEY([MaTaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([MaTaiKhoan])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [fk_HoaDon_TaiKhoan]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [fk_HoaDonChiTiet_HoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [fk_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [fk_HoaDonChiTiet_Sach] FOREIGN KEY([MaSach])
REFERENCES [dbo].[Sach] ([MaSach])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [fk_HoaDonChiTiet_Sach]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [fk_NXB_Sach] FOREIGN KEY([MaNXB])
REFERENCES [dbo].[NXB] ([MaNXB])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [fk_NXB_Sach]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [fk_TacGia_Sach] FOREIGN KEY([MaTacGia])
REFERENCES [dbo].[TacGia] ([MaTacGia])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [fk_TacGia_Sach]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [fk_TheLoai_Sach] FOREIGN KEY([MaTheLoai])
REFERENCES [dbo].[TheLoai] ([MaTheLoai])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [fk_TheLoai_Sach]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [fk_PhanQuyen_TaiKhoan] FOREIGN KEY([MaPhanQuyen])
REFERENCES [dbo].[PhanQuyen] ([MaPhanQuyen])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [fk_PhanQuyen_TaiKhoan]
GO
