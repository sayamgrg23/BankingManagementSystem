package com.youtubesb.bankingmanagementsystem.Repository;

import com.youtubesb.bankingmanagementsystem.Entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
