BEGIN TRANSACTION;

CREATE TABLE `Menu` (
	`menu_id`	INTEGER NOT NULL UNIQUE,
	`menu_name`	TEXT NOT NULL,
	`menu_description`	TEXT NOT NULL,
	PRIMARY KEY(`menu_id`)
);

CREATE TABLE `Recipe` (
	`recipe_id`	INTEGER NOT NULL UNIQUE,
	`recipe_name`	TEXT NOT NULL,
	`recipe_description`	TEXT NOT NULL,
	PRIMARY KEY(`recipe_id`)
);

CREATE TABLE `Ingredient` (
	`ingredient_id`	INTEGER NOT NULL UNIQUE,
	`ingredient_name`	TEXT NOT NULL,
	`ingredient_description`	TEXT NOT NULL,
	PRIMARY KEY(`ingredient_id`)
);

CREATE TABLE `Instruction` (
	`instruction_id`	INTEGER NOT NULL UNIQUE,
	`instruction_content`	TEXT NOT NULL,
	PRIMARY KEY(`instruction_id`)
);

CREATE TABLE "Menu_Recipe_Relationship" (
	`menu_id`	TEXT NOT NULL,
	`recipe_id`	INTEGER NOT NULL,
	PRIMARY KEY(menu_id, recipe_id),
	FOREIGN KEY(`menu_id`) REFERENCES Menu ( menu_id ),
	FOREIGN KEY(`recipe_id`) REFERENCES Recipe ( recipe_id )
);

CREATE TABLE "Recipe_Ingredient_Relationship" (
	`recipe_id`	TEXT NOT NULL,
	`ingredient_id`	INTEGER NOT NULL,
	PRIMARY KEY(recipe_id, ingredient_id),
	FOREIGN KEY(`recipe_id`) REFERENCES Recipe ( recipe_id ),
	FOREIGN KEY(`ingredient_id`) REFERENCES Ingredient ( ingredient_id )
);

CREATE TABLE "Recipe_Instruction_Relationship" (
	`recipe_id`	TEXT NOT NULL,
	`instruction_id`	INTEGER NOT NULL,
	PRIMARY KEY(recipe_id, instruction_id),
	FOREIGN KEY(`recipe_id`) REFERENCES Recipe ( recipe_id ),
	FOREIGN KEY(`instruction_id`) REFERENCES Instruction ( instruction_id )
); 

COMMIT;

-- My Assumptions:
-- 1.
-- one menus can contain multiple recipes
-- one recipe can belong to multiple menus
-- 2.
-- one recipe can contain multiple ingredients
-- one ingredients can belong to multiple recipes
-- 3.
-- one recipe can contain multiple instructions
-- ont insturction can belong to multiple recipes