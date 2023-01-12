create or replace procedure delete_entry_procedure(u_count integer, u_id integer)
    language 'plpgsql'
as $$
BEGIN
    if u_count = 0 THEN
        delete from products where id = u_id;
    end if;
END;
$$;

create or replace function delete_entry_function(i_price integer, i_id integer)
    returns void
    language 'plpgsql'
as
$$
begin
    if i_price = 0 THEN
        delete from products where id = i_id;
    end if;
end;
$$;