package com.ldujsjxh.service.interview;

import com.ldujsjxh.domain.interview.CandidateBean;
import com.ldujsjxh.mapper.interview.InterviewerMapper;
import com.ldujsjxh.vo.interview.IntervieweeInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Alaskyed
 * @Date 27/09/2020 - 15:19
 * @Version 1.0
 * @Description
 */

@Service
public class InterviewerService {
    @Autowired
    private InterviewerMapper interviewerMapper;

    /**
     * 获取某个部门的所有报名者的信息
     *
     * @param department
     * @return
     */
    public List<IntervieweeInfoVo> getCandidatesByDepartment(String department) {
        List<IntervieweeInfoVo> candidatesName = interviewerMapper.getCandidateByDepartment(department);
        for (IntervieweeInfoVo intervieweeInfoVo : candidatesName) {
            String scoreStrs[]=intervieweeInfoVo.getScore().split("_");
            double sumScore = Double.parseDouble(scoreStrs[0]);
            double numCount= Double.parseDouble(scoreStrs[1]);

            if (numCount > 0) {
                double avgScore = sumScore / numCount;
                intervieweeInfoVo.setScore(String.format("%.2f", avgScore));
            } else {
                intervieweeInfoVo.setScore("0");
            }
        }


        return candidatesName;

    }

    /**
     * 获取某个报名者的详细报名信息
     *
     * @param candidateId
     * @return
     */
    public CandidateBean getCandidateDetail(String candidateId) {
        CandidateBean candidate = interviewerMapper.getandidateDetailById(candidateId);

        return candidate;
    }

    /**
     * 调整数据库面试state
     *
     * @param candidateId
     */
    @Transactional
    public void nextCandidate(String candidateId) {
        //将原来等待和面试的state+1
        interviewerMapper.setOldCandidateState();
        //将新的id对应的人state设置为1
        interviewerMapper.setNewCondidateState(candidateId);
    }

    /**
     * 添加面试分数
     *
     * @param candidateId
     * @param score
     * @return
     */
    @Transactional
    public String score(String candidateId, int score) {
        //首先从数据库获取分数字符串
        String scoreStr = interviewerMapper.getScoreById(candidateId);
        if (scoreStr != null) {

            //根据 _ 分割
            String[] scoreStrs = scoreStr.split("_");
            //字符串转换成int
            int sumScore = Integer.parseInt(scoreStrs[0]);
            int numCount = Integer.parseInt(scoreStrs[1]);
            sumScore = sumScore + score;
            numCount = numCount + 1;
            //重新组合字符串
            scoreStr = sumScore + "_" + numCount;
            //更新数据库
            interviewerMapper.updateScoreById(candidateId, scoreStr);
            return "yes";
        } else {
            return "cadidateIdNotFound";
        }
    }

    /**
     * 根据id删除报名者信息
     * @param candidateId
     */
    public void delCandidate(int candidateId) {
        interviewerMapper.deleteCandidateById(candidateId);
    }
}
