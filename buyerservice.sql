-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 10:36 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyerservice`
--

CREATE TABLE `buyerservice` (
  `ID` int(20) NOT NULL,
  `FullName` varchar(255) NOT NULL,
  `PhoneNumber` varchar(10) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Birthdate` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyerservice`
--

INSERT INTO `buyerservice` (`ID`, `FullName`, `PhoneNumber`, `Email`, `Address`, `Birthdate`) VALUES
(3, 'devaj', '011587458', 'devaj@gmail.com', 'Jaffana', '95/5/4'),
(4, 'kasu', '07541748', 'asd@gmail.com', 'kandy', '98/5/4'),
(5, 'Amal Kavindha', '077541869', 'amalk@gmail.com', '61/2 Rajagiriya Road, Colombo', '1998/10/25');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyerservice`
--
ALTER TABLE `buyerservice`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyerservice`
--
ALTER TABLE `buyerservice`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
