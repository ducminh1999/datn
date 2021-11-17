/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 15, 2021
 * @version 1.0
 */
package milkTea.admin.services;

import java.util.List;

import milkTea.admin.dto.ContentDto;
import milkTea.admin.repositories.ContentRes2;

public class ContentService2 {
	public List<ContentDto> findAll() {
		ContentRes2 ContentRes2 = new ContentRes2();
		return ContentRes2.findAll();
	}

	public List<ContentDto> find(String title) {
		ContentRes2 ContentRes2 = new ContentRes2();
		return ContentRes2.find(title);
	}

	public ContentDto findId(int id) {
		ContentRes2 ContentRes2 = new ContentRes2();
		return ContentRes2.findId(id);
	}

	public boolean add(ContentDto contentDto) {
		ContentRes2 ContentRes2 = new ContentRes2();
		return ContentRes2.add(contentDto);
	}

	public boolean update(int id, ContentDto contentDto) {
		ContentRes2 ContentRes2 = new ContentRes2();
		return ContentRes2.update(id, contentDto);
	}

	public boolean delete(int id) {
		ContentRes2 ContentRes2 = new ContentRes2();
		return ContentRes2.delete(id);
	}
}
