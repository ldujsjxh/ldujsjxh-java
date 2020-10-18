package com.ldujsjxh.service.interview;

import com.ldujsjxh.domain.interview.CandidateBean;
import com.ldujsjxh.mapper.interview.InterviewMapper;
import com.ldujsjxh.vo.interview.IntervieweeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    private InterviewMapper intervieMapper;

    /**
     * 前台大屏幕获取正在面试和门口等侯的
     *
     * @return
     */
    public List<IntervieweeVo> getNextCandidate() {
        //查找标志位为1和2的报名者
        List<IntervieweeVo> nextList = intervieMapper.getNextCandidate();
        return nextList;
    }

    @Transactional
    public String addCandidate(CandidateBean candidateBean) {
        //判断学号是否存在
        int existedStuIds = intervieMapper.queryExistedStruIds(candidateBean.getCandidateStuId());
        if (existedStuIds == 0) {
            //不存在，插入新数据
            intervieMapper.insertNewCandidate(candidateBean);
            return "yes";
        } else {
            return "no";
        }


    }
}
