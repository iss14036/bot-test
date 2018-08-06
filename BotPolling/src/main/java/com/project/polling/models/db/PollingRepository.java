package com.project.polling.models.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PollingRepository extends JpaRepository<Polling, Integer> {

	Polling findTopByOrderByIdDesc();
	boolean findByGroupPollingAndStatusPolling(String group, String status);
	Polling findPollingByGroupPollingAndStatusPolling(String group, String status);
}
