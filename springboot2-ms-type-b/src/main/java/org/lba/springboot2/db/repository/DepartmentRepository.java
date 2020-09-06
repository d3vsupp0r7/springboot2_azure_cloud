package org.lba.springboot2.db.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.lba.springboot2.db.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Optional<Department> findById(Long id);

	Department findByDepartmentName(String departmentName);
	
	//Update
	@Modifying
	@Transactional
	@Query("update Department dpt set dpt.departmentName = :departmentName, dpt.departmentLocation = :departmentLocation where dpt.id= :id")
	int updateDepartmentById(@Param("departmentName") String departmentName, @Param("departmentLocation") String departmentLocation, @Param("id") Long id);
	
}
