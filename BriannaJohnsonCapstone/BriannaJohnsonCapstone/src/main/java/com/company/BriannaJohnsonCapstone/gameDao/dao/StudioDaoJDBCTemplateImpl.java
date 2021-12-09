package com.company.BriannaJohnsonCapstone.gameDao.dao;

import com.company.BriannaJohnsonCapstone.gameDao.model.Studio;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudioDaoJDBCTemplateImpl implements StudioDao {
    private JdbcTemplate jdbctemplate;
    private static final String INSERT_STUDIO_SQL =
            "insert into Studio (title, ERBRating_id, studio_id) values (?, ?, ?)";
    private static final String SELECT_STUDIO_SQL =
            "select * from studio where studio_id = ?";
    private static final String SELECT_ALL_STUDIO_SQL =
            "Select * from studio";
    private static final String UPDATE_STUDIO_SQL =
            "update studio set title = ?, ESRBRating = ?, studio_id = ?";
    private static final String DELETE_STUDIO =
            "delete from studio where studio_id = ?";

    @Autowired
    public StudioDaoJDBCTemplateImpl(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Studio addStudio(Studio studio) {
        jdbcTemplate.update(
                INSERT_STUDIO_SQL,
                studio.getGameId(),
                studio.getTitle(),
                studio.getESRBRating(),
                studio.getDescription(),
                studio.getPrice(),
                studio.getStudioId(),
                studio.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        studio.setId(id);

        return studio;
    }

    @Override
    public Studio getStudio(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_STUDIO_SQL, this::mapRowToStudio, id);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    @Override
    public void updateStudio(Studio studio) {
        jdbcTemplate.update(
                studio.getGameId(),
                studio.getTitle(),
                studio.getESRBRating(),
                studio.getDescription(),
                studio.getPrice(),
                studio.getStudioId(),
                studio.getQuantity());
    }

    @Override
    public void deleteStudio(int id) {
        jdbcTemplate.update(DELETE_STUDIO, id);
    }

    private Studio mapRowToStudio(ResultSet rs, int rowNum) throws SQLException {
        Studio studio = new Studio();
        studio.setGameId(rs.getInt("game_id"));
        studio.setTitle(rs.getString("title"));
        studio.setESRBRating(rs.getInt("esrbRating_id"));
        studio.setDescription(rs.getString("description"));
        studio.setPrice(rs.getBigDecimal("price"));
        studio.setStudioId(rs.getInt("studio_id"));
        studio.setQuantity(rs.getInt("quantity"));

        return studio;
    }
}
