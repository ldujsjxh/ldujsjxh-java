package com.ldujsjxh.service.contact;

import com.ldujsjxh.domain.contact.ContactInfoBean;
import com.ldujsjxh.mapper.contact.ContactUsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Alaskyed
 * @Date: 25/10/2020 - 20:31
 * @Version: v1.0
 * @Description:
 */
@Service
public class ContactUsService {
    @Autowired
    private ContactUsMapper contactUsMapper;

    @Transactional
    public void getNewContactInfo(ContactInfoBean contactInfoBean) {
        contactUsMapper.insertNewContactUs(contactInfoBean);
    }
}
