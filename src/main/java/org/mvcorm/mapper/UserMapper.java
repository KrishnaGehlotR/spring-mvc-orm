package org.mvcorm.mapper;

import org.mvcorm.dto.UserDTO;
import org.mvcorm.model.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	// convert DTO to Entity object

	public Users mapUserDTOToUser(UserDTO userDTO) {
		Users users = new Users();
		if (userDTO != null) {
			users.setUserId(userDTO.getUserId());
			users.setEmailId(userDTO.getEmailId());
			users.setUsername(userDTO.getUsername());

		}
		return users;
	}

	// convert Entity Object to DTO

}
