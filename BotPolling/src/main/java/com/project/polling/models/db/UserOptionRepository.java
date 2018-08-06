package com.project.polling.models.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOptionRepository extends JpaRepository<UserOption, Integer> {

	UserOption findByUserIdAndPolling(String userId, Polling polling);

}
