BEGIN TRANSACTION;
CREATE TABLE "android_metadata" ("locale" TEXT DEFAULT 'en_US');
INSERT INTO `android_metadata` VALUES ('en_US');
CREATE TABLE "Beer" (
	`_id`	INTEGER,
	`Name`	TEXT,
	`Alcohol Content`	REAL,
	`PRICE`	REAL,
	`Alcohol(Fluid oz)/Dollar($)`	REAL,
	`URL`	TEXT,
	PRIMARY KEY(_id)
);
INSERT INTO `Beer` VALUES (1,'Bud Light Beer, 12 fl oz, 24 pack',12.096,NULL,NULL,'http://www.walmart.com/ip/Bud-Light-Beer-12-fl-oz-24-pack/10984488');
INSERT INTO `Beer` VALUES (2,'Coors Light Beer, 12 fl oz, 36 pack',18.144,NULL,NULL,'http://www.walmart.com/ip/Coors-Light-Beer-12-oz-36pk/15556272');
INSERT INTO `Beer` VALUES (3,'Miller Lite Beer, 12 fl oz, 24 pack',12.096,NULL,NULL,'http://www.walmart.com/ip/Miller-Lite-Beer-12-fl-oz-24-pack/10984517');
INSERT INTO `Beer` VALUES (4,'Heineken Lager Beer, 12 fl oz, 24 pack',14.4,NULL,NULL,'http://www.walmart.com/ip/Heineken-Lager-24pk/15716727');
INSERT INTO `Beer` VALUES (5,'Budweiser Beer, 12 fl oz, 24 pack',14.4,NULL,NULL,'http://www.walmart.com/ip/Budweiser-Beer-12-fl-oz-24-pack/10984473');
INSERT INTO `Beer` VALUES (6,'Bud Light Beer, 15.5 gal',83.328,NULL,NULL,'http://www.walmart.com/ip/Bud-Light-Beer-15.5-gal/20700782');
INSERT INTO `Beer` VALUES (7,'Modelo Especial Beer, 12 fl oz, 24 pack',12.672,NULL,NULL,'http://www.walmart.com/ip/Modelo-Especial-Beer-12-fl-oz-24-pack/21778186');
INSERT INTO `Beer` VALUES (8,'Heineken Lager Beer, 12 fl oz, 6 pack',3.6,NULL,NULL,'http://www.walmart.com/ip/Heineken-Lager-Beer-12-fl-oz-6-Pack/10984540');
INSERT INTO `Beer` VALUES (9,'Michelob Ultra Beer, 24 pk 12 fl. oz. Bottles',12.096,NULL,NULL,'http://www.walmart.com/ip/Michelob-ULTRA-Superior-Light-Beer-12-fl-oz-24-pack/16940114');
INSERT INTO `Beer` VALUES (10,'Bud Light Beer, 24 pk 16 fl. oz. Cans',16.128,NULL,NULL,'http://www.walmart.com/ip/Bud-Light-Beer-16-fl-oz-24-pack/42294355');
INSERT INTO `Beer` VALUES (11,'Bud Light Beer, 12 fl oz, 18 pack',9.072,NULL,NULL,'http://www.walmart.com/ip/Bud-Light-Beer-12-fl-oz-18-pack/10984490');
INSERT INTO `Beer` VALUES (12,'Pabst Blue Ribbon Beer, 12 fl oz, 30 pack',15.084,NULL,NULL,'http://www.walmart.com/ip/Pabst-Blue-Ribbon-Beer-12-fl-oz-30-pack/32173119');
INSERT INTO `Beer` VALUES (13,'Natural Light Beer, 12 fl oz, 18 pack',9.072,NULL,NULL,'http://www.walmart.com/ip/Natural-Light-Beer-12-fl-oz-18-pack/10984483');
INSERT INTO `Beer` VALUES (14,'Bud Light Beer, 12 fl oz, 20 pack',10.08,NULL,NULL,'http://www.walmart.com/ip/Bud-Light-Beer-12-fl-oz-20-pack/15556012');
INSERT INTO `Beer` VALUES (15,'Budweiser Beer, 12 pk 12 fl. oz. Bottles',7.2,NULL,NULL,'http://www.walmart.com/ip/Budweiser-Beer-12-fl-oz-12-pack/10984456');
INSERT INTO `Beer` VALUES (16,'Heineken DraughtKeg Lager Beer, 2 count, 1.32 gal',16.896,NULL,NULL,'http://www.walmart.com/ip/Heineken-DraughtKeg-Lager-Beer-5l/15716732');
INSERT INTO `Beer` VALUES (17,'Heineken Light Lager Beer, 1.32 gal',8.448,NULL,NULL,'http://www.walmart.com/ip/Heineken-Light-DraughtKeg-Lager-Beer-5l/16940466');
INSERT INTO `Beer` VALUES (18,'Samuel Adams Boston Lager Beer, 12 oz, 12 count',7.056,NULL,NULL,'http://www.walmart.com/ip/Samuel-Adams-Boston-Lager-Beer-12-oz-12-count/20925303');
INSERT INTO `Beer` VALUES (19,'Miller Genuine Draft Beer, 12 fl oz, 24 pack',14.4,NULL,NULL,'http://www.walmart.com/ip/Miller-Genuine-Draft-Beer-12-fl-oz-24-pack/22026923');
INSERT INTO `Beer` VALUES (20,'Natural Ice Beer, 12 fl oz, 12 pack',8.496,NULL,NULL,'http://www.walmart.com/ip/Natural-Ice-Beer-12-fl-oz-12-pack/10984462');
INSERT INTO `Beer` VALUES (21,'Bud Light Beer, 8 fl oz, 12 pack',4.032,NULL,NULL,'http://www.walmart.com/ip/Bud-Light-8-fl-oz-12-pack/22563305');
INSERT INTO `Beer` VALUES (22,'Coors Light Beer, 12 fl oz, 20 pack',10.08,NULL,NULL,'http://www.walmart.com/ip/Coors-Light-Beer-12-fl-oz-20-pack/10984533');
INSERT INTO `Beer` VALUES (23,'Corona Extra Beer, 7 fl oz, 6 pack',1.932,NULL,NULL,'http://www.walmart.com/ip/Coronita-Extra-Longneck-Beer-7-fl-oz-Pack-of-6/21553549');
INSERT INTO `Beer` VALUES (24,'Heineken Light Lager Beer, 12 fl oz, 12-Pack',5.04,NULL,NULL,'http://www.walmart.com/ip/Heineken-Light-Lager-Beer-12-fl-oz-12-Pack/10984542');
INSERT INTO `Beer` VALUES (25,'Bud Light Platinum Beer, 11.5 fl oz, 10 pack',6.9,NULL,NULL,'http://www.walmart.com/ip/Bud-Light-Platinum-Beer-11.5-fl-oz-10-pack/35731550');
INSERT INTO `Beer` VALUES (26,'Budweiser Beer, 6 pk 12 fl. oz. Bottles',3.6,NULL,NULL,'http://www.walmart.com/ip/Budweiser-Beer-12-fl-oz-6-pack/10984460');
INSERT INTO `Beer` VALUES (27,'Miller Lite Beer, 12 fl oz, 20 pack',10.08,NULL,NULL,'http://www.walmart.com/ip/Miller-Lite-Beer-12-oz-20pk/10984515');
INSERT INTO `Beer` VALUES (28,'Michelob Ultra Beer, 20 pk 12 fl. oz. Bottles',10.08,NULL,NULL,'http://www.walmart.com/ip/Michelob-ULTRA-Superior-Light-Beer-12-fl-oz-20-pack/10984500');
INSERT INTO `Beer` VALUES (29,'Bud Light Beer, 18 pk 16 fl. oz. Cans',12.096,NULL,NULL,'http://www.walmart.com/ip/Bud-Light-Beer-16-fl-oz-18-pack/15610340');
INSERT INTO `Beer` VALUES (30,'Heineken Lager Beer, 16 fl oz, 4 pack',3.2,NULL,NULL,'http://www.walmart.com/ip/Heineken-Lager-Beer-16-fl-oz-4-Pack/15716728');
INSERT INTO `Beer` VALUES (31,'Coors Light Home Draft Beer, 5.7 l',8.09508,NULL,NULL,'http://www.walmart.com/ip/Coors-Light-Home-Draft-Beer-5.7-l/20700829');
INSERT INTO `Beer` VALUES (32,'Bud Light Lime Beer, 12 fl oz, 30 pack',15.12,NULL,NULL,'http://www.walmart.com/ip/Bud-Light-Lime-Beer-12-fl-oz-30-pack/46341652');
INSERT INTO `Beer` VALUES (33,'Michelob Ultra Superior Light Beer, 12 fl oz, 10 pack',5.04,NULL,NULL,'http://www.walmart.com/ip/Michelob-ULTRA-Superior-Light-Beer-10-fl-oz-12-pack/16940104');
COMMIT;
