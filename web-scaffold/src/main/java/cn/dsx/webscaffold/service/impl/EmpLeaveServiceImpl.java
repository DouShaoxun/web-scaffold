package cn.dsx.webscaffold.service.impl;

import cn.dsx.webscaffold.dao.EmpLeaveMapper;
import cn.dsx.webscaffold.model.EmpLeave;
import cn.dsx.webscaffold.service.EmpLeaveService;
import cn.dsx.webscaffold.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/03/12.
 */
@Service
@Transactional
public class EmpLeaveServiceImpl extends AbstractService<EmpLeave> implements EmpLeaveService {
    @Resource
    private EmpLeaveMapper empLeaveMapper;

}
