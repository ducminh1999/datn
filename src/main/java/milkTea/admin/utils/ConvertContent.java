/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 23, 2021
 * @version 1.0
 */
package milkTea.admin.utils;

import milkTea.admin.dto.ContentDto;
import milkTea.admin.entities.ContentEntity;

public class ConvertContent {
	public static ContentEntity convertDtoToEntity(ContentDto dto) {
		if (dto == null) {
			return null;
		}
		ContentEntity entity = new ContentEntity();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setBrief(dto.getBrief());
		entity.setContent(dto.getContent());
		entity.setCreateDate(dto.getCreateDate());
		entity.setUpdateDate(dto.getUpdateDate());
		entity.setSort(dto.getSort());
		entity.setAuthorId(dto.getAuthorId());
		return entity;
	}

	public static ContentDto convertDtoFromEntity(ContentEntity entity) {
		if (entity == null) {
			return null;
		}
		ContentDto dto = new ContentDto();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setBrief(entity.getBrief());
		dto.setContent(entity.getContent());
		dto.setCreateDate(entity.getCreateDate());
		dto.setUpdateDate(entity.getUpdateDate());
		dto.setSort(entity.getSort());
		dto.setAuthorId(entity.getAuthorId());
		return dto;
	}
}
