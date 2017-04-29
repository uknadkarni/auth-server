package com.example;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountUserDetailsService implements UserDetailsService {

	private Logger logger = Logger.getLogger(AccountUserDetailsService.class);
	private final AccountRepository ar;
	
	public AccountUserDetailsService(AccountRepository ar) {
		// TODO Auto-generated constructor stub
		this.ar = ar;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		logger.info("Searching for: " + username);
		Optional<Account> a = ar.findByUsername(username);
		if(a == null){
			throw new UsernameNotFoundException("Couldn't find the username " + username);
		}
		Account account = a.get();
		logger.info("Loading User: " + account);
		return new User(
				account.getUsername(),
				account.getPassword(),
				true, true, true, true, 
				AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
	}

}
