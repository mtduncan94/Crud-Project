package com.dao;

import com.entity.RaceDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class RaceDAO {

    private JdbcTemplate template;

    public RaceDAO() {

    }

    public RaceDAO(DataSource ds) {
        template = new JdbcTemplate(ds);
    }

    public List<RaceDetails> showAll() throws SQLException {
        String sql = "select * from race;";
        List<RaceDetails> allRaces = template.query(sql, new RowMapper<RaceDetails>() {
            @Override
            public RaceDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                RaceDetails rd = new RaceDetails();
                rd.setID(rs.getInt("ID"));
                rd.setRaceName(rs.getString("racename"));
                rd.setTrackName(rs.getString("trackname"));
                rd.setRaceDate(rs.getString("racedate"));
                return rd;
            }

        });
        return allRaces;
    }

    public void addOrEdit(RaceDetails rd) {
        if(rd.getID()>0){
        String updateString = "update race set raceName=?,trackName=?,raceDate=? where ID= ? ";
        template.update(updateString, rd.getRaceName(), rd.getTrackName(), rd.getRaceDate(), rd.getID());
        }
        else{
        String addItem = "insert into race values (default,'" + rd.getRaceName() + "','"
                + rd.getTrackName() + "','" + rd.getRaceDate() + "')";
        template.update(addItem);
        }
    }

    public void deleteRace(int ID) {
        String sql = "delete from race where ID=?";
        template.update(sql, ID);

    }

    public RaceDetails getRace(int ID) {
        String sql = "SELECT * FROM race WHERE ID= " + ID;
        return template.query(sql, new ResultSetExtractor<RaceDetails>() {

            @Override
            public RaceDetails extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    RaceDetails rd = new RaceDetails();
                    rd.setID(rs.getInt("ID"));
                    rd.setRaceName(rs.getString("racename"));
                    rd.setTrackName(rs.getString("trackname"));
                    rd.setRaceDate(rs.getString("racedate"));

                    return rd;
                }

                return null;
            }

        });
    }

}
