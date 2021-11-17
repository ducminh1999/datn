/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 15, 2021
 * @version 1.0
 */
package milkTea.admin.dto;

public class ContentDto {
	private int id;
	private String title;
	private String brief;
	private String content;
	private String createDate;
	private String updateDate;
	private int authorId;
	private int sort;

	public ContentDto() {
	}

	public ContentDto(String title, String brief, String content, String createDate,String updateDate, int authorId, int sort) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.authorId = authorId;
		this.sort = sort;
	}

	public ContentDto(int id, String title, String brief, String content, String createDate,String updateDate, int authorId, int sort) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.authorId = authorId;
		this.sort = sort;
	}

	public void showInfo() {
		System.out.println(this.id);
		System.out.println(this.title);
		System.out.println(this.brief);
		System.out.println(this.content);
		System.out.println(this.createDate);
		System.out.println(this.updateDate);
		System.out.println(this.authorId);
		System.out.println(this.sort);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
