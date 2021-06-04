package com.novopay.repositories;

@org.springframework.stereotype.Repository
public interface UserRespository extends org.springframework.data.jpa.repository.JpaRepository<com.novopay.domain.User, Long> {
}
