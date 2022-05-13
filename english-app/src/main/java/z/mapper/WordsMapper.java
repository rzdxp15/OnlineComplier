package z.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import z.pojo.L4word;
import z.pojo.Words;

public interface WordsMapper extends BaseMapper<Words>{

	@Select("select * from sixwords where id in(select word_sixid from UserAndWord where uid=#{uid})")
	public IPage<Words> listword(Page page, int cur,@Param("uid")int uid);
}
