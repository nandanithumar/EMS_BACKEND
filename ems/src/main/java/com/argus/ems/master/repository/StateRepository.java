package com.argus.ems.master.repository;

import com.argus.ems.master.model.StateEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, String> {
    
    public Page<StateEntity> findAll(Pageable pageable);

    @Query("SELECT DISTINCT entity FROM StateEntity entity \n"
            + " WHERE entity.id IN (:ids)")
    public List<StateEntity> findStatesByIds(@Param("ids") List<String> ids);

     public Page<StateEntity> findByRefObjectUriContainingIgnoreCase(String refObjectUri,
            Pageable pageable);

    public Page<StateEntity> findByRefObjectUriAndNameContainingIgnoreCase(
            String refObjectUri,
            String name,
            Pageable pageable);
    
     public Page<StateEntity> findByNameContainingIgnoreCase(
            String name,
            Pageable pageable);
   
}
