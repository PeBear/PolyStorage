CREATE DATABASE  IF NOT EXISTS `polystorage` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `polystorage`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: polystorage
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chitietdonnhap`
--

DROP TABLE IF EXISTS `chitietdonnhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdonnhap` (
  `MaDN` int(11) NOT NULL,
  `MaSP` char(10) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  PRIMARY KEY (`MaDN`,`MaSP`),
  KEY `FK_ChiTietDonNhap_SanPham` (`MaSP`),
  CONSTRAINT `FK_ChiTietDonNhap_DonNhap` FOREIGN KEY (`MaDN`) REFERENCES `donnhap` (`MaDN`) ON UPDATE CASCADE,
  CONSTRAINT `FK_ChiTietDonNhap_SanPham` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdonnhap`
--

LOCK TABLES `chitietdonnhap` WRITE;
/*!40000 ALTER TABLE `chitietdonnhap` DISABLE KEYS */;
INSERT INTO `chitietdonnhap` VALUES (1,'SP1',50),(1,'SP2',50),(1,'SP3',50),(1,'SP4',50),(1,'SP5',50),(2,'SP10',10),(2,'SP6',50),(2,'SP7',50),(2,'SP8',10),(2,'SP9',10);
/*!40000 ALTER TABLE `chitietdonnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietdonxuat`
--

DROP TABLE IF EXISTS `chitietdonxuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdonxuat` (
  `MaDX` int(11) NOT NULL,
  `MaSP` char(10) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  PRIMARY KEY (`MaDX`,`MaSP`),
  KEY `FK_ChiTietDonXuat_SanPham` (`MaSP`),
  CONSTRAINT `FK_ChiTietDonXuat_DonXuat` FOREIGN KEY (`MaDX`) REFERENCES `donxuat` (`MaDX`) ON UPDATE CASCADE,
  CONSTRAINT `FK_ChiTietDonXuat_SanPham` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdonxuat`
--

LOCK TABLES `chitietdonxuat` WRITE;
/*!40000 ALTER TABLE `chitietdonxuat` DISABLE KEYS */;
INSERT INTO `chitietdonxuat` VALUES (1,'SP1',10),(1,'SP4',10),(2,'SP5',6),(2,'SP7',4),(3,'SP1',5),(3,'SP6',2),(4,'SP1',5),(4,'SP4',5),(4,'SP5',5);
/*!40000 ALTER TABLE `chitietdonxuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietkho`
--

DROP TABLE IF EXISTS `chitietkho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietkho` (
  `MaKho` char(10) NOT NULL,
  `MaSP` char(10) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  PRIMARY KEY (`MaKho`,`MaSP`),
  KEY `FK_ChiTietKho_SanPham` (`MaSP`),
  CONSTRAINT `FK_ChiTietKho_Kho` FOREIGN KEY (`MaKho`) REFERENCES `kho` (`MaKho`) ON UPDATE CASCADE,
  CONSTRAINT `FK_ChiTietKho_SanPham` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietkho`
--

LOCK TABLES `chitietkho` WRITE;
/*!40000 ALTER TABLE `chitietkho` DISABLE KEYS */;
INSERT INTO `chitietkho` VALUES ('KHO01','SP1',200),('KHO01','SP10',20),('KHO01','SP2',200),('KHO01','SP3',100),('KHO01','SP4',100),('KHO01','SP5',100),('KHO01','SP6',100),('KHO01','SP7',100),('KHO01','SP8',20),('KHO01','SP9',20);
/*!40000 ALTER TABLE `chitietkho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donnhap`
--

DROP TABLE IF EXISTS `donnhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donnhap` (
  `MaDN` int(11) NOT NULL AUTO_INCREMENT,
  `MaNV` char(10) NOT NULL,
  `NgayNhap` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `TrangThai` bit(1) NOT NULL DEFAULT b'0',
  `MaKho` char(10) NOT NULL,
  `MaNCC` char(10) NOT NULL,
  `GhiChu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaDN`),
  KEY `FK_DonNhap_Kho` (`MaKho`),
  KEY `FK_DonNhap_NhanVien` (`MaNV`),
  KEY `FK_DonNhap_NhaCungCap` (`MaNCC`),
  CONSTRAINT `FK_DonNhap_Kho` FOREIGN KEY (`MaKho`) REFERENCES `kho` (`MaKho`) ON UPDATE CASCADE,
  CONSTRAINT `FK_DonNhap_NhaCungCap` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON UPDATE CASCADE,
  CONSTRAINT `FK_DonNhap_NhanVien` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donnhap`
--

LOCK TABLES `donnhap` WRITE;
/*!40000 ALTER TABLE `donnhap` DISABLE KEYS */;
INSERT INTO `donnhap` VALUES (1,'ADMIN','2019-10-10 00:00:00',_binary '','KHO01','NCC1',NULL),(2,'ADMIN','2019-10-10 00:00:00',_binary '','KHO01','NCC2',NULL),(3,'ADMIN','2019-10-10 00:00:00',_binary '','KHO01','NCC3',NULL),(4,'ADMIN','2019-10-10 00:00:00',_binary '','KHO01','NCC4',NULL),(5,'ADMIN','2019-10-10 00:00:00',_binary '','KHO01','NCC1',NULL),(6,'ADMIN','2019-10-10 00:00:00',_binary '','KHO01','NCC2',NULL),(7,'ADMIN','2019-11-01 00:00:00',_binary '','KHO01','NCC3',NULL),(8,'ADMIN','2019-11-01 00:00:00',_binary '','KHO01','NCC4',NULL),(9,'ADMIN','2019-11-10 00:00:00',_binary '\0','KHO01','NCC2',NULL),(10,'ADMIN','2019-11-10 00:00:00',_binary '\0','KHO01','NCC1',NULL);
/*!40000 ALTER TABLE `donnhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donxuat`
--

DROP TABLE IF EXISTS `donxuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donxuat` (
  `MaDX` int(11) NOT NULL AUTO_INCREMENT,
  `MaNV` char(10) NOT NULL,
  `NgayXuat` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `TrangThai` bit(1) NOT NULL DEFAULT b'0',
  `MaKho` char(10) NOT NULL,
  `MaKH` char(10) NOT NULL,
  PRIMARY KEY (`MaDX`),
  KEY `FK_DonXuat_Kho` (`MaKho`),
  KEY `FK_DonXuat_NhanVien` (`MaNV`),
  KEY `FK_DonXuat_KhachHang` (`MaKH`),
  CONSTRAINT `FK_DonXuat_KhachHang` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON UPDATE CASCADE,
  CONSTRAINT `FK_DonXuat_Kho` FOREIGN KEY (`MaKho`) REFERENCES `kho` (`MaKho`) ON UPDATE CASCADE,
  CONSTRAINT `FK_DonXuat_NhanVien` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donxuat`
--

LOCK TABLES `donxuat` WRITE;
/*!40000 ALTER TABLE `donxuat` DISABLE KEYS */;
INSERT INTO `donxuat` VALUES (1,'ADMIN','2019-03-10 00:00:00',_binary '','KHO01','KH01'),(2,'ADMIN','2019-06-10 00:00:00',_binary '','KHO01','KH01'),(3,'ADMIN','2019-06-10 00:00:00',_binary '','KHO01','KH01'),(4,'ADMIN','2019-09-11 00:00:00',_binary '\0','KHO01','KH01'),(5,'Hoanglong','2019-06-11 00:00:00',_binary '','KHO01','KH01'),(6,'Hoanglong','2019-11-12 00:00:00',_binary '\0','KHO01','KH02'),(7,'Hoanglong','2019-12-11 00:00:00',_binary '\0','KHO01','KH02'),(8,'Philong','2019-10-11 00:00:00',_binary '','KHO01','KH02'),(9,'PhiLong','2019-06-11 00:00:00',_binary '','KHO01','KH02'),(10,'Philong','2019-12-11 00:00:00',_binary '','KHO01','KH01');
/*!40000 ALTER TABLE `donxuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKH` char(10) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `SDT` char(10) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `GhiChu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('KH01','GYU-KAKU','gyukaku@gmail.com','028629744','254 Đien Bien Phu, Phuong 7, Quan 3, TP. Ho Chi Minh',''),('KH02','ON YASAI ','onyasai@gmail.com','028382487',' 15/7 Le Thanh Ton, P. Ben Nghe, Q.1, HCM','');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kho`
--

DROP TABLE IF EXISTS `kho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kho` (
  `MaKho` char(10) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  PRIMARY KEY (`MaKho`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kho`
--

LOCK TABLES `kho` WRITE;
/*!40000 ALTER TABLE `kho` DISABLE KEYS */;
INSERT INTO `kho` VALUES ('KHO01','208 Nguyen Huu Canh, phuong 22, quan Binh Thanh,HCM ');
/*!40000 ALTER TABLE `kho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaisanpham`
--

DROP TABLE IF EXISTS `loaisanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaisanpham` (
  `MaLoai` char(10) NOT NULL,
  `TenLoai` varchar(50) NOT NULL,
  PRIMARY KEY (`MaLoai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaisanpham`
--

LOCK TABLES `loaisanpham` WRITE;
/*!40000 ALTER TABLE `loaisanpham` DISABLE KEYS */;
INSERT INTO `loaisanpham` VALUES ('L1','Nước Lọc'),('L2','Nước Ngọt'),('L3','Beer & Rượu');
/*!40000 ALTER TABLE `loaisanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `MaNCC` char(10) NOT NULL,
  `TenNCC` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `SDT` char(10) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `GhiChu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MaNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES ('NCC1','CONG TY PHAN PHOI NUOC UONG THIEN AN','alo@nuocthienan.com','0906222127','196 Ton That Thuyet, Phuong 3, Quan 4, TP Ho Chi Minh',''),('NCC2','CONG TY DAU TU THUONG MAI VÀ PHAT TRIEN VIET','phanphoi.com.vn','0987735588','258 Tran Khat Tran - Hai Ba Trung',''),('NCC3','CONG TY TNHH NGK COCA-COLA VIET NAM','vu@coca-cola.com','1900555584','485 Xa lO Ha Noi, Phuong Linh Trung, Quan Thu Duc, tp. HCM, Viet Nam',''),('NCC4','CONG TY TNHH DA LOC PHUONG NAM','info@daloc.vn','0838222817','17/12 Le Thanh Ton, Phuong Ben Nghe, Quan 1, HCM','');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNV` char(10) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `GioiTinh` bit(1) NOT NULL DEFAULT b'1',
  `SDT` char(10) NOT NULL,
  `MatKhau` varchar(50) NOT NULL,
  `Hinh` varchar(50) NOT NULL DEFAULT 'unknow.png',
  `VaiTro` varchar(50) NOT NULL DEFAULT 'Nhân Viên',
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('ADMIN','admin','admin@gmail.com',_binary '\0','0999999','admin','Unknow.png','Trưởng Phòng'),('Hoanglong','HLong','hlong@gmail.com',_binary '','033500058','longcoin','Unknow.png','Nhân Viên'),('Philong','PLong','plong@gmail.com',_binary '','012599482','longphi','Unknow.png','Nhân Viên'),('PS09070','Thang','thang@gmail.com',_binary '','0902284213','minhthang','Unknow.png','Nhân Viên');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `MaSP` char(10) NOT NULL,
  `TenSP` varchar(50) NOT NULL,
  `MaNCC` char(10) NOT NULL,
  `MaLoai` char(10) NOT NULL,
  `DonViTinh` varchar(50) NOT NULL,
  `GiaDV` float NOT NULL,
  PRIMARY KEY (`MaSP`),
  KEY `FK_SanPham_NhaCungCap` (`MaNCC`),
  KEY `FK_SanPham_Loai` (`MaLoai`),
  CONSTRAINT `FK_SanPham_Loai` FOREIGN KEY (`MaLoai`) REFERENCES `loaisanpham` (`MaLoai`) ON UPDATE CASCADE,
  CONSTRAINT `FK_SanPham_NhaCungCap` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES ('SP1','Aquafina','NCC1','L1','Thùng',98000),('SP10','Medoc De Port Royal','NCC4','L3','Chai',650000),('SP2','Lavie','NCC2','L1','Thùng',82000),('SP3','Vĩnh Hảo','NCC2','L1','Thùng',95000),('SP4','Dasani','NCC3','L1','Thùng',90000),('SP5','Coca-Cola','NCC3','L2','Thùng',170000),('SP6','Sprite','NCC3','L2','Thùng',160000),('SP7','Fanta','NCC3','L2','Thùng',183300),('SP8','Arboleda Cabernet Sauvignon','NCC4','L3','Chai',700000),('SP9','Carmen Classic Cabernet Sauvignon','NCC4','L3','Chai',280000);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'polystorage'
--

--
-- Dumping routines for database 'polystorage'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-22 23:43:26
