package com.example.lab53.dao;

import com.example.lab53.model.Event;
import com.example.lab53.model.Subscribe;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SubscribeDao {
    private final JdbcTemplate jdbcTemplate;

    public Optional<Subscribe> findById(Long id){
        String sql = "select * from subscribe  " +
                "where id = ?;";
        return Optional.of(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Subscribe.class), id));
    }

    public Optional<Subscribe> findByEmail(String email){
        return Optional.empty();
    }

    public Optional<Subscribe> findByEmailAndEventId(String email, Long eventId) {
        String sql = "select * \n" +
                "from subscribe s \n" +
                "where s.email = ? \n" +
                "and s.event_id = ?;";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Subscribe.class), email, eventId));
    }

    public Long create(Long eventId, String email) {
        String sql = "insert into subscribe (event_id, email, register_date_time) " +
                "values (?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setLong(1, eventId);
            ps.setString(2, email);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public void delete(Long id){
        String sql = "delete "+
                "from subscribe  " +
                "where event_id= ?";
        jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Subscribe.class), id);

    }
}
