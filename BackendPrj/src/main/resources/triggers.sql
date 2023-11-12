use rent;

DELIMITER //

# Task 1
# Додати до БД 1 додаткову довільну таблицю і зв’язати з іншою існуючою таблицею зв’язком  1:M
# Однак для забезпечення цілісності значень використати тригери замість фізичного зовнішнього ключа

drop trigger if exists add_region_check //
create trigger add_region_check
before insert
on region for each row
begin
	if (new.country_id not in (select id from country)) then
        signal sqlstate '45000' 
        set message_text = 'Region\'s refering to non-existent country';
    end if;
end //

drop trigger if exists update_region_check //
create trigger update_region_check
before update
on region for each row
begin
	if (new.country_id not in (select id from country)) then
        signal sqlstate '45000' 
        set message_text = 'Region\'s refering to non-existent country';
    end if;
end //

drop trigger if exists update_country_check //
create trigger update_country_check
before update
on country for each row
begin
	if (old.id in (select country_id from region)) then
        signal sqlstate '45000' 
        set message_text = 'There are regions refering to the country';
    end if;
end //

drop trigger if exists delete_country_check //
create trigger delete_country_check
before delete
on country for each row
begin
	if (old.id in (select country_id from region)) then
        signal sqlstate '45000' set message_text = 'There are regions refering to the country';
    end if;
end //


-- Написати 3 довільні тригери для таблиць поточної БД:

-- Забезпечити мінімальну кардинальність 4 стрічок для певної  таблиці БД

drop trigger if exists city_min_cardinality_trigger //
create trigger city_min_cardinality_trigger 
after delete
on city for each row
begin
	if((select count(*) from city) < 4) then
		signal sqlstate '45000' 
        set message_text = 'Minimal cardinality condition is not met';
	end if;
end //

-- Забезпечити правильність написання номеру телефону

drop trigger if exists phone_lenght_limit //
create trigger phone_lenght_limit
before insert
on platform_user for each row
begin
	if(lenght(new.phone) > 12) then
		signal sqlstate '45000' 
        set message_text = 'Phone number must start with 380 not with +380';
	end if;
end //

-- Заборонити будь-яку модифікацію даних в таблиці

drop trigger if exists forbid_update_city //
create trigger forbid_update_city
before update
on city for each row
begin
	signal sqlstate '45000' 
    set message_text = 'Data modification in table city is forbidden';
end//

DELIMITER ;