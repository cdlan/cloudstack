CREATE TABLE IF NOT EXISTS `cloud`.`wg_vpn` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `uuid` varchar(40) UNIQUE,
    `address` varchar(255) NOT NULL,
    `prefix` int unsigned NOT NULL,
    `server_private_kay` varchar(255) NOT NULL,
    `server_public_key` varchar(255) NOT NULL,
    `state` varchar(40) NOT NULL,
    `account_id` bigint unsigned NOT NULL,
    `created` datetime NOT NULL COMMENT 'date of creation',
    `removed` datetime COMMENT 'date of removal',
    PRIMARY KEY (`id`),
    KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;