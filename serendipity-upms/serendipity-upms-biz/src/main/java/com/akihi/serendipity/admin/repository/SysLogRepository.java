package com.akihi.serendipity.admin.repository;

import com.akihi.serendipity.admin.api.domain.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogRepository extends JpaRepository<SysLog, String>, JpaSpecificationExecutor<SysLog> {
}
