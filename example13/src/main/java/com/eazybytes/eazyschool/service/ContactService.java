package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */
@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
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