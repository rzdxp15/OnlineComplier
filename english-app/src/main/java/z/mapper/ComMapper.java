package z.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import z.pojo.Comprehension;

import z.vo.Cprevo;

public interface ComMapper extends BaseMapper<Comprehension>{
	
	  @Select("select  t1.ans,t2.* from Comprehension t1  left join cq t2 ON t1.id=t2.qid WHERE t1.id=#{id} ")
	 List<Cprevo>listq(@Param("id")Integer id);
}
