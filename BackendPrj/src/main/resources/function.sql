use rent;

DELIMITER //
drop function if exists get_avg_population //
create function get_avg_population()
returns int
deterministic
begin
	return (select avg(population) from city);
end //
DELIMITER ;