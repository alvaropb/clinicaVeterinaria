CREATE TABLE `revision` (
  `fecha_revision` date NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `motivo_revision` varchar(100) NOT NULL,
  `diagnostico` varchar(100) NOT NULL,
  `tratamiento` varchar(100) NOT NULL,
  `id_animal` int(11) NOT NULL,
  `id_revision` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_revision`),
  KEY `id_animal` (`id_animal`),
  CONSTRAINT `revision_ibfk_1` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8