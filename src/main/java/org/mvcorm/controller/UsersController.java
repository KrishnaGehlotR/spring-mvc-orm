package org.mvcorm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mvcorm.dto.UserDTO;
import org.mvcorm.mapper.UserMapper;
import org.mvcorm.model.Users;
import org.mvcorm.service.UsersService;
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
	UsersService userService;

	@Autowired
	UserMapper userMapper;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("users");
		return view;
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSaved(UserDTO usersDTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = userMapper.mapUserDTOToUser(usersDTO);
		if (userService.saveOrUpdate(user)) {
			map.put("status", "200");
			map.put("message", "Records of " + usersDTO.getUsername() + " have been saved successfully");
		}
		return map;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAllUsers(Users usersDTO) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Users> allUsersList = userService.getAllUsersList();

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

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(Users usersDTO) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userService.delete(usersDTO)) {
			map.put("status", "200");
			map.put("message", "Records of " + usersDTO.getUsername() + " have been deleted successfully");
		}
		return map;
	}
}