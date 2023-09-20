package panomete.practice.storepro.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import panomete.practice.storepro.dto.RentalDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalJDBCRepositoryImpl implements RentalJDBCRepository {

    final JdbcTemplate jdbcTemplate;

    private static RentalDto mapRowToRentalDto(ResultSet rs, int rowNum) throws SQLException {
        return new RentalDto(
                rs.getString("title"),
                rs.getString("description"),
                rs.getInt("release_year"),
                rs.getDouble("rental_rate")
        );
    }

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
}
