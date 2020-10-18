package com.ldujsjxh.mapper.interview;

import com.ldujsjxh.domain.interview.CandidateBean;
import com.ldujsjxh.vo.interview.IntervieweeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InterviewMapper {

    @Select("SELECT candidate_id, candidate_name, candidate_stu_id, " +
            "candidate_academy, desirable_department, state, `position` " +
            "FROM candidates c " +
            "where state = 1 or state = 2;")
    List<IntervieweeVo> getNextCandidate();

    /**
     * 查询学号是否已经存在
     * @param candidateStuId
     * @return
     */
    @Select("SELECT COUNT(*) \n" +
            "FROM candidates c \n" +
            "where candidate_stu_id = #{candidateStuId}")
    int queryExistedStruIds(String candidateStuId);

    /**
     * 插入新的面试者
     * @param candidateBean
     */
    @Insert("INSERT into candidates(candidate_name, candidate_stu_id, candidate_academy, " +
            "candidate_class, desirable_department, candidate_obey_adjust) \n" +
            "values(#{c.candidateName},#{c.candidateStuId},#{c.candidateAcademy}, " +
            "#{c.candidateClass},#{c.desirableDepartment},#{c.candidateObeyAdjust} )")
    void insertNewCandidate(@Param("c") CandidateBean candidateBean);
}
