package com.szs.account.repositories;

import com.szs.account.models.AccountSyncLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountSyncLogsRepository extends JpaRepository<AccountSyncLogs, Long> {

}
