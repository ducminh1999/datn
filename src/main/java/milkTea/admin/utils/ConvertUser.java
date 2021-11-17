/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 23, 2021
 * @version 1.0
 */
package milkTea.admin.utils;

import milkTea.admin.dto.User;
import milkTea.admin.entities.UserEntity;

public class ConvertUser {
	public static UserEntity convertDtoToEntity(User dto) {
		if (dto == null) {
			return null;
		}
		UserEntity entity = new UserEntity();
		entity.setId(dto.getId());
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPhone(dto.getPhone());
		entity.setDescription(dto.getDescription());
		entity.setCreateDate(dto.getCreateDate());
		entity.setUpdateDate(dto.getUpdateDate());
		return entity;
	}

	public static User convertDtoFromEntity(UserEntity entity) {
		if (entity == null) {
			return null;
		}
		User dto = new User();
		dto.setId(entity.getId());
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setPhone(entity.getPhone());
		dto.setDescription(entity.getDescription());
		dto.setCreateDate(entity.getCreateDate());
		dto.setUpdateDate(entity.getUpdateDate());
		return dto;
	}
}
