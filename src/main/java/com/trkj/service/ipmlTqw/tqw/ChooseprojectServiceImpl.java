package com.trkj.service.ipmlTqw.tqw;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.dao.tqw.ChooseprojectnameMapper;
import com.trkj.entity.tqw.ChooseProject;
import com.trkj.service.ipmlTqw.ChooseprojectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChooseprojectServiceImpl extends ServiceImpl<ChooseprojectnameMapper, ChooseProject> implements ChooseprojectService {
}
