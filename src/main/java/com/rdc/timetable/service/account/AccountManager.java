package com.rdc.timetable.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;

import com.rdc.timetable.dao.account.AccountDao;
import com.rdc.timetable.entity.account.Account;
import com.rdc.timetable.service.ServiceException;

/**
 * 
 * @author crd 2012-5-27 下午03:26:11
 */

@Component
@Transactional
public class AccountManager {
	private AccountDao accountDao;

	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	
	public Page<Account> searchAccount(final Page<Account> page, final List<PropertyFilter> filters) {
		return accountDao.findPage(page, filters);
	} 
	
	@Transactional(readOnly = true)
	public Account getAccountByLoginName(String loginName) {
		return accountDao.findUniqueBy("loginName", loginName);
	} 
	
	@Transactional(readOnly = true)
	public Account getAccountById(Long id) {
		return accountDao.findUniqueBy("id", id);
	}
	
	public void saveAccount(Account entity) {
		accountDao.save(entity);
	} 
	
	/**
	 * 删除用户,如果尝试删除超级管理员将抛出异常.
	 */
	public void deleteAccount(Long id) {
		if (isSupervisor(id)) {
			throw new ServiceException("不能删除超级管理员用户");
		}
		accountDao.delete(id);
	}
	
	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}
	
	/**
	 * 检查用户名是否唯一.
	 *
	 * @return loginName在数据库中唯一或等于oldLoginName时返回true.
	 */
	@Transactional(readOnly = true)
	public boolean isLoginNameUnique(String newLoginName, String oldLoginName) {
		return accountDao.isPropertyUnique("loginName", newLoginName, oldLoginName);
	}
	
}
