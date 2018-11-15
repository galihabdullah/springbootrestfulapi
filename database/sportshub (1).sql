-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2018 at 11:48 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.1.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sportshub`
--

-- --------------------------------------------------------

--
-- Table structure for table `cabang_jenis_or`
--

CREATE TABLE `cabang_jenis_or` (
  `cabang_jenis_id` int(11) NOT NULL,
  `cabang_or_id` int(11) NOT NULL,
  `cabang_or` varchar(50) NOT NULL,
  `jenis_or` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cabang_jenis_or`
--

INSERT INTO `cabang_jenis_or` (`cabang_jenis_id`, `cabang_or_id`, `cabang_or`, `jenis_or`) VALUES
(1, 1, 'Beladiri', 'Anggar'),
(2, 1, 'Beladiri', 'Judo'),
(3, 1, 'Beladiri', 'Karate'),
(4, 1, 'Beladiri', 'Kempo'),
(5, 1, 'Beladiri', 'Pencak Silat'),
(6, 1, 'Beladiri', 'Taekwondo'),
(7, 1, 'Beladiri', 'Tarung Drajat'),
(8, 1, 'Beladiri', 'Tinju'),
(9, 1, 'Beladiri', 'Wushu'),
(10, 2, 'Konsentrasi', 'Aeromodeling'),
(11, 2, 'Konsentrasi', 'Biliar'),
(12, 2, 'Konsentrasi', 'Binaraga'),
(13, 2, 'Konsentrasi', 'Bowling'),
(14, 2, 'Konsentrasi', 'Bridge'),
(15, 2, 'Konsentrasi', 'Catur'),
(16, 2, 'Konsentrasi', 'Layar/Selancar Angin'),
(17, 2, 'Konsentrasi', 'Loncat Indah'),
(18, 2, 'Konsentrasi', 'Paralayang Dan Gantole'),
(19, 2, 'Konsentrasi', 'Renang Indah'),
(20, 2, 'Konsentrasi', 'Senam'),
(21, 2, 'Konsentrasi', 'Ski Air'),
(22, 2, 'Konsentrasi', 'Terbang Layang'),
(23, 2, 'Konsentrasi', 'Terjun Payung'),
(24, 3, 'Permainan', 'Bola Basket'),
(25, 3, 'Permainan', 'Bola Voli'),
(26, 3, 'Permainan', 'Bulutangkis'),
(27, 3, 'Permainan', 'Polo Air'),
(28, 3, 'Permainan', 'Sepak Bola'),
(29, 3, 'Permainan', 'Sepaktakraw'),
(30, 3, 'Permainan', 'Softball/Baseball'),
(31, 3, 'Permainan', 'Squash'),
(32, 3, 'Permainan', 'Tenis'),
(33, 3, 'Permainan', 'Tenis Meja'),
(34, 4, 'Terukur', 'Angkat Besi dan Angkat Berat'),
(35, 4, 'Terukur', 'Atletik'),
(36, 4, 'Terukur', 'Balap Sepeda'),
(37, 4, 'Terukur', 'Dayung'),
(38, 4, 'Terukur', 'Menembak'),
(39, 4, 'Terukur', 'Panahan'),
(40, 4, 'Terukur', 'Panjat Tebing'),
(41, 4, 'Terukur', 'Renang'),
(42, 4, 'Terukur', 'Selam'),
(43, 4, 'Terukur', 'Sepatu Roda'),
(44, 3, 'Permainan', 'Hoki'),
(45, 3, 'Permainan', 'Futsal');

-- --------------------------------------------------------

--
-- Table structure for table `cabang_or`
--

