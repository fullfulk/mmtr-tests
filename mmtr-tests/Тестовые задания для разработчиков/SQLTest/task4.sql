--Вставляет в таблицу TopSales (Name, Age) записи обо всех продавцах, зарплата которых больше 100 000.

insert into TopSales(Name,Age)
select Name,Age from Salesperson where Salary>100000