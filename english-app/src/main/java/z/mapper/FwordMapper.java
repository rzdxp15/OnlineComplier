package z.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import z.pojo.L4word;
import z.pojo.Words;

public interface FwordMapper extends BaseMapper<L4word>{
	
	
	  //@Select("select word,translation from fourwords,user,UserAndWord where UserAndWord.wid=word.id and UserAndWord.uid=#{uid}") 
	
	  // @Select("select word,translation from fourwords,user,UserAndWord where UserAndWord.wid=fourwords.id and UserAndWord.uid=#{uid}")
	   
	@Select("select * from fourwords where id in(select word_fourid from UserAndWord where uid=#{uid})")
	public IPage<L4word> listword(Page page, int cur,@Param("uid")int uid);
	 
}
