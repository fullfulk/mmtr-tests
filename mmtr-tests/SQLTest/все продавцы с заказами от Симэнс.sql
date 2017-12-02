select Name from Salesperson as S 
			inner join Orders as O
				on S.ID=O.salesperson_id 
group by Name, cust_id
having cust_id = (select ID from Customer where Name='Seamens')
