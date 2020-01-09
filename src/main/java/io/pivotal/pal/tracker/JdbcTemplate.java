package io.pivotal.pal.tracker;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class JdbcTemplate {
    public JdbcTemplate(DataSource dataSource){

    }

    public void execute(String delete_from_time_entries) {

    }

    public Map<String, Object> queryForMap(String s, long id) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put(s,id);
        return returnMap;
    }



}
