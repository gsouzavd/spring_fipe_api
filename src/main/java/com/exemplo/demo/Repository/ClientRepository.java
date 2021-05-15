package com.exemplo.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.demo.Model.ClientModel;

@Repository
@Transactional(readOnly = true)
public interface ClientRepository extends JpaRepository<ClientModel, Long>{

	@Query(value = "SELECT COUNT(id) FROM sql5411831.client_model WHERE CPF=:CPF", nativeQuery = true)
	Long countClientsByCPF(@Param("CPF") String CPF); 
	
	@Query(value = "SELECT COUNT(id) FROM sql5411831.client_model WHERE email=:email", nativeQuery = true)
	Long countClientsByEmail(@Param("email") String email); 
	
	@Query(value = "SELECT COUNT(id) FROM sql5411831.client_model WHERE email=:email OR CPF=:CPF", nativeQuery = true)
	Long countClientsByCPFAndEmail(@Param("CPF") String CPF, @Param("email") String email); 
	
}
