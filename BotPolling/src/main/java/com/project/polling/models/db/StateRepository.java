package com.project.polling.models.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, String> {
	State findStateByIdGroup(String idGroup);
}
