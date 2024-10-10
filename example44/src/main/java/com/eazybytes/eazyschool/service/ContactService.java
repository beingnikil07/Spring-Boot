package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.config.EazySchoolProps;
import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */
@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    EazySchoolProps eazySchoolProps;


    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved =false;
        contact.setStatus(EazySchoolConstants.OPEN);
        Contact savedContact=contactRepository.save(contact);
        if (null!=savedContact && savedContact.getContactId()>0){
            isSaved=true;
        }
        return isSaved;
    }



    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){
        int pageSize = eazySchoolProps.getPageSize();
        if(null!=eazySchoolProps.getContact() && null!=eazySchoolProps.getContact().get("pageSize")){
            pageSize = Integer.parseInt(eazySchoolProps.getContact().get("pageSize").trim());
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatusWithQuery(
                EazySchoolConstants.OPEN,pageable);
        return msgPage;
    }



    public boolean updateMsgStatus(int contactId) {
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(EazySchoolConstants.CLOSE);
        });
        Contact updatedContact=contactRepository.save(contact.get());
        if(null!=updatedContact&&updatedContact.getUpdatedBy()!=null){
            isUpdated=true;
        }
        return  isUpdated;
    }


}