package com.ldujsjxh.controller.interview;

import com.ldujsjxh.domain.interview.CandidateBean;
import com.ldujsjxh.service.interview.InterviewService;
import com.ldujsjxh.vo.interview.IntervieweeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@ResponseBody
@CrossOrigin
public class InterviewController {
    @Autowired
    private InterviewService intervieService;


    /**
     * 获取下一个面试者
     *
     * @return 面试者对象
     */
    @RequestMapping(value = "/java/getNextCandidate", method = RequestMethod.GET)
    public List<IntervieweeVo> getNextCandidate() {
        List<IntervieweeVo> nextList = intervieService.getNextCandidate();

        return nextList;
    }


    /**
     * 添加一个面试者
     *
     * @param candidateBean
     * @return
     */
    @RequestMapping(value = "/java/addCandidate", method = RequestMethod.POST)
    public String addCandidate(CandidateBean candidateBean) {
        String isExisted = "no";
        try {
            isExisted = intervieService.addCandidate(candidateBean);
            return isExisted;
        } catch (Exception e) {
            System.out.println(e);
            return isExisted;
        }

    }

}
