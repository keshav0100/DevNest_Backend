package com.keshav.projectify.repository;

import com.keshav.projectify.modal.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Subscription findByUserId(Long userId);

}
