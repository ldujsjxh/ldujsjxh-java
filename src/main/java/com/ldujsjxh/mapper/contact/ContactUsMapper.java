package com.ldujsjxh.mapper.contact;

import com.ldujsjxh.domain.contact.ContactInfoBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Alaskyed
 * @Date: 25/10/2020 - 21:52
 * @Version: v1.0
 * @Description:
 */
public interface ContactUsMapper {

    /**
     * 插入新的联系我们消息
     * @param contactInfoBean
     */
    @Insert("INSERT into contact_us(name,academy,qq,phone_number,message) " +
            "values(#{c.name},#{c.academy},#{c.qq},#{c.phoneNumber},#{c.message})")
    void insertNewContactUs(@Param("c") ContactInfoBean contactInfoBean);
}
