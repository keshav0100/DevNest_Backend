package com.keshav.projectify.service;

import com.keshav.projectify.modal.PlanType;
import com.keshav.projectify.modal.Subscription;
import com.keshav.projectify.modal.User;

public interface SubscriptionService {

    Subscription createSubscription(User user);

    Subscription getUsersSubscription(Long userId)throws Exception;

    Subscription upgradeSubscription(Long userId, PlanType planType)throws Exception;

    boolean isValid(Subscription subscription);
}
