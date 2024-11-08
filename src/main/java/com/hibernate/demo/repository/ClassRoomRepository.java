package com.hibernate.demo.repository;

import com.hibernate.demo.model.ClassRoom;
import com.hibernate.demo.model.ClassRoomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, ClassRoomId> {
}
