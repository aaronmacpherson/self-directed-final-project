INSERT INTO `status` (id, name) VALUES 
(1, "Unplayed"),
(2, "Unfinished"),
(3, "Beaten"),
(4, "Completed"),
(5, "Endless"),
(6, "None");

INSERT INTO `priority` (id, name) VALUES 
(1, "Now Playing"),
(2, "Paused"),
(3, "High"),
(4, "Normal"),
(5, "Low"),
(6, "Replay"),
(7, "Shelved");

INSERT INTO `platform` (id, name) VALUES 
(1, "PC"),
(2, "Nintendo Switch"),
(3, "Playstation 5");

INSERT INTO `game` (id, title, notes, status_id, priority_id, platform_id, achievements_earned, achievements_total) VALUES 
(1, "Monster Hunter Wilds", "Pretty good game so far", 3, 1, 1, 33, 50),
(2, "The Legend of Zelda: Tears of the Kingdom", "", 3, 4, 2, 0, 0),
(3, "Final Fantasy VII Rebirth", "Amazing graphics!", 3, 4, 3, 38, 63),
(4, "Elden Ring", "", 4, 4, 1, 42, 42);
