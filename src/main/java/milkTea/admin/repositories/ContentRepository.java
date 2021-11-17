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
import org.springframework.stereotype.Repository;

import milkTea.admin.entities.ContentEntity;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {
	List<ContentEntity> findByTitleContains(String title);
}
