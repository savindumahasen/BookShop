-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 11, 2022 at 02:41 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookshopdetails`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `UserID` int(10) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `Account` varchar(10) NOT NULL,
  `Gender` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`UserID`, `Password`, `FirstName`, `LastName`, `Account`, `Gender`) VALUES
(1200, 'wjecje', ' mcf ', 'c m v', 'manager', 'Male'),
(12001, 'mdd', 'cmn ', 'm d ', 'm. d ', 'Male'),
(19087, 'Himalika1', 'Himalika', 'Ruhunuhewa', 'Cashier', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `bookcategory`
--

CREATE TABLE `bookcategory` (
  `BookID` int(10) NOT NULL,
  `BookName` varchar(20) NOT NULL,
  `Category` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookcategory`
--

INSERT INTO `bookcategory` (`BookID`, `BookName`, `Category`) VALUES
(1098, 'DavinchiCode1', 'Adventure'),
(1234, 'SherlockHomes', 'Adventure');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `BookID` int(10) NOT NULL,
  `BookName` varchar(50) NOT NULL,
  `Category` varchar(30) NOT NULL,
  `Price` double NOT NULL,
  `Author` varchar(50) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `PublisherDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`BookID`, `BookName`, `Category`, `Price`, `Author`, `Description`, `PublisherDate`) VALUES
(2345, 'Harrypotter', 'Fairy tales', 200, 'R.K.Rowling', 'this is very fantastic story', '2001-11-18'),
(1234, 'Adventure of TinTin', 'Adventure ', 100, 'R.k.Daniel', 'this is very adventure and intersting book.', '2000-11-18'),
(9990, 'Anebella', 'Horror', 800, 'R.Q,Spill', 'It is verry horror', '1997-10-10'),
(2000, 'Games of thrones', 'Adventure', 200, 'J.James', 'it is very atractive and adventure story', '2000-11-18'),
(1786, 'Peter Rabbits', 'Fantasy', 100, 'R.swing', 'it is very fantacy story', '2000-11-10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `UserID` (`UserID`);

--
-- Indexes for table `bookcategory`
--
ALTER TABLE `bookcategory`
  ADD PRIMARY KEY (`BookID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
