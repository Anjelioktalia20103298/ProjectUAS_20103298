-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 29 Jun 2022 pada 18.31
-- Versi server: 10.4.19-MariaDB
-- Versi PHP: 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbmhs`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dosen`
--

CREATE TABLE `dosen` (
  `NIDN` varchar(15) NOT NULL,
  `NAMA_DOSEN` varchar(40) NOT NULL,
  `ALAMAT` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dosen`
--

INSERT INTO `dosen` (`NIDN`, `NAMA_DOSEN`, `ALAMAT`) VALUES
('11223344', 'Anjeli Oktalia, S.Kom., M.Kom', 'Lombok Timur'),
('11223345', 'Ni Putu Eka Sepiantini, S.kom., M.Kom', 'Gianyar'),
('11223346', 'Andika hairil Padli, S.Kom., M.Kom', 'Denpasar Selatan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `matkul`
--

CREATE TABLE `matkul` (
  `ID` varchar(12) NOT NULL,
  `MATKUL` varchar(40) NOT NULL,
  `ID_DOSEN` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `matkul`
--

INSERT INTO `matkul` (`ID`, `MATKUL`, `ID_DOSEN`) VALUES
('1234567', 'Algoritma Pemerograman', '11223344'),
('1234568', 'Mobile Programing', '11223345'),
('1234569', 'Pemerograman Web ', '11223346');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mhs`
--

CREATE TABLE `mhs` (
  `NIM` varchar(8) NOT NULL,
  `NAMA` varchar(25) DEFAULT NULL,
  `JURUSAN` varchar(15) DEFAULT NULL,
  `JK` varchar(1) DEFAULT NULL,
  `TGLLAHIR` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mhs`
--

INSERT INTO `mhs` (`NIM`, `NAMA`, `JURUSAN`, `JK`, `TGLLAHIR`) VALUES
('20103290', 'Andika Hairil Padli', 'SK', 'L', '2001-10-10'),
('20103295', 'Ni Putu Eka Sepiantini', 'KAB', 'P', '2002-04-12'),
('20103298', 'Anjeli Oktalia', 'KAB', 'P', '2001-10-15');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`NIDN`);

--
-- Indeks untuk tabel `matkul`
--
ALTER TABLE `matkul`
  ADD PRIMARY KEY (`ID`);

--
-- Indeks untuk tabel `mhs`
--
ALTER TABLE `mhs`
  ADD PRIMARY KEY (`NIM`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
