package com.sspring.converter;

import com.sspring.bean.Role;
import com.sspring.dto.RoleDto;

/**
 * Converter class from Role hibernate entity to DTO
 * 
 * @author ralucab
 *
 */
public final class RoleDtoConverter {
	public static RoleDto toDto(Role role) {
		RoleDto roleDto = new RoleDto();

		roleDto.setId(role.getId());
		roleDto.setRole(role.getRole());

		return roleDto;
	}

	public static Role toEntity(RoleDto roleDto) {
		Role role = new Role();

		role.setId(roleDto.getId());
		role.setRole(roleDto.getRole());

		return role;
	}
}
