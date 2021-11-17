package milkTea.admin.controllers.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import milkTea.admin.dto.ContentDto;
import milkTea.admin.dto.User;
import milkTea.admin.services.ContentService;
import milkTea.admin.services.UserService;
import milkTea.admin.utils.FormatDate;
import milkTea.admin.utils.ValidateData;

@Controller
@RequestMapping(path = { "/user" })
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	ContentService contentService;

	public UserController() {
		System.out.println("UserControllers");
	}

	@RequestMapping(path = { "/editProfile" }, method = { RequestMethod.GET })
	public String showEdit(Model model, HttpSession session) {
		Object id = (Object) session.getAttribute("LoginUser");
		User curentUser = userService.findOne((int) id);
		model.addAttribute("user", curentUser);
		return "editProfile";/// WEB-INF/view/user/editProfile.jsp
	}

	@RequestMapping(path = { "/editProfile" }, method = { RequestMethod.POST })
	public String checkEdit(HttpSession session, Model model, User user) {
		Object id = (Object) session.getAttribute("LoginUser");
		User curentUser = userService.findOne((int) id);
		curentUser.setFirstName(user.getFirstName());
		curentUser.setLastName(user.getLastName());
		curentUser.setPhone(user.getPhone());
		curentUser.setDescription(user.getDescription());
		curentUser.setUpdateDate(FormatDate.format(new Date()));
		model.addAttribute("user", curentUser);
		if(ValidateData.validatePhone(curentUser.getPhone())) {
			userService.update(curentUser);
			model.addAttribute("messageServer", "");
		} else {
			model.addAttribute("messageServer", "Phone invalid");
		}
		return "editProfile";
	}

	@RequestMapping(path = { "/addContent" }, method = { RequestMethod.GET })
	public String showAddContent() {
		return "addContent";/// WEB-INF/view/user/addContent.jsp
	}

	@RequestMapping(path = { "/addContent" }, method = { RequestMethod.POST })
	public String checkAddContent(ContentDto contentDto, Model model, HttpSession session) {
		int userId = (int) session.getAttribute("LoginUser");

		contentDto.setCreateDate(FormatDate.format(new Date()));
		contentDto.setAuthorId(userId);
		contentDto.setSort(1);
		contentService.add(contentDto);

		model.addAttribute("content", contentDto);
		return "redirect:" + "/user/view";
	}

	@RequestMapping(path = { "/editContent" }, method = { RequestMethod.GET })
	public String showEditContent(Model model, int id) {
//		int id = Integer.parseInt(request.getParameter("id"));
		ContentDto content = (ContentDto) contentService.findId(id);
		model.addAttribute("content", content);
		return "addContent";
	}

	@RequestMapping(path = { "/editContent" }, method = { RequestMethod.POST })
	public String checkEditContent(ContentDto contentDto, Model model, HttpSession session, int id) {
//		int userId = (int) session.getAttribute("LoginUser");
		System.out.println("editContent:" + id);
		ContentDto dto = contentService.findId(id);
		dto.setTitle(contentDto.getTitle());
		dto.setBrief(contentDto.getBrief());
		dto.setContent(contentDto.getContent());
		dto.setUpdateDate(FormatDate.format(new Date()));
		System.out.println(contentService.update(dto));
		return "redirect:" + "/user/view";
	}

	@RequestMapping(path = { "/view" }, method = { RequestMethod.GET })
	public String showContent(Model model) {
		List<ContentDto> list = contentService.findAll();
		model.addAttribute("list", list);
		return "viewContent";
	}

	@RequestMapping(path = { "/view" }, method = { RequestMethod.POST })
	public String checkSearchContent(Model model, String search) {
		List<ContentDto> list = contentService.findByTitleContains(search);
		model.addAttribute("search", search);
		model.addAttribute("list", list);

		return "viewContent";
	}

	@RequestMapping(path = { "/deleteContent" }, method = { RequestMethod.GET })
	public String checkDeleteContent(Model model, int id) {
		contentService.delete(id);
		System.out.println("delete:" + id);
		return "redirect:" + "/user/view";
	}

}
