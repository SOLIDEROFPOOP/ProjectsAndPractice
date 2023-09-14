package kapparov.murat.springProject.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import kapparov.murat.springProject.models.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> select_all(){
        return jdbcTemplate.query("select * from cars" , new BeanPropertyRowMapper<>(Car.class));
    }
    public Car select_one(Integer id){
        return jdbcTemplate.query("select * from cars where id = ?", new Object[]{id} , new BeanPropertyRowMapper<>(Car.class))
                .stream().findAny().orElse(null);
    }
    public void create(Car car){
        jdbcTemplate.update("insert into cars(brand, model, year, type, drive_type, mileage, color, engine_liter, price) values (? , ? , ? , ? , ? , ? , ? , ? , ?)",
                car.getBrand(),
                car.getModel(),
                car.getYear(),
                car.getType(),
                car.getDrive_type(),
                car.getMileage(),
                car.getColor(),
                car.getEngine_liter(),
                car.getPrice());
    }
    public void edit(Car car, int id){
        jdbcTemplate.update("update cars set brand=?, model=? , year=?, type=?, drive_type=?,mileage=?,color=?,engine_liter=?,price=? where id = ?",
                car.getBrand(),
                car.getModel(),
                car.getYear(),
                car.getType(),
                car.getDrive_type(),
                car.getMileage(),
                car.getColor(),
                car.getEngine_liter(),
                car.getPrice(),
                id);

    }
    public void remove(int id){
        jdbcTemplate.update("delete from cars where id = ?" , id);
    }
}
