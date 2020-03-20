package tqscars.carinfo.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CarRepository  extends JpaRepository<Car, Long> {
    public Car findByName(String name);
}
