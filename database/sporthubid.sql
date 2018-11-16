-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Nov 2018 pada 08.42
-- Versi server: 10.1.32-MariaDB
-- Versi PHP: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sporthubid`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(12);

-- --------------------------------------------------------

--
-- Struktur dari tabel `mt_olahraga`
--

CREATE TABLE `mt_olahraga` (
  `id_mt_olahraga` int(11) NOT NULL,
  `nama_olahraga` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(11) NOT NULL,
  `id_level` int(5) DEFAULT NULL,
  `f_nama` varchar(50) DEFAULT NULL,
  `l_nama` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `tmp_lahir` varchar(60) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `jenis_kelamin` enum('L','P') DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL,
  `minat_or` varchar(150) DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `status` tinyint(2) DEFAULT NULL,
  `flag_hapus` tinyint(2) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `id_level`, `f_nama`, `l_nama`, `alamat`, `tmp_lahir`, `tgl_lahir`, `jenis_kelamin`, `email`, `no_hp`, `minat_or`, `username`, `password`, `status`, `flag_hapus`, `created_at`, `updated_at`) VALUES
(1, 1, 'Super Administrator', '', '', '', '0000-00-00', 'L', '', '', '', 'adminsporthub', '1de60b7b34ac0e140cefeddf600e149478c5e532', 1, 0, '2018-11-07 04:19:08', '2018-11-06 17:00:00'),
(2, 4, 'Ikhsan', 'Fauji', 'Nusawungu, Cilacap', 'Cilacap', '1996-03-11', 'L', 'ikhsan3f@gmail.com', '085726364134', NULL, 'ikhsan', '12345', 1, 0, '2018-11-10 09:38:23', NULL),
(4, 4, 'Galih', NULL, NULL, NULL, NULL, 'L', 'galih@gmail.com', NULL, NULL, 'galih', '12345', 1, NULL, '2018-11-10 12:41:54', NULL),
(11, 4, 'Shincan', NULL, NULL, NULL, NULL, 'P', 'proyektest@gmail.com', NULL, NULL, 'sincan', '12345', 1, NULL, '2018-11-13 06:34:38', NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_level`
--

CREATE TABLE `user_level` (
  `id_level` int(5) NOT NULL,
  `level` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user_level`
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
-- Stand-in struktur untuk tampilan `v_user`
-- (Lihat di bawah untuk tampilan aktual)
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
-- Struktur untuk view `v_user`
--
DROP TABLE IF EXISTS `v_user`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_user`  AS  select `user`.`id_user` AS `id_user`,`user`.`id_level` AS `id_level`,`user`.`username` AS `username`,`user`.`password` AS `password`,`user`.`status` AS `status`,`level`.`level` AS `level` from (`tb_user` `user` join `user_level` `level`) where ((`user`.`id_level` = `level`.`id_level`) and (`user`.`id_level` is not null) and (`user`.`status` = 1)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mt_olahraga`
--
ALTER TABLE `mt_olahraga`
  ADD PRIMARY KEY (`id_mt_olahraga`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_level` (`id_level`);

--
-- Indeks untuk tabel `user_level`
--
ALTER TABLE `user_level`
  ADD PRIMARY KEY (`id_level`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `mt_olahraga`
--
ALTER TABLE `mt_olahraga`
  MODIFY `id_mt_olahraga` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `user_level`
--
ALTER TABLE `user_level`
  MODIFY `id_level` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`id_level`) REFERENCES `user_level` (`id_level`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
