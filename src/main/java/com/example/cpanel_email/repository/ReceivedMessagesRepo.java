package com.example.cpanel_email.repository;

import com.example.cpanel_email.entity.MessagesDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivedMessagesRepo extends JpaRepository<MessagesDb , Long> {
}
