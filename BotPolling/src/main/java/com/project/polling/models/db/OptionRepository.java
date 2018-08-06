package com.project.polling.models.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Integer> {

	List<Option> findAllOptionByPolling(Polling polling);
	Option findOptionByOptionNameAndPolling(String optionName, Polling polling);
}