CREATE TABLE `cabang_or` (
  `cabang_or_id` int(11) NOT NULL,
  `cabang_or` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cabang_or`
--

INSERT INTO `cabang_or` (`cabang_or_id`, `cabang_or`) VALUES
(1, 'Beladiri'),
(2, 'Konsentrasi'),
(3, 'Permainan'),
(4, 'Terukur');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(9);

-- --------------------------------------------------------

--
-- Table structure for table `mt_olahraga`
--

CREATE TABLE `mt_olahraga` (
  `id_mt_olahraga` int(11) NOT NULL,
  `nama_olahraga` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sorttempat`
--

CREATE TABLE `sorttempat` (
  `id` bigint(20) NOT NULL,
  `cabang_olahraga` varchar(255) DEFAULT NULL,
  `id_tempat` bigint(20) DEFAULT NULL,
  `jenis_olahraga` varchar(255) DEFAULT NULL,
  `lokasi` varchar(255) DEFAULT NULL,
  `nama_tempat` varchar(255) DEFAULT NULL,
  `pict_url` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sorttempat`
--

INSERT INTO `sorttempat` (`id`, `cabang_olahraga`, `id_tempat`, `jenis_olahraga`, `lokasi`, `nama_tempat`, `pict_url`) VALUES
(1, 'Permainan', 1, 'Sepak Bola', 'Jakarta Barat', 'Lapangan Sepakbola Pegadungan', ''),
(2, 'Permainan', 2, 'Sepak Bola', 'Jakarta Barat', 'Lapangan Sepakbola Semanan', ''),
(3, 'Permainan', 3, 'Sepak Bola', 'Jakarta Barat', 'Lapangan Sepakbola Srengseng', ''),
(4, 'Permainan', 4, 'Sepak Bola', 'Jakarta Barat', 'Lapangan Joglo', ''),
(5, 'Permainan', 5, 'Sepak Bola', 'Jakarta Barat', 'Lapangan Sepakbola Kedoya', ''),
(6, 'Permainan', 6, 'Sepak Bola', 'Jakarta Barat', 'Lapangan sepakbola Kebon Jeruk', ''),
(7, 'Permainan', 7, 'Sepak Bola', 'Jakarta Barat', 'Lapangan Sepakbola Persima', ''),
(8, 'Permainan', 8, 'Sepak Bola', 'Jakarta Barat', 'Lapangan Sepakbola Wijaya Kusuma', ''),
(9, 'Permainan', 9, 'Sepak Bola', 'Jakarta Barat', 'Lapangan Sepakbola Terbuka', ''),
(10, 'Permainan', 10, 'Sepak Bola', 'Jakarta Pusat', 'Lapangan Sepakbola Karet Tengsin', ''),
(11, 'Permainan', 11, 'Sepak Bola', 'Jakarta Pusat', 'Lapangan Sepakbola Pejompongan', ''),
(12, 'Permainan', 12, 'Sepak Bola', 'Jakarta Pusat', 'Lapangan Sepakbola PORS Serdang', ''),
(13, 'Permainan', 13, 'Sepak Bola', 'Jakarta Timur', 'Lapangan sepak bola setu', ''),
(14, 'Permainan', 14, 'Sepak Bola', 'Jakarta Timur', 'Lapangan Sepak bola Klender', ''),
(15, 'Permainan', 15, 'Sepak Bola', 'Jakarta Timur', 'Lapangan sepak bola cakung', ''),
(16, 'Permainan', 16, 'Sepak Bola', 'Jakarta Timur', 'Lapangan sepak bola kramat jati', ''),
(17, 'Permainan', 17, 'Sepak Bola', 'Jakarta Timur', 'Lapangan sepak bola gedong', ''),
(18, 'Permainan', 18, 'Sepak Bola', 'Jakarta Timur', 'Lapangan sepak bola cijantung', ''),
(19, 'Permainan', 19, 'Sepak Bola', 'Jakarta Timur', 'Lapang sepak bola kelapa dua wetan', ''),
(20, 'Permainan', 20, 'Sepak Bola', 'Jakarta Timur', 'Lapangan sepak bola cibubur', ''),
(21, 'Permainan', 21, 'Sepak Bola', 'Jakarta Timur', 'Lapangan sepak bola lubang buaya', ''),
(22, 'Permainan', 22, 'Sepak Bola', 'Jakarta Timur', 'Lapangan sepak bola ceger', ''),
(23, 'Permainan', 23, 'Sepak Bola', 'Jakarta Selatan', 'Lapangan Sepak Bola Blok.S', ''),
(24, 'Permainan', 24, 'Sepak Bola', 'Jakarta Selatan', 'Lapangan Sepakbola A. Yani', ''),
(25, 'Permainan', 25, 'Sepak Bola', 'Jakarta Selatan', 'Lapangan Sepak Bola Kebagusan', ''),
(26, 'Permainan', 26, 'Sepak Bola', 'Jakarta Selatan', 'Lapangan Sepak Bola Jagakarsa', ''),
(27, 'Permainan', 27, 'Sepak Bola', 'Jakarta Selatan', 'Lapangan Sepak Bola Sukatani', ''),
(28, 'Permainan', 28, 'Sepak Bola', 'Jakarta Selatan', 'Lapangan Sepak Bola Pesanggrahan', ''),
(29, 'Permainan', 29, 'Sepak Bola', 'Jakarta Selatan', 'Lapangan Bola I', ''),
(30, 'Permainan', 30, 'Sepak Bola', 'Jakarta Selatan', 'Lapangan Bola II', ''),
(31, 'Permainan', 31, 'Sepak Bola', 'Jakarta Selatan', 'Lapangan Bola III', ''),
(32, 'Permainan', 32, 'Sepak Bola', 'Jakarta Utara', 'Lapangan Sepakbola Kalibaru', ''),
(33, 'Permainan', 33, 'Sepak Bola', 'Jakarta Utara', 'Lapangan Sepakbola Muara Angke', ''),
(34, 'Permainan', 34, 'Sepak Bola', 'Jakarta Utara', 'Lapangan Sepakbola Rorotan', ''),
(35, 'Permainan', 35, 'Sepak Bola', 'Kepulauan Seribu', 'Lapangan Sepakbola Pulau Untung', ''),
(36, 'Permainan', 36, 'Sepak Bola', 'Kepulauan Seribu', 'Lapangan Sepakbola Pulau Karya', ''),
(37, 'Permainan', 37, 'Sepak Bola', 'Kepulauan Seribu', 'Lapangan Sepakbola Pulau Pramuka', ''),
(38, 'Permainan', 38, 'Sepak Bola', 'Kepulauan Seribu', 'Lapangan Sepakbola Pulau Tidung', ''),
(39, 'Permainan', 39, 'Sepak Bola', 'Kepulauan Seribu', 'Lapangan Sepakbola Pulau Kelapa', ''),
(40, 'Permainan', 40, 'Sepak Bola', 'Jakarta Timur', 'Stadion Bola Pondok Bambu', ''),
(41, 'Permainan', 41, 'Sepak Bola', 'Jakarta Timur', 'Stadion Sepakbola Gongseng', ''),
(42, 'Permainan', 42, 'Sepak Bola', 'Jakarta Timur', 'Stadion Sepakbola Ciracas', ''),
(43, 'Permainan', 43, 'Sepak Bola', 'Jakarta Barat', 'Stadion Sepakbola Cendrawasih', ''),
(44, 'Permainan', 44, 'Sepak Bola', 'Jakarta Barat', 'Stadion Sepakbola Tamansari', ''),
(45, 'Permainan', 45, 'Sepak Bola', 'Jakarta Selatan', 'Stadion Sepakbola GMSB', ''),
(46, 'Permainan', 46, 'Sepak Bola', 'Jakarta Selatan', 'Stadion Sepakbola GOR Ragunan', ''),
(47, 'Permainan', 47, 'Sepak Bola', 'Jakarta Pusat', 'Stadion Sepakbola VIJ', ''),
(48, 'Permainan', 48, 'Sepak Bola', 'Jakarta Pusat', 'Stadion Sepakbola Banteng', ''),
(49, 'Permainan', 49, 'Sepak Bola', 'Jakarta Utara', 'Stadion Sepakbola GOR Sunter', ''),
(50, 'Permainan', 50, 'Sepak Bola', 'Jakarta Utara', 'Stadion Sepakbola Rawa Badak', ''),
(51, 'Permainan', 51, 'Sepak Bola', 'Jakarta Utara', 'Stadion Sepakbola Tugu', ''),
(52, 'Permainan', 52, 'Sepak Bola', 'Jakarta Utara', 'Stadion Kamal Muara', ''),
(53, 'Permainan', 53, 'Bola Basket', 'Jakarta Timur', 'Lapangan Basket Outdoor Tri On Tri GOR CIRACAS', ''),
(54, 'Permainan', 54, 'Bola Basket', 'Jakarta Timur', 'Lapangan Basket Terbuka', ''),
(55, 'Permainan', 55, 'Tenis', 'Jakarta Timur', 'Lapangan Tenis Terbuka GOR Rawamangun', ''),
(56, 'Permainan', 56, 'Tenis', 'Jakarta Timur', 'Lapangan Tenis Pondok Bambu', ''),
(57, 'Permainan', 57, 'Tenis', 'Jakarta Timur', 'Lapangan Tenis Terbuka', ''),
(58, 'Konsentrasi', 58, 'Binaraga', 'Jakarta Timur', 'Lapangan Fitnes Terbuka', ''),
(59, 'Permainan', 60, 'Bola Basket', 'Jakarta Timur', 'Lapangan Basket Luar', ''),
(60, 'Permainan', 61, 'Tenis', 'Jakarta Selatan', 'Lapangan Tenis', ''),
(61, 'Permainan', 62, 'Tenis', 'Jakarta Selatan', 'Fasilitas Lapangan Tenis Bulungan (Semi Indoor)', ''),
(62, 'Permainan', 63, 'Tenis', 'Jakarta Selatan', 'Lapangan Tenis PPOP Ragunan', ''),
(63, 'Konsentrasi', 64, 'Binaraga', 'Jakarta Selatan', 'Lapangan Fitnes Terbuka', ''),
(64, 'Permainan', 65, 'Hoki', 'Jakarta Selatan', 'Lapangan Luar (HOKI)', ''),
(65, 'Permainan', 66, 'Hoki', 'Jakarta Selatan', 'Lapangan Serbaguna (Lap Hockey)', ''),
(66, 'Permainan', 67, 'Hoki', 'Jakarta Selatan', 'Lapangan Serbaguna (Lap Hockey)', ''),
(67, 'Permainan', 68, 'Hoki', 'Jakarta Selatan', 'Lapangan Serbaguna (Lap Hockey)', ''),
(68, 'Permainan', 69, 'Hoki', 'Jakarta Selatan', 'Lapangan Serbaguna (Lap Hockey)', ''),
(69, 'Permainan', 70, 'Hoki', 'Jakarta Selatan', 'Lapangan Serbaguna (Lap Hockey)', ''),
(70, 'Permainan', 71, 'Hoki', 'Jakarta Selatan', 'Lapangan Serbaguna (Lap Hockey)', ''),
(71, 'Permainan', 72, 'Bola Basket', 'Jakarta Selatan', 'Lapangan Basket terbuka Angsana Raya Cengkareng Ti', ''),
(72, 'Permainan', 73, 'Tenis', 'Jakarta Barat', 'Lapangan Tenis / Futsal', ''),
(73, 'Permainan', 73, 'Futsal', 'Jakarta Barat', 'Lapangan Tenis / Futsal', ''),
(74, 'Permainan', 74, 'Tenis', 'Jakarta Barat', 'Lapangan Tenis Cengkareng', ''),
(75, 'Permainan', 75, 'Tenis', 'Jakarta Timur', 'Lapangan Tenis Jati Pulo RW 03', ''),
(76, 'Permainan', 76, 'Bola Voli', 'Jakarta Barat', 'Lapangan Voli Kampung Belakang Kamal', ''),
(77, 'Permainan', 77, 'Bola Voli', 'Jakarta Barat', 'Lapangan Voli Kapuk', ''),
(78, 'Permainan', 78, 'Tenis', 'Jakarta Utara', 'Lapangan Tenis Rawa Badak', ''),
(79, 'Konsentrasi', 79, 'Binaraga', 'Jakarta Utara', 'Lapangan Fitnes Terbuka', ''),
(80, 'Konsentrasi', 80, 'Binaraga', 'Jakarta Pusat', 'Lapangan Fitnes Terbuka', ''),
(81, 'Permainan', 81, 'Tenis', 'Kepulauan Seribu', 'Lapangan Tenis Pulau Pramuka', ''),
(82, 'Permainan', 82, 'Bola Voli', 'Kepulauan Seribu', 'Lapangan Voli Pulau Untung Jawa', ''),
(83, 'Permainan', 83, 'Bola Voli', 'Kepulauan Seribu', 'Lapangan Voli Pulau Panggang', ''),
(84, 'Permainan', 84, 'Bola Voli', 'Kepulauan Seribu', 'Lapangan Voli Pulau Karya', ''),
(85, 'Permainan', 85, 'Bola Voli', 'Kepulauan Seribu', 'Lapangan Voli Pantai Pulau Untung Jawa', ''),
(86, 'Permainan', 86, 'Bola Voli', 'Kepulauan Seribu', 'Lapangan Voli Pantai Pulau Karya', ''),
(87, 'Permainan', 87, 'Bola Voli', 'Kepulauan Seribu', 'Lapangan Voli Pulau Pramuka', ''),
(88, 'Permainan', 88, 'Bola Voli', 'Kepulauan Seribu', 'Lapangan Voli Pulau Panggang', ''),
(89, 'Permainan', 89, 'Bola Voli', 'Kepulauan Seribu', 'Lapangan Bulutangkis Pulau Untung Jawa', ''),
(90, 'Permainan', 89, 'Bulutangkis', 'Jakarta Utara', 'Lapangan Bulutangkis Pulau Untung Jawa', ''),
(91, 'Konsentrasi', 89, 'Binaraga', 'Jakarta Utara', 'Lapangan Bulutangkis Pulau Untung Jawa', ''),
(92, 'Terukur', 90, 'Renang', 'Jakarta Utara', 'Kolam Renang Gelanggang Remaja Jakarta Utara', ''),
(93, 'Terukur', 91, 'Renang', 'Jakarta Timur', 'Kolam Renang GOR Sunter', ''),
(94, 'Terukur', 92, 'Renang', 'Jakarta Timur', 'Kolam Renang Rawa Badak', ''),
(95, 'Terukur', 93, 'Renang', 'Jakarta Timur', 'Kolam Renang Gelanggang Remaja Jakarta Timur', ''),
(96, 'Terukur', 94, 'Renang', 'Jakarta Selatan', 'Kolam Renang GOR Rawamangun', ''),
(97, 'Terukur', 95, 'Renang', 'Jakarta Selatan', 'Gedung kolam renang GOR Ciracas', ''),
(98, 'Terukur', 96, 'Renang', 'Jakarta Selatan', 'Kolam Renang GMSB', ''),
(99, 'Terukur', 97, 'Renang', 'Jakarta Pusat', 'Fasilitas Kolam Renang Bulungan', ''),
(100, 'Terukur', 98, 'Renang', 'Jakarta Pusat', 'Gedung Kolam Renang PPOP Ragunan', ''),
(101, 'Terukur', 99, 'Renang', 'Jakarta Barat', 'Kolam Renang Kebon Jahe Tanah Abang', ''),
(102, 'Terukur', 100, 'Renang', NULL, 'Kolam Renang Gelanggang Remaja Jakarta Pusat', ''),
(103, 'Terukur', 101, 'Renang', NULL, 'Kolam Renang Gelanggang Remaja Jakarta Barat', '');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(11) NOT NULL,
  `id_level` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `tmp_lahirr` varchar(60) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jenis_kelamin` enum('L','P') NOT NULL,
  `email` varchar(60) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `minat_or` varchar(150) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(200) NOT NULL,
  `status` tinyint(2) NOT NULL,
  `flag_hapus` tinyint(2) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `id_level`, `nama`, `alamat`, `tmp_lahirr`, `tgl_lahir`, `jenis_kelamin`, `email`, `no_hp`, `minat_or`, `username`, `password`, `status`, `flag_hapus`, `created_at`, `updated_at`) VALUES
(1, 1, 'Super Administrator', '', '', '0000-00-00', 'L', '', '', '', 'adminsporthub', '1de60b7b34ac0e140cefeddf600e149478c5e532', 1, 0, '2018-11-07 04:19:08', '2018-11-06 17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tempat`
--

CREATE TABLE `tempat` (
  `id_tempat` int(10) NOT NULL,
  `tempat_nama` varchar(50) NOT NULL,
  `tempat_tanggalberdiri` date NOT NULL,
  `tempat_alamat` varchar(50) NOT NULL,
  `tempat_kelurahan` varchar(11) NOT NULL,
  `tempat_kecamatan` varchar(11) NOT NULL,
  `tempat_wilayah` varchar(11) NOT NULL,
  `tempat_deskripsi` text NOT NULL,
  `tempat_kapasitas` int(11) NOT NULL,
  `tempat_gambar` varchar(200) NOT NULL,
  `id` bigint(20) NOT NULL,
  `tempat_keluarahan` varchar(255) DEFAULT NULL,
  `nama_tempat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tempat`
--

INSERT INTO `tempat` (`id_tempat`, `tempat_nama`, `tempat_tanggalberdiri`, `tempat_alamat`, `tempat_kelurahan`, `tempat_kecamatan`, `tempat_wilayah`, `tempat_deskripsi`, `tempat_kapasitas`, `tempat_gambar`, `id`, `tempat_keluarahan`, `nama_tempat`) VALUES
(1, 'Lapangan Sepakbola Pegadungan', '1995-05-05', 'Jl. Peta Utara', 'Pegadungan', 'Kalideres', 'Jakarta Bar', '', 100, '', 0, NULL, NULL),
(2, 'Lapangan Sepakbola Semanan', '1995-05-06', 'Jl. Raya Semanan', 'Semanan', 'Kalideres', 'Jakarta Bar', '', 200, '', 0, NULL, NULL),
(3, 'Lapangan Sepakbola Srengseng', '1995-05-07', 'Jl. Lapangan Sepak Bola', 'Srengseng', 'Kembangan', 'Jakarta Bar', '', 250, '', 0, NULL, NULL),
(4, 'Lapangan Joglo', '1995-05-08', 'Jl. Komp DPR RI Joglo', 'Meruya Sela', 'Kembangan', 'Jakarta Bar', '', 300, '', 0, NULL, NULL),
(5, 'Lapangan Sepakbola Kedoya', '1995-05-09', 'Jl. Pilar Raya', 'Kedoya Sela', 'Kebon Jeruk', 'Jakarta Bar', '', 330, '', 0, NULL, NULL),
(6, 'Lapangan sepakbola Kebon Jeruk', '1995-05-10', 'Jl. Raya Kebon Jeruk', 'Kebon Jeruk', 'Kebon Jeruk', 'Jakarta Bar', '', 250, '', 0, NULL, NULL),
(7, 'Lapangan Sepakbola Persima', '1995-05-11', 'Jl. Kali Anyar IX', 'Tambora', 'Tambora', 'Jakarta Bar', '', 300, '', 0, NULL, NULL),
(8, 'Lapangan Sepakbola Wijaya Kusuma', '1995-05-12', 'Jl. Anggrek Garuda', 'Kemanggisan', 'Palmerah', 'Jakarta Bar', '', 500, '', 0, NULL, NULL),
(9, 'Lapangan Sepakbola Terbuka', '1995-05-13', 'Jl. Cendrawasih X No. 10', 'Cengkareng ', 'Cengkareng', 'Jakarta Bar', '', 100, '', 0, NULL, NULL),
(10, 'Lapangan Sepakbola Karet Tengsin', '1995-05-14', 'Jl. Karet Pasar Baru Barat II', 'Karet Tengs', 'Tanah Abang', 'Jakarta Pus', '', 200, '', 0, NULL, NULL),
(11, 'Lapangan Sepakbola Pejompongan', '1995-05-15', 'Jl. Danau Tondano', 'Bendungan H', 'Tanah Abang', 'Jakarta Pus', '', 250, '', 0, NULL, NULL),
(12, 'Lapangan Sepakbola PORS Serdang', '1995-05-16', 'Jl. Lapangan PORS', 'Serdang', 'Kemayoran', 'Jakarta Pus', '', 300, '', 0, NULL, NULL),
(13, 'Lapangan sepak bola setu', '1995-05-17', 'Jl. Bantar Jati', 'Setu', 'Cipayung', 'Jakarta Tim', '', 330, '', 0, NULL, NULL),
(14, 'Lapangan Sepak bola Klender', '1995-05-18', 'Jl. Malaka I', 'Malakasari', 'Duren Sawit', 'Jakarta Tim', '', 250, '', 0, NULL, NULL),
(15, 'Lapangan sepak bola cakung', '1995-05-19', 'Jl. Kayu Tinggi', 'Cakung', 'Cakung', 'Jakarta Tim', '', 300, '', 0, NULL, NULL),
(16, 'Lapangan sepak bola kramat jati', '1995-05-20', 'JL. Raya Bogor', 'Rambutan', 'Ciracas', 'Jakarta Tim', '', 500, '', 0, NULL, NULL),
(17, 'Lapangan sepak bola gedong', '1995-05-21', 'Jl. Raya Condet', 'Condet', 'Pasar Rebo', 'Jakarta Tim', '', 100, '', 0, NULL, NULL),
(18, 'Lapangan sepak bola cijantung', '1995-05-22', 'Jl. Stadion Mini', 'Cijantung', 'Pasar Rebo', 'Jakarta Tim', '', 200, '', 0, NULL, NULL),
(19, 'Lapang sepak bola kelapa dua wetan', '1995-05-23', 'Jl. Raya PKP', 'Kelapa Dua ', 'Ciracas', 'Jakarta Tim', '', 250, '', 0, NULL, NULL),
(20, 'Lapangan sepak bola cibubur', '1995-05-24', 'Jl. Bulak Sereh', 'Cibubur', 'Bulak Sereh', 'Jakarta Tim', '', 300, '', 0, NULL, NULL),
(21, 'Lapangan sepak bola lubang buaya', '1995-05-25', 'Jl. SMPN 81', 'Lubang buay', 'Cipayung', 'Jakarta Tim', '', 330, '', 0, NULL, NULL),
(22, 'Lapangan sepak bola ceger', '1995-05-26', 'Jl. SMPN 160/H. Siun', 'Ceger', 'Cipayung', 'Jakarta Tim', '', 250, '', 0, NULL, NULL),
(23, 'Lapangan Sepak Bola Blok.S', '1995-05-27', 'Jl. suryo No 1 Keb.Baru', 'Rawa Barat', 'Kebayoran b', 'Jakarta Sel', '', 300, '', 0, NULL, NULL),
(24, 'Lapangan Sepakbola A. Yani', '1995-05-28', 'Jl. Praja', 'Kebayoran L', 'Kebayoran l', 'Jakarta Sel', '', 500, '', 0, NULL, NULL),
(25, 'Lapangan Sepak Bola Kebagusan', '1995-05-29', 'Jl. Kelurahan', 'Lenteng Agu', 'Jagakarsa', 'Jakarta Sel', '', 100, '', 0, NULL, NULL),
(26, 'Lapangan Sepak Bola Jagakarsa', '1995-05-30', 'Jl. Sirsak', 'Jagakarsa', 'Jagakarsa', 'Jakarta Sel', '', 200, '', 0, NULL, NULL),
(27, 'Lapangan Sepak Bola Sukatani', '1995-05-31', 'Jl. Nangka', 'Tanjung Bar', 'Jagakarsa', 'Jakarta Sel', '', 250, '', 0, NULL, NULL),
(28, 'Lapangan Sepak Bola Pesanggrahan', '1995-06-01', 'Jl. Pesanggrahan', 'Pesanggraha', 'Pesanggraha', 'Jakarta Sel', '', 300, '', 0, NULL, NULL),
(29, 'Lapangan Bola I', '1995-06-02', 'Jl. Harsono RM.', 'Ragunan', 'Pasar Mingg', 'Jakarta Sel', '', 330, '', 0, NULL, NULL),
(30, 'Lapangan Bola II', '1995-06-03', 'Jl. Harsono RM.', 'Ragunan', 'Pasar Mingg', 'Jakarta Sel', '', 250, '', 0, NULL, NULL),
(31, 'Lapangan Bola III', '1995-06-04', 'Jl. Harsono RM.', 'Ragunan', 'Pasar Mingg', 'Jakarta Sel', '', 300, '', 0, NULL, NULL),
(32, 'Lapangan Sepakbola Kalibaru', '1995-06-05', 'Jl. Kalibaru Barat RT.05 RW.15', 'Kali Baru', 'Cilincing', 'Jakarta Uta', '', 500, '', 0, NULL, NULL),
(33, 'Lapangan Sepakbola Muara Angke', '1995-06-06', 'Jl. Dermaga Muara RW.11', 'Pluit', 'Penjaringan', 'Jakarta Uta', '', 100, '', 0, NULL, NULL),
(34, 'Lapangan Sepakbola Rorotan', '1995-06-07', 'Jl. Malaka I RT.07 RW.12', 'Rorotan', 'Cilincing', 'Jakarta Uta', '', 200, '', 0, NULL, NULL),
(35, 'Lapangan Sepakbola Pulau Untung', '1995-06-08', 'Pulau Untung', 'Pulau Untun', 'Kepulauan S', 'Kepulauan S', '', 250, '', 0, NULL, NULL),
(36, 'Lapangan Sepakbola Pulau Karya', '1995-06-09', 'Pulau Karya', 'Pulau Pangg', 'Kepulauan S', 'Kepulauan S', '', 300, '', 0, NULL, NULL),
(37, 'Lapangan Sepakbola Pulau Pramuka', '1995-06-10', 'Pulau Pramuka', 'Pulau Pangg', 'Kepulauan S', 'Kepulauan S', '', 330, '', 0, NULL, NULL),
(38, 'Lapangan Sepakbola Pulau Tidung', '1995-06-11', 'Pulau Tidung', 'Pulau Tidun', 'Kepulauan S', 'Kepulauan S', '', 250, '', 0, NULL, NULL),
(39, 'Lapangan Sepakbola Pulau Kelapa', '1995-06-12', 'Pulau Kelapa', 'Pulau Harap', 'Kepulauan S', 'Kepulauan S', '', 300, '', 0, NULL, NULL),
(40, 'Stadion Bola Pondok Bambu', '1995-06-13', 'Jl. Balai Rakyat', 'Pondok Bamb', 'Duren Sawit', 'Jakarta Tim', '', 500, '', 0, NULL, NULL),
(41, 'Stadion Sepakbola Gongseng', '1995-06-14', 'Jl. Raya Gongseng', 'Pasar Rebo', 'Cijantung', 'Jakarta Tim', '', 100, '', 0, NULL, NULL),
(42, 'Stadion Sepakbola Ciracas', '1995-06-15', 'Jl. Raya Bogor Km 25-26', 'Ciracas', 'Ciracas', 'Jakarta Tim', '', 200, '', 0, NULL, NULL),
(43, 'Stadion Sepakbola Cendrawasih', '1995-06-16', 'Jl. Cendrawasih x No. 10', 'Cengkareng ', 'Cengkareng', 'Jakarta Bar', '', 250, '', 0, NULL, NULL),
(44, 'Stadion Sepakbola Tamansari', '1995-06-17', 'Jl. Mangga Besar 6 Utara', 'Mangga Besa', 'Taman Sari', 'Jakarta Bar', '', 300, '', 0, NULL, NULL),
(45, 'Stadion Sepakbola GMSB', '1995-06-18', 'Jl. HR. Rasuna Said Kav.C-22', 'Kuningan Ti', 'Setiabudi', 'Jakarta Sel', '', 100, '', 0, NULL, NULL),
(46, 'Stadion Sepakbola GOR Ragunan', '1995-06-19', 'Jl. Harsono RM. Ragunan', 'Ragunan', 'Pasar Mingg', 'Jakarta Sel', '', 200, '', 0, NULL, NULL),
(47, 'Stadion Sepakbola VIJ', '1995-06-20', 'Jl. Biak No. 27', 'Cideng', 'Gambir', 'Jakarta Pus', '', 250, '', 0, NULL, NULL),
(48, 'Stadion Sepakbola Banteng', '1995-06-21', 'Jl. Lapangan Banteng Utara', 'Pasar Baru', 'Sawah Besar', 'Jakarta Pus', '', 300, '', 0, NULL, NULL),
(49, 'Stadion Sepakbola GOR Sunter', '1995-06-22', 'Jl. Danau Sunter Selatan No.1', 'Sunter Agun', 'Tanjung Pri', 'Jakarta Uta', '', 330, '', 0, NULL, NULL),
(50, 'Stadion Sepakbola Rawa Badak', '1995-06-23', 'Jl. Alur Laut', 'Rawabadak', 'Koja', 'Jakarta Uta', '', 250, '', 0, NULL, NULL),
(51, 'Stadion Sepakbola Tugu', '1995-06-24', 'Jl. Pegangsaan Dua', 'Pegangsaan ', 'Kelapa Gadi', 'Jakarta Uta', '', 300, '', 0, NULL, NULL),
(52, 'Stadion Kamal Muara', '1995-06-25', 'Jl. Kamal Muara', 'Kamal Muara', 'Penjaringan', 'Jakarta Uta', '', 500, '', 0, NULL, NULL),
(53, 'Lapangan Basket Outdoor Tri On Tri GOR CIRACAS', '1995-06-26', 'Jl. Raya Bogor Km 25-26', 'Ciracas', 'Ciracas', 'Jakarta Tim', '', 100, '', 0, NULL, NULL),
(54, 'Lapangan Basket Terbuka', '1995-06-27', 'Jl. Pemuda No.6', 'Rawamangun', 'Pulo Gadung', 'Jakarta Tim', '', 200, '', 0, NULL, NULL),
(55, 'Lapangan Tenis Terbuka GOR Rawamangun', '1995-06-28', 'Jl. Pemuda No.6', 'Rawamangun', 'Pulo Gadung', 'Jakarta Tim', '', 250, '', 0, NULL, NULL),
(56, 'Lapangan Tenis Pondok Bambu', '1995-06-29', 'Jl. Balai Rakyat Duren Sawit', 'Pondok Bamb', 'Duren Sawit', 'Jakarta Tim', '', 300, '', 0, NULL, NULL),
(57, 'Lapangan Tenis Terbuka', '1995-06-30', 'Jl. Raya Gongseng', 'Cijantung', 'Pasar Rebo', 'Jakarta Tim', '', 330, '', 0, NULL, NULL),
(58, 'Lapangan Fitnes Terbuka', '1995-07-01', 'Jl. Pemuda No.6', 'Rawamangun', 'Pulo Gadung', 'Jakarta Tim', '', 250, '', 0, NULL, NULL),
(59, 'Lapangan Fitnes Terbuka', '1995-07-02', 'Jl. Raya Bogor Km 25-26', 'Ciracas', 'Ciracas', 'Jakarta Tim', '', 100, '', 0, NULL, NULL),
(60, 'Lapangan Basket Luar', '1995-07-03', 'Jl. Harsono RM. Ragunan', 'Ragunan', 'Pasar Mingg', 'Jakarta Sel', '', 200, '', 0, NULL, NULL),
(61, 'Lapangan Tenis', '1995-07-04', 'Jl. HR. Rasuna Said Kav.C-22', 'Kuningan Ti', 'Setiabudi', 'Jakarta Sel', '', 250, '', 0, NULL, NULL),
(62, 'Fasilitas Lapangan Tenis Bulungan (Semi Indoor)', '1995-07-05', 'Jl. Hang Tuah X', 'Gunung', 'Kebayoran B', 'Jakarta Sel', '', 300, '', 0, NULL, NULL),
(63, 'Lapangan Tenis PPOP Ragunan', '1995-07-06', 'Jl. Harsono RM.', 'Ragunan', 'Pasar Mingg', 'Jakarta Sel', '', 330, '', 0, NULL, NULL),
(64, 'Lapangan Fitnes Terbuka', '1995-07-07', 'Jl. Harsono RM.', 'Ragunan', 'Pasar Mingg', 'Jakarta Sel', '', 250, '', 0, NULL, NULL),
(65, 'Lapangan Luar (HOKI)', '1995-07-08', 'Jl. HR. Rasuna Said Kav.C-22', 'Kuningan Ti', 'Setiabudi', 'Jakarta Sel', '', 300, '', 0, NULL, NULL),
(66, 'Lapangan Serbaguna (Lap Hockey)', '1995-07-09', 'Jl. Bahari 14 Rt 09/07', 'Gandaria Se', 'Cilandak', 'Jakarta Sel', '', 100, '', 0, NULL, NULL),
(67, 'Lapangan Serbaguna (Lap Hockey)', '1995-07-10', 'Jl. Ciput Kel.P.Manggis', 'Pasar Mangg', 'Setiabudi', 'Jakarta Sel', '', 200, '', 0, NULL, NULL),
(68, 'Lapangan Serbaguna (Lap Hockey)', '1995-07-11', 'Jl. Peninggaran T.I', 'Pesanggraha', 'Pesanggraha', 'Jakarta Sel', '', 250, '', 0, NULL, NULL),
(69, 'Lapangan Serbaguna (Lap Hockey)', '1995-07-12', 'Jl. Kebon Mangga I', 'Cipulir', 'Kebayora La', 'Jakarta Sel', '', 300, '', 0, NULL, NULL),
(70, 'Lapangan Serbaguna (Lap Hockey)', '1995-07-13', 'Jl. HR. Rasuna Said Kav.C-22', 'Kuningan Ti', 'Setiabudi', 'Jakarta Sel', '', 330, '', 0, NULL, NULL),
(71, 'Lapangan Serbaguna (Lap Hockey)', '1995-07-14', 'Jl. Rasamala VII', 'Menteng Dal', 'Tebet', 'Jakarta Sel', '', 250, '', 0, NULL, NULL),
(72, 'Lapangan Basket terbuka Angsana Raya Cengkareng Ti', '1995-07-15', 'Jl. Angsana Raya Cengkareng Timur RT. 15/12', 'Cengkareng', 'Cengkareng', 'Jakarta Bar', '', 100, '', 0, NULL, NULL),
(73, 'Lapangan Tenis / Futsal', '1995-07-16', 'Jl. Cendrawasih X No. 10', 'Cengkareng', 'Cengkareng', 'Jakarta Bar', '', 200, '', 0, NULL, NULL),
(74, 'Lapangan Tenis Cengkareng', '1995-07-17', 'Jl. Utama Raya', 'Cengkareng', 'Cengkareng', 'Jakarta Bar', '', 250, '', 0, NULL, NULL),
(75, 'Lapangan Tenis Jati Pulo RW 03', '1995-07-18', 'Jl. Tunjung Raya Raya', ' RW 03', 'Jati Pulo P', 'Jakarta Tim', '', 300, '', 0, NULL, NULL),
(76, 'Lapangan Voli Kampung Belakang Kamal', '1995-07-19', 'Jl. Kampung Belakang RT. 11/03', 'Kamal', 'Kalideres', 'Jakarta Bar', '', 330, '', 0, NULL, NULL),
(77, 'Lapangan Voli Kapuk', '1995-07-20', 'Jl. AF 11/45', 'Pedongkelan', 'Cengkareng', 'Jakarta Bar', '', 250, '', 0, NULL, NULL),
(78, 'Lapangan Tenis Rawa Badak', '1995-07-21', 'Jl. Alur Laut', 'Rawabadak', 'Koja', 'Jakarta Uta', '', 100, '', 0, NULL, NULL),
(79, 'Lapangan Fitnes Terbuka', '1995-07-22', 'Jl. Danau Sunter Selatan No.1', 'Sunter Agun', 'Tanjung Pri', 'Jakarta Uta', '', 200, '', 0, NULL, NULL),
(80, 'Lapangan Fitnes Terbuka', '1995-07-23', 'Jl. Stasiun Senen No. I', 'Senen', 'Senen', 'Jakarta Pus', '', 250, '', 0, NULL, NULL),
(81, 'Lapangan Tenis Pulau Pramuka', '1995-07-24', 'Kelurahan Pulau Panggang', 'Pulau Pangg', 'Kepulauan S', 'Kepulauan S', '', 300, '', 0, NULL, NULL),
(82, 'Lapangan Voli Pulau Untung Jawa', '1995-07-25', 'Kelurahan Pulau Untung Jawa', 'Untung Jawa', 'Kepulauan S', 'Kepulauan S', '', 100, '', 0, NULL, NULL),
(83, 'Lapangan Voli Pulau Panggang', '1995-07-26', 'Kelurahan Pulau Panggang', 'Pulau Pangg', 'Kepulauan S', 'Kepulauan S', '', 200, '', 0, NULL, NULL),
(84, 'Lapangan Voli Pulau Karya', '1995-07-27', 'Kelurahan Pulau Panggang', 'Pulau Pangg', 'Kepulauan S', 'Kepulauan S', '', 250, '', 0, NULL, NULL),
(85, 'Lapangan Voli Pantai Pulau Untung Jawa', '1995-07-28', 'Kelurahan Pulau Untung Jawa', 'Pulau Untun', 'Kepulauan S', 'Kepulauan S', '', 300, '', 0, NULL, NULL),
(86, 'Lapangan Voli Pantai Pulau Karya', '1995-07-29', 'Kelurahan Pulau Panggang', 'Pulau Pangg', 'Kepulauan S', 'Kepulauan S', '', 330, '', 0, NULL, NULL),
(87, 'Lapangan Voli Pulau Pramuka', '1995-07-30', 'Kelurahan Pulau Panggang', 'Pulau Pangg', 'Kepulauan S', 'Kepulauan S', '', 250, '', 0, NULL, NULL),
(88, 'Lapangan Voli Pulau Panggang', '1995-07-31', 'Kelurahan Pulau Panggang', 'Pulau Pangg', 'Kepulauan S', 'Kepulauan S', '', 300, '', 0, NULL, NULL),
(89, 'Lapangan Bulutangkis Pulau Untung Jawa', '1995-08-01', 'Kelurahan Pulau Untung Jawa', 'Pulau Untun', 'Kepulauan S', 'Kepulauan S', '', 500, '', 0, NULL, NULL),
(90, 'Kolam Renang Gelanggang Remaja Jakarta Utara', '1995-08-02', 'Jl. Yos Sudarso No 25-26', 'Kebon Bawan', 'Tanjung Pri', 'Jakarta Uta', '', 100, '', 0, NULL, NULL),
(91, 'Kolam Renang GOR Sunter', '1995-08-03', 'Jl. Danau Sunter Selatan No.1', 'Sunter Agun', 'Tanjung Pri', 'Jakarta Uta', '', 200, '', 0, NULL, NULL),
(92, 'Kolam Renang Rawa Badak', '1995-08-04', 'Jl. Alur Laut', 'Rawabadak', 'Koja', 'Jakarta Uta', '', 250, '', 0, NULL, NULL),
(93, 'Kolam Renang Gelanggang Remaja Jakarta Timur', '1995-08-05', 'Jl. Otista No. 121', 'Cipinang Ce', 'Jatinegara', 'Jakarta Tim', '', 300, '', 0, NULL, NULL),
(94, 'Kolam Renang GOR Rawamangun', '1995-08-06', 'Jl. Pemuda No.6', 'Rawamangun', 'Pulo Gadung', 'Jakarta Tim', '', 330, '', 0, NULL, NULL),
(95, 'Gedung kolam renang GOR Ciracas', '1995-08-07', 'Jl. Raya Bogor Km 25-26', 'Ciracas', 'Ciracas', 'Jakarta Tim', '', 250, '', 0, NULL, NULL),
(96, 'Kolam Renang GMSB', '1995-08-08', 'Jl. HR. Rasuna Said Kav.C-22', 'Kuningan Ti', 'Setiabudi', 'Jakarta Sel', '', 300, '', 0, NULL, NULL),
(97, 'Fasilitas Kolam Renang Bulungan', '1995-08-09', 'Jl. Kyai Maja', 'Gunung', 'Kebayoran b', 'Jakarta Sel', '', 100, '', 0, NULL, NULL),
(98, 'Gedung Kolam Renang PPOP Ragunan', '1995-08-10', 'Jl. Harsono RM', 'Ragunan', 'Pasar Mingg', 'Jakarta Sel', '', 200, '', 0, NULL, NULL),
(99, 'Kolam Renang Kebon Jahe Tanah Abang', '1995-08-11', 'Jl. Tanah Abang I No. I', 'Petojo Sela', 'Gambir', 'Jakarta Pus', '', 250, '', 0, NULL, NULL),
(100, 'Kolam Renang Gelanggang Remaja Jakarta Pusat', '1995-08-12', 'Jl. Stasiun Senen No. I', 'Senen', 'Senen', 'Jakarta Pus', '', 300, '', 0, NULL, NULL),
(101, 'Kolam Renang Gelanggang Remaja Jakarta Barat', '1995-08-13', 'Jl. Semeru Raya No.2', 'Grogol', 'Grogol Peta', 'Jakarta Bar', '', 100, '', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tmp_user`
--

CREATE TABLE `tmp_user` (
  `id_user` int(11) NOT NULL,
  `id_level` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `tmp_lahirr` varchar(60) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `jenis_kelamin` enum('L','P') NOT NULL,
  `email` varchar(60) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `minat_or` varchar(150) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(200) NOT NULL,
  `status` tinyint(2) NOT NULL,
  `flag_hapus` tinyint(2) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_level`
--

CREATE TABLE `user_level` (
  `id_level` int(5) NOT NULL,
  `level` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_level`
--

INSERT INTO `user_level` (`id_level`, `level`) VALUES
(1, 'Super Administrator'),
(2, 'Administrator'),
(3, 'Operator'),
(4, 'User'),
(5, 'Komunitas'),
(6, 'Fasilitator');

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_user`
-- (See below for the actual view)
--
CREATE TABLE `v_user` (
`id_user` int(11)
,`id_level` int(5)
,`username` varchar(15)
,`password` varchar(200)
,`status` tinyint(2)
,`level` varchar(20)
);

-- --------------------------------------------------------

--
-- Structure for view `v_user`
--
DROP TABLE IF EXISTS `v_user`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_user`  AS  select `user`.`id_user` AS `id_user`,`user`.`id_level` AS `id_level`,`user`.`username` AS `username`,`user`.`password` AS `password`,`user`.`status` AS `status`,`level`.`level` AS `level` from (`tb_user` `user` join `user_level` `level`) where (`user`.`id_level` = `level`.`id_level`) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cabang_jenis_or`
--
ALTER TABLE `cabang_jenis_or`
  ADD PRIMARY KEY (`cabang_jenis_id`),
  ADD KEY `FKs0300fwpa534nm9j6vypxkh7q` (`cabang_or_id`);

--
-- Indexes for table `cabang_or`
--
ALTER TABLE `cabang_or`
  ADD PRIMARY KEY (`cabang_or_id`);

--
-- Indexes for table `mt_olahraga`
--
ALTER TABLE `mt_olahraga`
  ADD PRIMARY KEY (`id_mt_olahraga`);

--
-- Indexes for table `sorttempat`
--
ALTER TABLE `sorttempat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tempat` (`id_tempat`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_level` (`id_level`);

--
-- Indexes for table `tempat`
--
ALTER TABLE `tempat`
  ADD PRIMARY KEY (`id_tempat`);

--
-- Indexes for table `tmp_user`
--
ALTER TABLE `tmp_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `user_level`
--
ALTER TABLE `user_level`
  ADD PRIMARY KEY (`id_level`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cabang_jenis_or`
--
ALTER TABLE `cabang_jenis_or`
  MODIFY `cabang_jenis_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `cabang_or`
--
ALTER TABLE `cabang_or`
  MODIFY `cabang_or_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `mt_olahraga`
--
ALTER TABLE `mt_olahraga`
  MODIFY `id_mt_olahraga` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tempat`
--
ALTER TABLE `tempat`
  MODIFY `id_tempat` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT for table `user_level`
--
ALTER TABLE `user_level`
  MODIFY `id_level` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cabang_jenis_or`
--
ALTER TABLE `cabang_jenis_or`
  ADD CONSTRAINT `FK5sfmt4hi27ou7sebpcxar8lrn` FOREIGN KEY (`cabang_or_id`) REFERENCES `cabang_or` (`cabang_or_id`),
  ADD CONSTRAINT `FKlinwbe6mkfchgartpdlp73lsa` FOREIGN KEY (`cabang_jenis_id`) REFERENCES `cabang_tempat` (`jenis_tempat_id`),
  ADD CONSTRAINT `FKs0300fwpa534nm9j6vypxkh7q` FOREIGN KEY (`cabang_or_id`) REFERENCES `cabang_tempat` (`jenis_tempat_id`);

--
-- Constraints for table `cabang_or`
--
ALTER TABLE `cabang_or`
  ADD CONSTRAINT `FKr809okf87ftkwrmlj07lxq7fq` FOREIGN KEY (`cabang_or_id`) REFERENCES `cabang_jenis_or` (`cabang_jenis_id`);

--
-- Constraints for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`id_level`) REFERENCES `user_level` (`id_level`);

--
-- Constraints for table `tempat`
--
ALTER TABLE `tempat`
  ADD CONSTRAINT `FKnfejidapdjxhapoxou5jdh5dv` FOREIGN KEY (`id_tempat`) REFERENCES `cabang_tempat` (`jenis_tempat_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
