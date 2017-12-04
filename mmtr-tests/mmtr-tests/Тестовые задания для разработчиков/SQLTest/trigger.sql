SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TRIGGER AddIfSalaryBeter 
   ON  Salesperson
   AFTER INSERT,DELETE,UPDATE
AS 
BEGIN
	insert into TopSales(Name,Age)
		select Name,Age from inserted where Salary>100000
	
END
GO
