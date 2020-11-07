package com.ldujsjxh.controller.contact;

import com.ldujsjxh.domain.contact.ContactInfoBean;
import com.ldujsjxh.service.contact.ContactUsService;
import com.ldujsjxh.utils.RequestInfoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@Slf4j
@ResponseBody
@CrossOrigin
public class ContactUsController {
    @Autowired
    ContactUsService contactUsService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 获取留言信息
     *
     * @param contactInfoBean
     * @return
     */
    @RequestMapping(value = "/java/newContactUs")
    public String getNewContactInfo(ContactInfoBean contactInfoBean) {
        try {
            contactUsService.getNewContactInfo(contactInfoBean);
            log.info("新的留言:"+contactInfoBean.getMessage()+"^"+"设备信息:"+ RequestInfoUtils.getIPAndDeviceInfo(request));
            return "yes";
        } catch (Exception e) {
            log.error(e.toString());
            return "error";
        }
    }
}
