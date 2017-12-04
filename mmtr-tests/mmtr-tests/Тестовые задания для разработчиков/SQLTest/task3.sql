--Выводит имена всех продавцов, имеющих два и более заказов
select Name from Salesperson as S inner join Orders as O
			on S.ID=o.salesperson_id
where 2<=(select COUNT(salesperson_id) from Orders where salesperson_id = S.ID)
group by Name
