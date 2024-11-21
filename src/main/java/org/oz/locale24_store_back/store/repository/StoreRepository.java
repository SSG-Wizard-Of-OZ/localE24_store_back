package org.oz.locale24_store_back.store.repository;

import org.oz.locale24_store_back.store.domain.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
}
