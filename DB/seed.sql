INSERT INTO public.ingredients VALUES 
(1,'Rum'),(3,'Coke'),(2,'Lime'),(4,'Ice'),
(19,'Angostura'),(5,'Brown sugar'),(6,'Mint'),(7,'Sparkling water'),
(8,'Gin'),(9,'Lemon soda'),
(10,'Aperol'),(11,'Soda'),(12,'Orange'),(13,'Sparkling wine'),
(14,'Carrot'),(15,'Lemon'),
(16,'Banana'),(17,'Cocoa'),(18,'Milk'); --banshee

INSERT INTO public.cocktails VALUES 
(1, 'Cuba Libre',5.99, true),
(2, 'Mojito',5.50, true),
(3, 'Gin Lemon',5.60, true),
(4, 'Spritz',5.00, true),
(5, 'Ace juice',4.00, false),
(6, 'Banshee',5.00, false);

INSERT INTO public.recipe_def VALUES 
(1, 1,1),(2, 1,2),(3, 1,3),(4, 1,4),
(5, 2,1),(6, 2,19),(7, 2,4),(9, 2,5),(10, 2,6), (11,2,7),
(12, 3,8),(13, 3,9),(14, 3,4),
(15, 4,10),(16, 4,11),(17, 4,12),(18, 4,13),(19, 4,4),
(20, 5,12),(21, 5,14),(22, 5,15),
(23, 6,16),(24, 6,17),(25, 6,18);

