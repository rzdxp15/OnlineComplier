package z.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.extension.service.IService;

import z.pojo.Comprehension;
import z.pojo.cq;
import z.vo.Cprevo;

public interface ComService extends IService<Comprehension>{
	
	 List<Cprevo> listq(@Param("id")Integer id);
	/*
	 * @Select("SELECT * from comprehension") public List<cq>listq();
	 */
}
