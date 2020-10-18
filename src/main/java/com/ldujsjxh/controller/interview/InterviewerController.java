package com.ldujsjxh.controller.interview;

import com.ldujsjxh.domain.interview.CandidateBean;
import com.ldujsjxh.service.interview.InterviewerService;
import com.ldujsjxh.vo.interview.IntervieweeInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Alaskyed
 * @Date 27/09/2020 - 14:50
 * @Version 1.0
 * @Description 面试时部长的控制台
 */

@Controller
@ResponseBody
@Slf4j
@CrossOrigin
public class InterviewerController {
    @Autowired
    private InterviewerService interviewerService;

    /**
     * 管理员登录面试控制台时, 需要口令验证, 这里判断管理员口令是否正确
     *
     * @param adminPasswd
     * @return
     */
    @RequestMapping(value = "/java/interviewAdmin", method = RequestMethod.POST)
    public String isAdmin(String adminPasswd) {
        if (adminPasswd.equals("jsjxh210")) {
            return "console";
        } else if (adminPasswd.equals("interviewScore")) {
            return "interview";
        } else {
            return "no";
        }
    }

    /**
     * 获取某个部门未面试的人员姓名和id
     *
     * @param department
     * @return
     */
    @RequestMapping(value = "/java/getCondidatesByDepartment/{department}", method = RequestMethod.POST)
    public List<IntervieweeInfoVo> getCandidatesByDepartment(@PathVariable String department) {
        List<IntervieweeInfoVo> candidatesName = interviewerService.getCandidatesByDepartment(department);

        return candidatesName;
    }


    /**
     * 获取一个面试者的详细信息
     *
     * @param candidateId
     * @return
     */
    @RequestMapping(value = "/java/getCandidateDtail", method = RequestMethod.POST)
    public CandidateBean getCandidateDetail(String candidateId) {
        CandidateBean candidate = interviewerService.getCandidateDetail(candidateId);

        return candidate;
    }

    /**
     * 获取前端发来的下一个等候者的Id, 然后调整数据库面试state数据
     *
     * @param candidateId
     * @return
     */
    @RequestMapping(value = "/java/nextCandidate", method = RequestMethod.POST)
    public String nextCandidate(String candidateId) {
        try {
            interviewerService.nextCandidate(candidateId);
            return "yes";

        } catch (Exception e) {
            return "error";
        }

    }


    /**
     * 打分
     *
     * @return
     */
    @RequestMapping(value = "/java/candidateScore", method = RequestMethod.POST)
    public String candidateScore(String candidateId, int score) {
        try {
            interviewerService.score(candidateId, score);
            return "yes";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }
    }


}
