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
(2, "Nintendo Switch");

INSERT INTO `game` (id, title, notes, status_id, priority_id, platform_id) VALUES 
(1, "Monster Hunter Wilds", "Pretty good game so far", 3, 1, 1),
(2, "Xenoblade Chronicles X Definitive Edition", "The exploration is really fun!", 2, 1, 2);
