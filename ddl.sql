create database foodorder;
use foodorder;

-- 代碼類型
create table CodeType (
	uid		SMALLINT unsigned not null primary key auto_increment,
    id		varchar(50) not null,
    name	varchar(50) not null,
    constraint CodeType_ID UNIQUE (id)
);
insert into CodeType (id, name) value ('meal-classification', '餐點分類');
insert into CodeType (id, name) value ('reservation-time-block', '預約區塊');

-- 代碼
create table Code (
	uid		char(36) not null primary key,
    CodeTypeUID	SMALLINT unsigned not null,
    name	varchar(50) not null,
    foreign key (CodeTypeUID) references CodeType(uid)
);

-- 食材
create table Ingredient (
	uid		char(36) not null  primary key,
    name	varchar(50) not null,
    packageByUID	char(36),
    packageQty	SMALLINT,
    foreign key (packageByUID) references Ingredient(uid)
);

-- 食材數量及成本
create table IngredientQuantity (
	uid		int unsigned not null primary key auto_increment,
    ingredientUid	char(36) not null,
    qty		SMALLINT not null,
    cost		SMALLINT not null,
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    foreign key (ingredientUid) references Ingredient(uid)
);

-- 食材進貨銷貨紀錄
create table IngredientLog (
	uid		int unsigned not null primary key auto_increment,
    batchNo char(19) not null,
    time	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    action	ENUM('Restock', 'Expired', 'PackagedFrom', 'PackagedTo', 'Sold', 'Consume') NOT NULL,
    qty		SMALLINT not null,
    comment varchar(100),
    ingredientQuantityUid	int unsigned,
    foreign key (ingredientQuantityUid) references IngredientQuantity(uid)
);

-- 餐點
create table meal (
	uid		char(36) not null  primary key,
    name	varchar(50) not null,
    price	int not null,
    classificationUid	char(36),
    foreign key (classificationUid) references Code(uid)
);

-- 餐點與食材使用量
create table meal_ingredient (
	mealUid		char(36) not null,
    ingredientUid	char(36) not null,
    ingredientQty	tinyint default 1,
    foreign key (mealUid) references meal(uid),
    foreign key (ingredientUid) references Ingredient(uid),
    primary key (mealUid, ingredientUid)
);

-- 折扣
create table discount_config (
	uid		char(36) not null  primary key,
    name	varchar(50) not null,
    operator char(1) not null,
    value	DECIMAL(6,2) not null
); 

-- 餐桌
create table DinningTable (
	uid		char(36) not null primary key,
    name	varchar(50) not null,
    seats	TINYINT default 0
);

-- 預約資訊
create table reservation (
	uid		int unsigned not null primary key auto_increment,
    time datetime not null,
    name	varchar(50) not null,
    contactNo	varchar(20) not null,
    adults	tinyint not null,
    children tinyint default 0,
    tableUid char(36),
    foreign key (tableUid) references DinningTable(uid)
);

create table order_log (
	uid		char(36) not null  primary key,
    orderTime datetime,
    serveTime datetime,
    cleanTime datetime,
    tableUid char(36),
    foreign key (tableUid) references DinningTable(uid)
);

create table order_log_detail (
	uid		char(36) not null primary key,
    orderLogUid char(36) not null,
    mealUid		char(36) not null,
    orderQty	tinyint not null default 1,
    foreign key (orderLogUid) references order_log(uid),
    foreign key (mealUid) references meal(uid)
);

