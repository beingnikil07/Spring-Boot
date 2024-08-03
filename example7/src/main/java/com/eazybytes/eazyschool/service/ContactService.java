package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */

    public  static  boolean saveMessageDetails(Contact contact){
        boolean isSaved=true;

        //TODO:Need to persist the data into the Db table,but as of now we are just logging it to the console
        log.info(contact.toString());
        return isSaved;
    }
}
