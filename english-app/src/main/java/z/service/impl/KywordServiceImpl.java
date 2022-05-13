package z.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import z.mapper.KywordMapper;
import z.pojo.Kyword;
import z.service.KywordService;

@Service
public class KywordServiceImpl extends ServiceImpl<KywordMapper, Kyword> implements KywordService{

}
