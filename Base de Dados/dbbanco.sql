-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 23-Abr-2018 às 15:37
-- Versão do servidor: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbbanco`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `cliente_id` int(11) NOT NULL,
  `tipo_de_cliente` varchar(20) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cc` varchar(20) NOT NULL,
  `morada` varchar(100) NOT NULL,
  `profissão` varchar(30) NOT NULL,
  `telefones` int(11) NOT NULL,
  `email` varchar(40) NOT NULL,
  `contas` int(11) NOT NULL,
  `cartões` int(11) NOT NULL,
  `contas_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cliente_id`),
  ADD KEY `cliente_id` (`cliente_id`),
  ADD KEY `cliente_id_2` (`cliente_id`),
  ADD KEY `contas_id` (`contas_id`),
  ADD KEY `cliente_id_3` (`cliente_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
