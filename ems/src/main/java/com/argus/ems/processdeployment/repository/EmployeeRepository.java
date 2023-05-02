//
//package com.argus.ems.processdeployment.repository;
//
//import com.argus.ems.master.repository.*;
//import com.argus.ems.master.model.TypeEntity;
//import java.util.List;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public interface EmployeeRepository extends JpaRepository<TypeEntity, String> {
//    
//    @Query("SELECT DISTINCT entity FROM TypeEntity entity \n"
//            + " WHERE entity.id IN (:ids)")
//    public List<TypeEntity> findTypesByIds(@Param("ids") List<String> ids);
//
//     @Query("SELECT DISTINCT type,state.name FROM TypeEntity type \n"
//            + " LEFT JOIN StateEntity state ON type.stateId = state.id \n"
//            + " WHERE type.refObjectUri = :refObjectUri"
//    )
//    public Page<Object[]> findByRefObjectUriContainingIgnoreCase(
//            @Param("refObjectUri") String refObjectUri,
//            Pageable pageable);
//
//    @Query("SELECT DISTINCT type,state.name FROM TypeEntity type \n"
//            + " LEFT JOIN StateEntity state ON type.stateId = state.id \n"
//            + " WHERE type.refObjectUri = :refObjectUri \n"
//            + " AND (:name IS NULL OR UPPER(type.name) LIKE CONCAT('%',UPPER(:name),'%')) \n"
//            + " AND (:stateId IS NULL OR type.stateId = :stateId)"
//    )
//    public Page<Object[]> findByRefObjectUriAndNameContainingIgnoreCase(
//            @Param("stateId") String stateId,
//            @Param("refObjectUri") String refObjectUri,
//            @Param("name") String name,
//            Pageable pageable);
//
//    public Page<Object[]> findByNameContainingIgnoreCase(
//            @Param("name") String name,Pageable pageable);
//}
