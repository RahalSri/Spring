package com.rahal.resourceserver.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rahal.resourceserver.model.AccessTokenMapper;

@RestController
public class PermissionResource {

	@PreAuthorize("hasAnyRole('view_permission', 'SUPERADMIN')")
	@RequestMapping(value="/permissions", method=RequestMethod.GET)
	public ResponseEntity<String> getListOfPermissions() {
		AccessTokenMapper token = (AccessTokenMapper) ((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
		System.out.println(token.getFirst_name());
		return new ResponseEntity<String>("got permissions", HttpStatus.OK);
	}
}
