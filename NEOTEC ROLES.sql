DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `rol` VARCHAR(20) NOT NULL DEFAULT 'CLIENTE',
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insertar datos
INSERT INTO `usuarios` (`id`, `usuario`, `password`, `rol`) VALUES
(1, 'admin', '12345', 'ADMIN'),
(2, 'eariza', '12345', 'CLIENTE'),
(3, 'bvega', '1234', 'ADMIN');
