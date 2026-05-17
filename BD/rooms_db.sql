-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2026 at 12:12 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rooms_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `id` bigint(20) NOT NULL,
  `amenities` text DEFAULT NULL,
  `available` bit(1) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `image_url` text DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `surface` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `owner_id` bigint(20) NOT NULL,
  `owner_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`id`, `amenities`, `available`, `capacity`, `description`, `image_url`, `location`, `price`, `surface`, `title`, `type`, `owner_id`, `owner_name`) VALUES
(1, 'WiFi, Climatisation, Bureau, Accès cuisine', b'1', 1, 'Chambre privée dans un appartement moderne au cœur de Guéliz. À 5 minutes des commerces et des transports. Parfait pour étudiant ou professionnel.', 'https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?ixlib=rb-4.0.3&w=600', 'Marrakech, Guéliz', 350, 18, 'Chambre Lumineuse Guéliz', 'Chambre', 3, 'Youssef Alaoui'),
(2, 'WiFi, TV, Climatisation, Cuisine équipée, Machine à laver', b'1', 2, 'Beau studio entièrement équipé au quartier Guéliz. Proche cafés, restaurants et supermarchés.', 'https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?ixlib=rb-4.0.3&w=600', 'Marrakech, Guéliz', 500, 28, 'Studio Confortable Guéliz', 'Studio', 3, 'Youssef Alaoui'),
(3, 'WiFi, Climatisation, Salle de bain privée, Balcon, Parking', b'1', 2, 'Suite spacieuse avec balcon offrant une vue dégagée sur le quartier Agdal. Idéal pour un couple ou voyageur d’affaires.', 'https://images.unsplash.com/photo-1586023492125-27b2c045efd7?ixlib=rb-4.0.3&w=600', 'Marrakech, Agdal', 750, 35, 'Grande Suite Parentale Agdal', 'Suite', 3, 'Youssef Alaoui'),
(4, 'WiFi, TV, Climatisation, Cuisine complète, Lave-linge, Balcon', b'1', 4, 'Appartement familial entièrement rénové avec deux chambres, salon et cuisine américaine. Vue sur les jardins de l\'Agdal.', 'https://images.unsplash.com/photo-1585412727339-54e4bae3bbf9?ixlib=rb-4.0.3&w=600', 'Marrakech, Agdal', 1200, 65, 'Appartement Familial Agdal', 'Appartement', 3, 'Youssef Alaoui'),
(5, 'WiFi, Ventilateur, Petit-déjeuner inclus', b'1', 1, 'Chambre simple au sein d\'un riad traditionnel dans la médina de Fès. Ambiance authentique et petit-déjeuner marocain offert.', 'https://images.unsplash.com/photo-1595526114035-0d45ed16cfbf?ixlib=rb-4.0.3&w=600', 'Marrakech, Médina', 200, 14, 'Chambre Économique Médina', 'Chambre', 3, 'Youssef Alaoui'),
(6, 'WiFi, Climatisation, TV, Cuisine équipée, Salle de sport', b'0', 2, 'Studio design au bord de la Marina. Résidence sécurisée avec piscine et salle de sport communes.', 'https://images.unsplash.com/photo-1560185007-cde436f6a4d0?ixlib=rb-4.0.3&w=600', 'Marrakech, Palmeraie', 600, 32, 'Studio Design Marina', 'Studio', 3, 'Youssef Alaoui'),
(7, 'WiFi, Climatisation, Balcon, Accès piscine', b'1', 2, 'Chambre avec balcon donnant sur le jardin. Située à 10 minutes de la place Jemaa el-Fna et proche des restaurants.', 'https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?ixlib=rb-4.0.3&w=600', 'Marrakech, Kasbah', 400, 20, 'Chambre Vue Jardin Kasbah', 'Chambre', 3, 'Youssef Alaoui'),
(8, 'WiFi, TV, Climatisation, Cuisine équipée, Parking, Jardin, Gardien', b'1', 4, 'Magnifique appartement de standing à l\'Hivernage. Deux chambres, grand salon, cuisine moderne, jardin privatif.', 'https://images.unsplash.com/photo-1600585154340-be6161a56a0c?ixlib=rb-4.0.3&w=600', 'Marrakech, Hivernage', 1500, 80, 'Appartement Haut Standing Hivernage', 'Appartement', 3, 'Youssef Alaoui'),
(9, 'WiFi, Bureau, Kitchenette', b'1', 1, 'Studio parfait pour un étudiant. Proche de l\'université Cadi Ayyad et des transports. Calme et fonctionnel.', 'https://images.unsplash.com/photo-1598928506311-c55ded91a20c?w=1600&q=80', 'Marrakech, Guéliz', 250, 15, 'Petit Studio Étudiant Guéliz', 'Studio', 3, 'Youssef Alaoui'),
(10, 'WiFi, Climatisation, Piscine, Petit-déjeuner', b'1', 2, 'Chambre cosy dans une villa de la Palmeraie. Accès à la piscine et au jardin. Petit-déjeuner marocain inclus.', 'https://images.unsplash.com/photo-1540518614846-7eded433c457?ixlib=rb-4.0.3&w=600', 'Marrakech, Palmeraie', 450, 22, 'Chambre Cosy Palmeraie', 'Chambre', 4, 'Fatima Benali'),
(11, 'WiFi, TV, Climatisation, Cuisine, Terrasse, Parking', b'1', 5, 'Duplex lumineux avec terrasse offrant une vue panoramique sur l\'Atlas. 3 chambres, séjour spacieux.', 'https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?ixlib=rb-4.0.3&w=600', 'Marrakech, Targa', 1300, 70, 'Duplex Vue Panoramique Targa', 'Appartement', 4, 'Fatima Benali'),
(12, 'WiFi, Ventilateur, Salon commun, Cuisine', b'1', 1, 'Chambre calme dans un appartement partagé. Décoration zen, idéale pour se reposer. Proche du centre-ville.', 'https://images.unsplash.com/photo-1505691938895-1758d7feb511?ixlib=rb-4.0.3&w=600', 'Marrakech, Guéliz', 300, 16, 'Chambre Zen Oasis Guéliz', 'Chambre', 4, 'Fatima Benali'),
(13, 'WiFi, TV, Climatisation, Cuisine, Lave-linge, Balcon', b'1', 4, 'Appartement familial à proximité de la place Jemaa el-Fna et des souks. Idéal pour des vacances en famille.', 'https://images.unsplash.com/photo-1567767292278-a4f21aa2d36e?ixlib=rb-4.0.3&w=600', 'Marrakech, Médina', 850, 55, 'Appartement Familial Médina', 'Appartement', 4, 'Fatima Benali'),
(14, 'WiFi, Climatisation, TV, Kitchenette, Salle de bain italienne', b'0', 2, 'Studio de luxe dans le quartier de l’Hivernage. Résidence avec piscine et spa. Service hôtelier disponible.', 'https://images.unsplash.com/photo-1574362848149-11496d93a7c7?ixlib=rb-4.0.3&w=600', 'Marrakech, Hivernage', 700, 30, 'Studio Luxe Hivernage', 'Studio', 4, 'Fatima Benali'),
(15, 'WiFi, Climatisation, Salle de bain privée, Décoration traditionnelle', b'1', 2, 'Chambre authentique dans un riad de charme au cœur de la médina.', 'https://images.unsplash.com/photo-1611892440504-42a792e24d32?w=600', 'Marrakech, Médina', 380, 20, 'Chambre Riad Traditionnel', 'Chambre', 4, 'Fatima Benali'),
(17, 'WiFi, Climatisation, TV, Kitchenette, Décoration marocaine chic', b'1', 2, 'Studio élégant avec touches marocaines modernes dans le quartier chic de Guéliz.', 'https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?w=600', 'Marrakech, Guéliz', 550, 30, 'Studio Moroccan Chic Guéliz', 'Studio', 4, 'Fatima Benali'),
(18, 'WiFi, Ventilateur, Petit-déjeuner inclus, Salle de bain partagée', b'1', 1, 'Chambre simple et authentique dans un riad traditionnel de la médina.', 'https://images.unsplash.com/photo-1598928506311-c55ded91a20c?w=600', 'Marrakech, Médina', 220, 12, 'Chambre Riad Médina Authentique', 'Chambre', 4, 'Fatima Benali'),
(20, 'WiFi, Climatisation, TV, Minibar, Balcon vue mer, Service chambre', b'1', 2, 'Suite luxueuse avec vue panoramique sur la piscine et le jardin.', 'https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?w=600', 'Marrakech, Palmeraie', 1200, 40, 'Suite Vue Piscine Premium', 'Suite', 2, 'Chaima Hassani'),
(21, 'WiFi, Climatisation, TV, Cuisine équipée, Parking, Terrasse', b'1', 6, 'Villa spacieuse dans un domaine privé de la Palmeraie.', 'https://images.unsplash.com/photo-1600585154340-be6161a56a0c?w=600', 'Marrakech, Palmeraie', 1800, 120, 'Villa Palmeraie Familiale', 'Appartement', 2, 'Chaima Hassani'),
(22, 'WiFi, Climatisation, TV, Kitchenette, Salle de sport, Piscine', b'1', 2, 'Studio design dans une résidence neuve avec piscine à Guéliz.', 'https://images.unsplash.com/photo-1595526114035-0d45ed16cfbf?w=600', 'Marrakech, Guéliz', 280, 18, 'Studio Résidence Étudiante Guéliz', 'Studio', 2, 'Chaima Hassani'),
(23, 'WiFi, Climatisation, TV, Spa, Piscine, Restaurant, Service voiturier', b'1', 2, 'Suite présidentielle avec vue sur les jardins de l\'Agdal.', 'https://images.unsplash.com/photo-1574362848149-11496d93a7c7?w=600', 'Marrakech, Agdal', 3500, 85, 'Suite Présidentielle Agdal', 'Suite', 2, 'Chaima Hassani'),
(24, 'WiFi, Ventilateur, Terrasse, Petit-déjeuner inclus', b'1', 2, 'Chambre colorée dans un riad traditionnel de la médina.', 'https://images.unsplash.com/photo-1540518614846-7eded433c457?w=600', 'Marrakech, Médina', 300, 16, 'Chambre Colorée Médina', 'Chambre', 2, 'Chaima Hassani'),
(25, 'WiFi, TV, Climatisation, Cuisine complète, Terrasse, Parking', b'1', 4, 'Maison de vacances familiale à Targa avec patio intérieur.', 'https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?w=600', 'Marrakech, Targa', 950, 70, 'Maison Vacances Targa', 'Appartement', 2, 'Chaima Hassani'),
(26, 'WiFi, Climatisation, TV, Kitchenette, Balcon, Accès piscine', b'1', 2, 'Appartement contemporain dans le quartier d\'affaires de Guéliz.', 'https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?w=600', 'Marrakech, Guéliz', 750, 38, 'Appartement Contemporain Guéliz', 'Appartement', 2, 'Chaima Hassani'),
(27, 'WiFi, Climatisation, TV, Cuisine, Terrasse panoramique, Parking', b'1', 5, 'Duplex spacieux dans la kasbah de Marrakech.', 'https://images.unsplash.com/photo-1585412727339-54e4bae3bbf9?w=600', 'Marrakech, Kasbah', 1100, 65, 'Duplex Kasbah Marrakech', 'Appartement', 2, 'Chaima Hassani'),
(28, 'WiFi, Ventilateur, Salon marocain, Terrasse, Petit-déjeuner', b'1', 2, 'Chambre élégante dans un riad de la Palmeraie.', 'https://images.unsplash.com/photo-1567767292278-a4f21aa2d36e?w=600', 'Marrakech, Palmeraie', 500, 24, 'Chambre Riad Palmeraie Élégance', 'Chambre', 2, 'Chaima Hassani');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','CLIENT','OWNER') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `city`, `created_at`, `email`, `full_name`, `password`, `phone`, `role`) VALUES
(1, 'Marrakech', '2026-05-12 18:26:37.000000', 'chaima@gmail.com', 'chaima', '$2a$10$1hL14xSOnaUdrO7Z9zca.uTG8gh2N6gVTo06cmfqWS0N4Xuykun.e', NULL, 'CLIENT'),
(2, 'Marrakech', '2026-05-12 18:27:21.000000', 'chaimah@gmail.com', 'Chaima Hassani', '$2b$10$7u3jKAOITwJjkWjmfnJwe.FIcMJQSZQnHnXNhN.302CLrbCXuS7AW', '+212 6 23 45 67 89', 'OWNER'),
(3, 'Marrakech', '2026-05-13 21:04:41.000000', 'youssef.alaoui@email.com', 'Youssef Alaoui', '$2b$10$7xJ8HCOcF5byqsstWkoxUeXxKWIV8N4PYTV4AxMOoyNbeui8/ABna', '+212 6 34 56 78 90', 'OWNER'),
(4, 'Marrakech', '2026-05-13 21:04:41.000000', 'fatima.benali@email.com', 'Fatima Benali', '$2b$10$5pVihCdGQzXM3IZTLZ2hJe6NrAIEDr0OeH5HEW9GcSnRBMoh5RA2u', '+212 6 45 67 89 01', 'OWNER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
