package com.resway.server.dto;

import java.util.ArrayList;
import java.util.List;

import com.resway.server.framework.dto.BaseResponseDTO;

public class UserResponseDTO extends BaseResponseDTO {
	private List<UserDTO> dtos;
	
	public UserResponseDTO() {
		super();
		dtos = new ArrayList<UserDTO>();
	}

	public List<UserDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<UserDTO> dtos) {
		this.dtos = dtos;
	}

	@Override
	public String toString() {
		return "UserResponseDTO [dtos=" + dtos + "]";
	}
}
