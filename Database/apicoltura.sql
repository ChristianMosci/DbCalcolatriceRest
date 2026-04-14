-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Apr 14, 2026 alle 12:48
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apicoltura`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `apiario`
--

CREATE TABLE `apiario` (
  `api_id` int(11) NOT NULL,
  `api_luogo` varchar(50) DEFAULT NULL,
  `api_lat` varchar(50) DEFAULT NULL,
  `api_lon` varchar(50) DEFAULT NULL,
  `api_nome` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `arnia`
--

CREATE TABLE `arnia` (
  `arn_id` int(11) NOT NULL,
  `arn_dataInst` date DEFAULT NULL,
  `arn_piena` tinyint(1) DEFAULT NULL,
  `arn_MacAddress` varchar(50) DEFAULT NULL,
  `api_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `notifica`
--

CREATE TABLE `notifica` (
  `not_id` int(11) NOT NULL,
  `not_titolo` varchar(50) DEFAULT NULL,
  `not_desc` varchar(50) DEFAULT NULL,
  `ril_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `rilevazione`
--

CREATE TABLE `rilevazione` (
  `ril_id` int(11) NOT NULL,
  `ril_dato` float DEFAULT NULL,
  `ril_dataOra` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `sen_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `sensore`
--

CREATE TABLE `sensore` (
  `sen_id` int(11) NOT NULL,
  `sen_stato` tinyint(1) DEFAULT NULL,
  `sen_min` float DEFAULT NULL,
  `sen_max` float DEFAULT NULL,
  `arn_id` int(11) DEFAULT NULL,
  `tip_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `tipo`
--

CREATE TABLE `tipo` (
  `tip_id` int(11) NOT NULL,
  `tip_descrizione` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `ute_id` int(11) NOT NULL,
  `ute_username` varchar(50) NOT NULL,
  `ute_password` varchar(128) NOT NULL,
  `ute_token` varchar(5) DEFAULT NULL,
  `ute_scadenzaToken` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ute_admin` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `apiario`
--
ALTER TABLE `apiario`
  ADD PRIMARY KEY (`api_id`);

--
-- Indici per le tabelle `arnia`
--
ALTER TABLE `arnia`
  ADD PRIMARY KEY (`arn_id`),
  ADD KEY `api_id` (`api_id`);

--
-- Indici per le tabelle `notifica`
--
ALTER TABLE `notifica`
  ADD PRIMARY KEY (`not_id`),
  ADD UNIQUE KEY `ril_id` (`ril_id`);

--
-- Indici per le tabelle `rilevazione`
--
ALTER TABLE `rilevazione`
  ADD PRIMARY KEY (`ril_id`),
  ADD KEY `sen_id` (`sen_id`);

--
-- Indici per le tabelle `sensore`
--
ALTER TABLE `sensore`
  ADD PRIMARY KEY (`sen_id`),
  ADD KEY `arn_id` (`arn_id`),
  ADD KEY `tip_id` (`tip_id`);

--
-- Indici per le tabelle `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`tip_id`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`ute_id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `apiario`
--
ALTER TABLE `apiario`
  MODIFY `api_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `arnia`
--
ALTER TABLE `arnia`
  MODIFY `arn_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `notifica`
--
ALTER TABLE `notifica`
  MODIFY `not_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `rilevazione`
--
ALTER TABLE `rilevazione`
  MODIFY `ril_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `sensore`
--
ALTER TABLE `sensore`
  MODIFY `sen_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `tipo`
--
ALTER TABLE `tipo`
  MODIFY `tip_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `ute_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `arnia`
--
ALTER TABLE `arnia`
  ADD CONSTRAINT `arnia_ibfk_1` FOREIGN KEY (`api_id`) REFERENCES `apiario` (`api_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `notifica`
--
ALTER TABLE `notifica`
  ADD CONSTRAINT `notifica_ibfk_1` FOREIGN KEY (`ril_id`) REFERENCES `rilevazione` (`ril_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `rilevazione`
--
ALTER TABLE `rilevazione`
  ADD CONSTRAINT `rilevazione_ibfk_1` FOREIGN KEY (`sen_id`) REFERENCES `sensore` (`sen_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `sensore`
--
ALTER TABLE `sensore`
  ADD CONSTRAINT `sensore_ibfk_1` FOREIGN KEY (`arn_id`) REFERENCES `arnia` (`arn_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sensore_ibfk_2` FOREIGN KEY (`tip_id`) REFERENCES `tipo` (`tip_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
