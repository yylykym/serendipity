package com.akihi.serendipity.umps.repository;

import com.akihi.serendipity.admin.api.domain.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysLogRepository extends JpaRepository<SysLog, String>, JpaSpecificationExecutor<SysLog> {
}
