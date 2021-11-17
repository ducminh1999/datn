/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 23, 2021
 * @version 1.0
 */
package milkTea.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "ContentTable")
@Entity(name = "Content")
public class ContentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title", columnDefinition = "nvarchar(50)",  nullable = false)
	private String title;

	@Column(name = "brief", columnDefinition = "nvarchar(100)", nullable = false)
	private String brief;

	@Column(name = "contents", columnDefinition = "nvarchar(500)", nullable = true)
	private String content;

	@Column(name = "createDate", columnDefinition = "nvarchar(100)", nullable = true)
	private String createDate;

	@Column(name = "updateDate", columnDefinition = "nvarchar(100)", nullable = true)
	private String updateDate;

	@Column(name = "sort", columnDefinition = "bit", nullable = true)
	private int sort;

	@Column(name = "authorId", columnDefinition = "int", nullable = false)
	private int authorId;

	@ManyToOne()
	@JoinColumn(name = "authorId", foreignKey = @ForeignKey(name = "PK_Content_User"), insertable = false, updatable = false)
	private UserEntity userEntity;

//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "UserID", foreignKey = @ForeignKey(name = "FK_UserActivities_UserID"), insertable = false, updatable = false)
//    private UserEntity user;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
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

	public int getSort() {
		return sort;
	}

	public void setSort(int i) {
		this.sort = i;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
}
