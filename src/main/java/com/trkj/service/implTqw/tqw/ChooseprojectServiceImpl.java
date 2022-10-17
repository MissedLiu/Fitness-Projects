package com.trkj.service.implTqw.tqw;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.ChooseProjectNameMapper;
import com.trkj.entity.tqw.ChooseProjectName;
import com.trkj.service.implTqw.ChooseprojectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChooseprojectServiceImpl extends ServiceImpl<ChooseProjectNameMapper, ChooseProjectName> implements ChooseprojectService {
}
