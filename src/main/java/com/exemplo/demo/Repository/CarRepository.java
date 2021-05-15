package com.exemplo.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.demo.Model.CarModel;

@Repository
@Transactional(readOnly = true)
public interface CarRepository extends JpaRepository<CarModel, Long>{

	@Query(value = "SELECT * FROM sql5411831.car_model WHERE CPF=:CPF", nativeQuery = true)
	List<CarModel> findByCPF(@Param("CPF") String CPF); 
	
}

