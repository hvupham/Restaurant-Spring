-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql8-container
-- Generation Time: Jun 13, 2024 at 02:52 AM
-- Server version: 8.2.0
-- PHP Version: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `cthd`
--

CREATE TABLE `cthd` (
  `id_hoa_donn` bigint NOT NULL,
  `id_mon_an` int NOT NULL,
  `so_luong` int DEFAULT NULL,
  `thanhtien` int DEFAULT NULL,
  `id_hoa_don` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `id_hoa_don` bigint NOT NULL,
  `code_voucher` varchar(255) DEFAULT NULL,
  `id_ban` bigint DEFAULT NULL,
  `id_kh` int DEFAULT NULL,
  `ngayhd` datetime(6) DEFAULT NULL,
  `tien_giam` int DEFAULT NULL,
  `tien_mon_an` int DEFAULT NULL,
  `tongtien` int DEFAULT NULL,
  `trangthai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `id_kh` int NOT NULL,
  `diemtichluy` int DEFAULT NULL,
  `doanhso` int DEFAULT NULL,
  `id_nd` bigint DEFAULT NULL,
  `ngaythamgia` datetime(6) DEFAULT NULL,
  `tenkh` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `monan`
--

CREATE TABLE `monan` (
  `id_mon_an` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `don_gia` int DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `loai` varchar(255) DEFAULT NULL,
  `ten_mon` varchar(255) DEFAULT NULL,
  `trang_thai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE `nguoidung` (
  `id_nd` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `matkhau` varchar(255) DEFAULT NULL,
  `trangthai` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `vaitro` varchar(255) DEFAULT NULL,
  `verifycode` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cthd`
--
ALTER TABLE `cthd`
  ADD PRIMARY KEY (`id_hoa_donn`,`id_mon_an`),
  ADD KEY `FKnu6rxfv2i8h9yle0wkk71eb6s` (`id_hoa_don`),
  ADD KEY `FKhswxqm7vm5nxkckb5umdb0rlk` (`id_mon_an`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id_hoa_don`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id_kh`);

--
-- Indexes for table `monan`
--
ALTER TABLE `monan`
  ADD PRIMARY KEY (`id_mon_an`);

--
-- Indexes for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`id_nd`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id_hoa_don` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id_kh` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `monan`
--
ALTER TABLE `monan`
  MODIFY `id_mon_an` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nguoidung`
--
ALTER TABLE `nguoidung`
  MODIFY `id_nd` bigint NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cthd`
--
ALTER TABLE `cthd`
  ADD CONSTRAINT `FKhswxqm7vm5nxkckb5umdb0rlk` FOREIGN KEY (`id_mon_an`) REFERENCES `monan` (`id_mon_an`),
  ADD CONSTRAINT `FKnu6rxfv2i8h9yle0wkk71eb6s` FOREIGN KEY (`id_hoa_don`) REFERENCES `hoadon` (`id_hoa_don`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
