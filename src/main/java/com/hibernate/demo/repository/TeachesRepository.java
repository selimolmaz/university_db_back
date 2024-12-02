package com.hibernate.demo.repository;

import com.hibernate.demo.model.Section;
import com.hibernate.demo.model.Teaches;
import com.hibernate.demo.model.compositeIds.TeachesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeachesRepository extends JpaRepository<Teaches, TeachesId> {
    @Query("SELECT t FROM Teaches t WHERE t.courseId = :courseId " +
            "AND t.secId = :secId " +
            "AND t.semester = :semester " +
            "AND t.year = :year")
    Optional<Teaches> findBySection(
            @Param("courseId") String courseId,
            @Param("secId") String secId,
            @Param("semester") String semester,
            @Param("year") int year
    );

    List<Teaches> findByInstructorId(String instructorId);

    List<Teaches> findByCourseId(String courseId);

}
