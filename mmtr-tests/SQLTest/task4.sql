--��������� � ������� TopSales (Name, Age) ������ ��� ���� ���������, �������� ������� ������ 100�000.

insert into TopSales(Name,Age)
select Name,Age from Salesperson where Salary>100000