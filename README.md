# wizard

<h3>Full installation instruction</h3>

1. Use MySql 8
2. Set up DB:
<xmp>
CREATE DATABASE IF NOT EXISTS `indorse_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `indorse_db`;

-- Dumping structure for table indorse_db.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table indorse_db.rol: ~0 rows (approximately)
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id_rol`, `name`) VALUES
	(1, 'customer');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Dumping structure for table indorse_db.user
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '0',
  `token` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table indorse_db.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table indorse_db.user_rol
CREATE TABLE IF NOT EXISTS `user_rol` (
  `id_user_rol` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL DEFAULT '0',
  `id_rol` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user_rol`),
  KEY `user_rol_pk1` (`id_user`),
  KEY `user_rol_pk2` (`id_rol`),
  CONSTRAINT `user_rol_pk1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  CONSTRAINT `user_rol_pk2` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE USER 'indorse'@'localhost' IDENTIFIED BY 'indorse';
GRANT EXECUTE, PROCESS, SELECT, SHOW DATABASES, SHOW VIEW, INSERT, DELETE, UPDATE  ON *.* TO 'indorse'@'localhost';
</xmp>

3. If you need to change database host or port go to file ApplicationContextConfig.java 




