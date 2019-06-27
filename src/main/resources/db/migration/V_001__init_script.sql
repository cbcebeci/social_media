CREATE database if NOT EXISTS project_db;

CREATE TABLE `users` (
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(2555) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);


CREATE TABLE `user_profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `gender` VARCHAR(10) NULL,
  `date_of_birth` DATETIME NULL,
  `profile_image_url` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `username`
    FOREIGN KEY (`email`)
    REFERENCES `users` (`username`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);



CREATE TABLE `post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `profile_id` INT NOT NULL,
  `post` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`profile_id` ASC) VISIBLE,
  CONSTRAINT `id`
    FOREIGN KEY (`profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);



CREATE TABLE `friends` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sender_profile_id` INT NOT NULL,
  `receiver_profile_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`sender_profile_id` ASC) VISIBLE,
  INDEX `id_idx1` (`receiver_profile_id` ASC) VISIBLE,
  CONSTRAINT `id1`
    FOREIGN KEY (`sender_profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id2`
    FOREIGN KEY (`receiver_profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);




CREATE TABLE `comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `post_id` INT NOT NULL,
  `profile_id` INT NOT NULL,
  `comment` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `id_idx` (`post_id` ASC) VISIBLE,
  INDEX `profile_id_idx` (`profile_id` ASC) VISIBLE,
  CONSTRAINT `post_id`
    FOREIGN KEY (`post_id`)
    REFERENCES `post` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `profile_id`
    FOREIGN KEY (`profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);




CREATE TABLE `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `post_id` INT NOT NULL,
  `image_url` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `post_id_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `image_post_id`
    FOREIGN KEY (`post_id`)
    REFERENCES `post` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);




CREATE TABLE `friend_request` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sender_profile_id` INT NOT NULL,
  `receiver_profile_id` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `sender_profile_id_idx` (`sender_profile_id` ASC) VISIBLE,
  INDEX `receiver_profile_id_idx` (`receiver_profile_id` ASC) VISIBLE,
  CONSTRAINT `sender_profile_id`
    FOREIGN KEY (`sender_profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `receiver_profile_id`
    FOREIGN KEY (`receiver_profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);