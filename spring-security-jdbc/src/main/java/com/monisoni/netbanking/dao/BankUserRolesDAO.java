package com.monisoni.netbanking.dao;

import java.util.List;

public interface BankUserRolesDAO {

	List<String> findRoleByUserId(Long userId);

}
