package com.eazybytes.eazyschool.repository;
import com.eazybytes.eazyschool.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

    List<Contact> findByStatus(String status);


//    @Query("SELECT c FROM Contact c WHERE c.status= :status")      //    -->JPQL example
@Query(value = "SELECT * FROM contact_msg c WHERE c.status= :status",nativeQuery = true)    // -->Native query
Page<Contact> findByStatusWithQuery(String status, Pageable pageable);
}
