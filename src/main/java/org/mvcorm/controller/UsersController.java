package org.mvcorm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mvcorm.dto.UsersDTO;
import org.mvcorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("users")
public class UsersController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("users");
		return view;
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSaved(UsersDTO usersDTO) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userService.saveOrUpdate(usersDTO)) {
			map.put("status", "200");
			map.put("message", "Records of " + usersDTO.getUsername() + " have been saved successfully");
		}
		return map;
	}

	public @ResponseBody Map<String, Object> getAllUsers(UsersDTO usersDTO) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<UsersDTO> allUsersList = userService.getAllUsersList();

		if (allUsersList != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", allUsersList);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}
		return map;
	}

	public @ResponseBody Map<String, Object> delete(UsersDTO usersDTO) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userService.delete(usersDTO)) {
			map.put("status", "200");
			map.put("message", "Records of " + usersDTO.getUsername() + " have been deleted successfully");
		}
		return map;
	}
}