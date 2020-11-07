package com.ldujsjxh.controller.interview;

import com.ldujsjxh.domain.interview.CandidateBean;
import com.ldujsjxh.service.interview.InterviewerService;
import com.ldujsjxh.utils.RequestInfoUtils;
import com.ldujsjxh.vo.interview.IntervieweeInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private HttpServletRequest request;


    /**
     * 管理员登录面试控制台时, 需要口令验证, 这里判断管理员口令是否正确
     *
     * @param adminPasswd
     * @return
     */
    @RequestMapping(value = "/java/interviewAdmin", method = RequestMethod.POST)
    public String isAdmin(String adminPasswd) {
        if (adminPasswd.equals("jsjxh210")) {
            log.info("登录面试控制台:"+"^"+"设备信息:"+RequestInfoUtils.getIPAndDeviceInfo(request));
            return "console";
        } else if (adminPasswd.equals("interviewScore")) {
            log.info("登录打分界面"+"^"+"设备信息:"+RequestInfoUtils.getIPAndDeviceInfo(request));
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
            log.info("更新面试等候者:"+candidateId);
            return "yes";

        } catch (Exception e) {
            log.error(e.toString());
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
            log.error(e.toString());
            return "error";
        }
    }

    /**
     * 根据id删除报名者信息
     * @param candidateId
     * @return
     */
    @RequestMapping(value = "/java/deleteCondidatesById", method = RequestMethod.POST)
    public String delCandidate(int candidateId) {
        try {
            interviewerService.delCandidate(candidateId);
            log.info("删除报名者信息:"+candidateId);
            return "yes";
        } catch (Exception e) {
            log.error(e.toString());
            return "error";
        }
    }


}
