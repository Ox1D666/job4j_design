create table Roles (
	Role text primary key
);

CREATE TABLE Users (
    UserID serial primary key,
    login text,
    passord text,
	RoleID text references Roles(Role)
);

create table Rules (
	RuleID text primary key
);

create table Сategories (
	Сategory text primary key
);

create table States (
	State text primary key
);

create table Items (
	ItemID serial primary key,
	UserID int references Users(UserID),
	State text references States(State),
	Category text references Сategories(Сategory)
);

create table Comments (
	Comment text, 
	ItemID int references Items(ItemID)
);

create table Attachs (
	File text, 
	ItemID int references Items(ItemID)
);






