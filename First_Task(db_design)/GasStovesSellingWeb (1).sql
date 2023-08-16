
USE SaleGasStovesOnline


CREATE TABLE Customers (
  CustomerID INT PRIMARY KEY IDENTITY(1,1),
  FirstName NVARCHAR(50) NOT NULL,
  LastName NVARCHAR(50) NOT NULL,
  Email VARCHAR(100) NOT NULL,
  PhoneNumber VARCHAR(10) ,
  City NVARCHAR(20) ,
  District NVARCHAR(20),
  Address NVARCHAR(20) ,
  username VARCHAR(50) ,
  password VARCHAR(50) ,
  BoughtCount INT  DEFAULT 0,
  CreatedDate DATE DEFAULT GETDATE(),
  ModifiedDate DATE,
  AvatarURL NVARCHAR(255)

);


CREATE TABLE Categories (
  CategoryID INT PRIMARY KEY IDENTITY(1,1),
  CategoryName nvarchar (30) NOT NULL ,
  SubCategoryName nvarchar (30) NULL ,
);


CREATE TABLE Products(
  ProductID INT PRIMARY KEY IDENTITY(1,1),
  ProductName NVARCHAR(50) not null,
  CategoryID INT,
  UnitPrice int,
  Description NVARCHAR(MAX),
  ModelNumber NVARCHAR(50) NOT NULL,
  ImageURL NVARCHAR(255) NOT NULL,
  CreatedDate DATETIME NOT NULL DEFAULT GETDATE(),
  ModifiedDate DATETIME,
  CreatedBy NVARCHAR(50) NOT NULL,
  ModifiedBy NVARCHAR(50),
  Brand NVARCHAR(50) NOT NULL,
  WarrantyPeriod NVARCHAR(50) NOT NULL,
  Stock INT,
  SaleOff INT,
  CONSTRAINT fk_Products_Categories FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID),
);


CREATE TABLE Promotion (
  PromotionID INT PRIMARY KEY IDENTITY(1,1),
  ProductID INT,
  PromotionName NVARCHAR(50),
  Discount DECIMAL(5,2),
  StartDate DATE,
  EndDate DATE,
  MinimumTotalPrice int,
  MinimumPurchaseQuantity INT,
  MinimumBoughtCount INT,
  CONSTRAINT fk_Promotion_Products FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
  CONSTRAINT CK_Dates CHECK (EndDate > StartDate),
  CONSTRAINT CK_MinBoughtCount CHECK (MinimumBoughtCount >= 0)
);

CREATE TABLE PromotionUsage (
  CustomerID INT,
  PromotionID INT,
  UsageDate DATE,
  CONSTRAINT pk_PromotionUsage PRIMARY KEY (CustomerID, PromotionID),
  CONSTRAINT fk_PromotionUsage_Customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
  CONSTRAINT fk_PromotionUsage_Promotion FOREIGN KEY (PromotionID) REFERENCES Promotion(PromotionID)
);

CREATE TABLE Maintenance (
  MaintenanceID INT PRIMARY KEY IDENTITY(1,1),
  ProductID INT,
  MaintenanceDate DATE,
  MaintenanceDetail nVARCHAR(200),
  CONSTRAINT fk_Maintenance_Product FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE MaintenanceRequest (
  RequestID INT PRIMARY KEY IDENTITY(1,1),
  CustomerID INT,
  ProductID INT,
  RequestDate DATE,
  Description NVARCHAR(500),
  IsResolved BIT,
  CONSTRAINT fk_MaintenanceRequest_Customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
  CONSTRAINT fk_MaintenanceRequest_Product FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE Warranty (
  WarrantyID INT PRIMARY KEY IDENTITY(1,1),
  ProductID INT,
  WarrantyPeriod INT,
  StartDate DATE,
  EndDate DATE,
  CONSTRAINT fk_Warranty_Product FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE Employee (
  EmployeeID INT PRIMARY KEY,
  FirstName NVARCHAR(50),
  LastName NVARCHAR(50),
  Email VARCHAR(100),
  PhoneNumber VARCHAR(10),
  Address VARCHAR(100),
  HireDate DATE,
  Salary INT,
  JobTitle VARCHAR(50),
  username VARCHAR(50) ,
  password VARCHAR(50) ,
  AvatarURL NVARCHAR(255)
);

CREATE TABLE Shippers (
	ShipperID INT PRIMARY KEY IDENTITY (1, 1),
	CompanyName nvarchar (40) NOT NULL ,
	Phone nvarchar (24) NULL ,
)


CREATE TABLE Orders (
  OrderID INT PRIMARY KEY IDENTITY (1, 1),
  CustomerID INT,
  EmployeeID INT,
  OrderDate DATE,
  TotalPrice int,
  CustomerType VARCHAR(20),
  RequiredDate datetime NULL,
  ShippedDate datetime NULL ,
  ShipVia int NULL,
  ShipName nvarchar (40) NULL ,
  ShipAddress nvarchar (60) NULL ,
  ShipCity nvarchar (15) NULL ,
  CONSTRAINT fk_Order_Customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
  CONSTRAINT fk_Order_Shippers FOREIGN KEY (ShipVia) REFERENCES Shippers(ShipperID),
  CONSTRAINT fk_Order_Employee FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);



CREATE TABLE OrderDetails (
  OrderID INT,
  ProductID INT,
  Quantity INT,
  UnitPrice DECIMAL(10,2),
  CONSTRAINT pk_OrderDetails PRIMARY KEY (OrderID, ProductID),
  CONSTRAINT fk_OrderDetails_Order FOREIGN KEY (OrderID) REFERENCES [Orders](OrderID),
  CONSTRAINT fk_OrderDetails_Product FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
);



CREATE TABLE Feedback (
  FeedbackID INT PRIMARY KEY IDENTITY(1, 1),
  CustomerID INT,
  FeedbackDate DATE,
  FeedbackDetail VARCHAR(200),
  ProductID INT,
  Rating INT,
  CONSTRAINT fk_Feedback_Customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
  CONSTRAINT fk_Review_Product FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
);



CREATE TABLE Payment (
  PaymentID INT PRIMARY KEY,
  CustomerID INT FOREIGN KEY REFERENCES customers(customerID),
  OrderID INT FOREIGN KEY REFERENCES [Orders](OrderID),
  PaymentMethod VARCHAR(50),
  PaymentAmount int,
  PaymentDate DATETIME
);


Create table Cart (
  CustomerID int,
  productID int,
  quantity int,
  unitPrice decimal(10,2),
  totalPrice int
);