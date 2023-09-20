# Try Store Procedure in Simple Backend Development

- Using PostgresSQL
- Using Spring Data JDBC

#### Remark you can't directly clone this repository
- you need to create your own database
- you need to create your own table
- you need to create your own store procedure


## Example of Store Procedure

### Prepare Store Procedure

```sql
-- create type
create type rental_flim_type as (
	title varchar(255),
	description text,
	release_year year,
	rental_rate numeric(4,2)
);

-- create procedure
create or replace function top_rate_r_flim() 
returns setof rental_flim_type
language sql
as $$
select
	title,
	description,
	release_year,
	rental_rate
from
	film f
where 
	rating = 'R'
	and length >= 120
	and special_features @> '{Behind the Scenes, Trailers}'
order by
	rental_rate desc
limit 10;
$$;
```
### Calling Store Procedure in Spring Data JDBC

```java
    @Override
    public List<RentalDto> getTop10Rentals() {
        StringBuilder sql = new StringBuilder();
        sql.append("select ");
        sql.append("   title, ");
        sql.append("   description, ");
        sql.append("   release_year, ");
        sql.append("   rental_rate ");
        sql.append("from ");
        sql.append("top_rate_r_flim()");
        return jdbcTemplate.query(sql.toString(), RentalJDBCRepositoryImpl::mapRowToRentalDto);
    }
    
// this piece of code can be found in repository folder
```

