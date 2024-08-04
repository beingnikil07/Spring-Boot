package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@Service
@RequestScope
public class ContactService {


    private int counter = 0;

    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }

    /**
     * Save Contact Details into DB
     *
     * @param contact
     * @return boolean
     */

    public static boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;

        //TODO:Need to persist the data into the Db table,but as of now we are just logging it to the console
        log.info(contact.toString());
        return isSaved;
    }

    //getter
    public int getCounter() {
        return counter;
    }

    //setter
    public void setCounter(int counter) {
        this.counter = counter;

    }
}