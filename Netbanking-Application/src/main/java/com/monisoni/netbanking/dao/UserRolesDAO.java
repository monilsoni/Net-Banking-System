package com.monisoni.netbanking.dao;

import java.util.List;

public interface UserRolesDAO {

	List<String> findRoleByUserId(Long userId);

}
