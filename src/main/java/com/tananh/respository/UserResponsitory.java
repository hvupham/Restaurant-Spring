package com.tananh.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tananh.modal.User;

@Repository
public interface UserResponsitory extends JpaRepository<User, Long>{
//	public Optional<User> findByUserName(String userName);
	
	public User findByEmail(String email);
	    
//	@Query("SELECT u FROM User u WHERE u.userName LIKE %:query%")
//	public List<User> searchUser(@Param("query") String query);
	    
//	@Query("SELECT u FROM User u WHERE u.id IN :users")
//	public List<User> findAllUserByUserIds(@Param("users") List<Integer> users);
}
