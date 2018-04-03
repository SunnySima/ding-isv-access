package com.dingtalk.isv.access.biz.service.corp;

import com.alibaba.fastjson.JSON;
import com.dingtalk.isv.access.api.model.LoginUserVO;
import com.dingtalk.isv.access.api.model.EmpVO;
import com.dingtalk.isv.access.api.service.EmpManageService;
import com.dingtalk.isv.access.biz.base.BaseTestCase;
import com.dingtalk.isv.access.common.model.ServiceResult;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mint on 16-1-22.
 */
public class StaffManageServiceTest extends BaseTestCase {
    @Resource
    private EmpManageService empManageService;

    @Test
    public void test_getStaff() {
        String suiteKey= "suite3vkhu3jypnqtdjsq";
        String corpId = "dingc20b6fdc2cc1c4bc35c2f4657eb6378f";
        String staffId = "manager8843";
        ServiceResult<EmpVO> sr = empManageService.getEmpByUserId(staffId,corpId,suiteKey);
        System.err.println(JSON.toJSON(sr));
    }


    @Test
    public void test_getStaffByCode(){
        String suiteKey= "suite3vkhu3jypnqtdjsq";
        String corpId = "dingc20b6fdc2cc1c4bc35c2f4657eb6378f";
        List<String> users = Arrays.asList("manager8843");
        ServiceResult<LoginUserVO> userSr = empManageService.getEmpByAuthCode(suiteKey, corpId, "1xxxx");
        System.out.print(JSON.toJSON(userSr));
    }
}
