package com.sobis.leave.service.security;



import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.leave.dao.security.RoleDao;
import com.sobis.leave.model.security.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getRole(String id) {
		return roleDao.getRole(id);
	}
	
	@Override	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addRole(Role r) {
		DateTime createdDate = new DateTime();
		r.setCreatedOn(createdDate);
		r.setModifiedOn(createdDate);
		roleDao.createRole(r);		
		
	}
}
