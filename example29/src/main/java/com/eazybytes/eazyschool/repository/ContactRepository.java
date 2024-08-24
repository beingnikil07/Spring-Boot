package com.eazybytes.eazyschool.repository;
import com.eazybytes.eazyschool.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {


}
