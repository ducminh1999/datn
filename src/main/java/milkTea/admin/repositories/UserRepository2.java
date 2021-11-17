/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 15, 2021
 * @version 1.0
 */
package milkTea.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import milkTea.admin.entities.UserEntity;
//@Repository
public interface UserRepository2 extends JpaRepository<UserEntity, Integer> {
	List<UserEntity> findByEmail(String email);
	
}
