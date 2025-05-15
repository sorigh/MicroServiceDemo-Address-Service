package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    /**
     * Finds the Address record associated with a given employee ID.
     *
     * This method runs a native SQL query directly on the database.
     * It selects the address fields (id, city, state) from the 'address' table
     * where the employee_id matches the given parameter.
     *
     * @param employeeId The ID of the employee whose address we want to find.
     * @return An Optional containing the Address if found, or empty if no address exists for that employee.
     */

    @Query(
            nativeQuery = true,
            value = "SELECT id, city, state FROM address WHERE employee_id = :employeeId"
    )
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
