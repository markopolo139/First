
CREATE TABLE `calls` (
  `call_id` mediumint(9) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `location` varchar(60) NOT NULL,
  `details` varchar(150) DEFAULT NULL,
  `type` ENUM('FIRE','LOCAL_THREAT','TRAINING','FALSE_ALARM','SECURE_REGION') NOT NULL
);

CREATE TABLE `equipment` (
  `equipment_id` mediumint(9) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `serial_number` varchar(200) NOT NULL
) ;

CREATE TABLE `fire_trucks` (
  `fire_truck_id` mediumint(9) NOT NULL,
  `name` varchar(30) NOT NULL,
  `price` float NOT NULL,
  `vin` varchar(17) NOT NULL,
  `production_year` int(11) NOT NULL,
  `operational_numbers` varchar(6) NOT NULL,
  `type` varchar(20) NOT NULL,
  `horsepower` int(11) NOT NULL,
  `number_of_seats` int(11) NOT NULL,
  `mileage` int(11) NOT NULL
);

CREATE TABLE `fire_trucks_in_action` (
  `call_id` mediumint(9) NOT NULL,
  `fire_truck_id` mediumint(9) NOT NULL
);

CREATE TABLE `fire_truck_parameters` (
  `fire_truck_id` mediumint(9) NOT NULL,
  `parameter` varchar(50) NOT NULL,
  `value` varchar(50) NOT NULL
);

CREATE TABLE `fire_truck_services` (
  `fire_truck_services_id` mediumint(9) NOT NULL,
  `fire_truck_id` mediumint(9) NOT NULL,
  `service_date` date NOT NULL,
  `cost` float NOT NULL,
  `description` varchar(150) NOT NULL
);

CREATE TABLE `staff_members` (
  `staff_member_id` mediumint(9) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `joining_date` date NOT NULL,
  `pesel` varchar(11) NOT NULL,
  `address` varchar(40) NOT NULL,
  `city` varchar(30) NOT NULL,
  `periodic_examinations_expiry_date` date DEFAULT NULL,
  `is_driver` tinyint(1) NOT NULL DEFAULT 0,
  `birthdate` date NOT NULL,
  `blood_type` ENUM('O_PLUS','O_MINUS','A_PLUS','A_MINUS','B_PLUS','B_MINUS','AB_PLUS','AB_MINUS') not null,
  `email` varchar(60) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL
);

CREATE TABLE `staff_members_in_action` (
  `call_id` mediumint(9) NOT NULL,
  `staff_member_id` mediumint(9) NOT NULL
);

CREATE TABLE `trainings` (
  `training_id` mediumint(9) NOT NULL,
  `training_date` date NOT NULL,
  `expiration_date` date DEFAULT NULL,
  `training_type` ENUM('BASIC',
                              'QUALIFIED_FIRST_AID',
                              'TECHNICAL_RESCUE',
                              'ANTI_FLOOD_AND_WATER_RESCUE',
                              'MAINTENANCE_DRIVER_RESCUE_EQUIPMENT',
                              'LEADERS',
                              'HEADERS',
                              'COMMUNE_COMMANDER',
                              'LIFT',
                              'CHEM_ECO_RESCUE',
                              'SEARCH_AND_RESCUE',
                              'HIGH_ALTITUDE_RESCUE',
                              'LADDER',
                              'HELMSMAN',
                              'SAWMAN') NOT NULL,
  `staff_member_id` mediumint(9) NOT NULL
);

ALTER TABLE `calls`
  ADD PRIMARY KEY (`call_id`);

ALTER TABLE `equipment`
  ADD PRIMARY KEY (`equipment_id`);

ALTER TABLE `fire_trucks`
  ADD PRIMARY KEY (`fire_truck_id`);

ALTER TABLE `fire_trucks_in_action`
  ADD UNIQUE KEY `call_id_fire_truck_id` (`call_id`,`fire_truck_id`),
  ADD KEY `fire_trucks_in_action_call_fk` (`call_id`),
  ADD KEY `fire_trucks_in_action_fire_truck_fk` (`fire_truck_id`);

ALTER TABLE `fire_truck_parameters`
  ADD UNIQUE KEY `fire_truck_id_parameter` (`fire_truck_id`,`parameter`),
  ADD KEY `fire_truck_parameters_fire_truck_fk` (`fire_truck_id`);

ALTER TABLE `fire_truck_services`
  ADD PRIMARY KEY (`fire_truck_services_id`),
  ADD KEY `fire_truck_services_fire_truck_fk` (`fire_truck_id`);

ALTER TABLE `staff_members`
  ADD PRIMARY KEY (`staff_member_id`);

ALTER TABLE `staff_members_in_action`
  ADD UNIQUE KEY `call_id_staff_member_id` (`call_id`,`staff_member_id`),
  ADD KEY `staff_members_in_action_call_fk` (`call_id`),
  ADD KEY `staff_members_in_action_staff_members_fk` (`staff_member_id`);

ALTER TABLE `trainings`
  ADD PRIMARY KEY (`training_id`),
  ADD KEY `trainings_staff_member_id_index` (`staff_member_id`);

ALTER TABLE `calls`
  MODIFY `call_id` mediumint(9) NOT NULL AUTO_INCREMENT;

ALTER TABLE `equipment`
  MODIFY `equipment_id` mediumint(9) NOT NULL AUTO_INCREMENT;

ALTER TABLE `fire_trucks`
  MODIFY `fire_truck_id` mediumint(9) NOT NULL AUTO_INCREMENT;

ALTER TABLE `fire_truck_parameters`
  MODIFY `fire_truck_id` mediumint(9) NOT NULL AUTO_INCREMENT;

ALTER TABLE `fire_truck_services`
  MODIFY `fire_truck_services_id` mediumint(9) NOT NULL AUTO_INCREMENT;

ALTER TABLE `staff_members`
  MODIFY `staff_member_id` mediumint(9) NOT NULL AUTO_INCREMENT;

ALTER TABLE `trainings`
  MODIFY `training_id` mediumint(9) NOT NULL AUTO_INCREMENT;

ALTER TABLE `fire_trucks_in_action`
  ADD CONSTRAINT `fire_trucks_in_action_calls_fk` FOREIGN KEY (`call_id`) REFERENCES `calls` (`call_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fire_trucks_in_action_fire_trucks_fk` FOREIGN KEY (`fire_truck_id`) REFERENCES `fire_trucks` (`fire_truck_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `fire_truck_parameters`
  ADD CONSTRAINT `fire_truck_parameters_fire_trucks_fk` FOREIGN KEY (`fire_truck_id`) REFERENCES `fire_trucks` (`fire_truck_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `fire_truck_services`
  ADD CONSTRAINT `fire_truck_services_fire_trucks_fk` FOREIGN KEY (`fire_truck_id`) REFERENCES `fire_trucks` (`fire_truck_id`);

ALTER TABLE `staff_members_in_action`
  ADD CONSTRAINT `staff_members_in_action_calls_fk` FOREIGN KEY (`call_id`) REFERENCES `calls` (`call_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `staff_members_in_action_staff_members_fk` FOREIGN KEY (`staff_member_id`) REFERENCES `staff_members` (`staff_member_id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `trainings`
  ADD CONSTRAINT `trainings_staff_members_fk` FOREIGN KEY (`staff_member_id`) REFERENCES `staff_members` (`staff_member_id`) ON DELETE CASCADE ON UPDATE CASCADE;