package com.dingtalk.isv.access.biz.service.message;

import com.alibaba.fastjson.JSON;
import com.dingtalk.isv.access.api.service.message.SendMessageService;
import com.dingtalk.isv.access.biz.base.BaseTestCase;
import com.dingtalk.isv.access.common.model.ServiceResult;
import com.dingtalk.open.client.api.model.corp.MessageBody;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by lifeng.zlf on 2016/3/22.
 */
public class SendMessageServiceTest  extends BaseTestCase {
    @Resource
    private SendMessageService sendMessageService;
    @Test
    public void test_sendMessage() {
        Long start = System.currentTimeMillis();
        String suiteKey="suite3vkhu3jypnqtdjsq";
        String corpId = "dingc20b6fdc2cc1c4bc35c2f4657eb6378f";
        Long appId = 5225L;
        MessageBody.OABody message = new MessageBody.OABody();
        MessageBody.OABody.Head head = new MessageBody.OABody.Head();
        MessageBody.OABody.Body body = new MessageBody.OABody.Body();
        head.setText("HEAD");
        head.setBgcolor("ffffa328");
        head.setText("客户详情");
        //body.setAuthor("dd_test");
        body.setContent("标题 \r\n 换行");
        body.setTitle("xxxxxxxx \r\n  换行");
        //body.setTitle("http://qr.dingtalk.com/page/crminfo?appid=-23&corpid=%24"+corpId+"%24&staffid=\"\"");
        message.setHead(head);
        message.setBody(body);
        message.setMessage_url("http://qr.dingtalk.com/page/crminfo?appid=5225&corpid="+corpId);
        //020434228123 qianxun   0566581316 fuxi dd_test
        ServiceResult<Void> sr = sendMessageService.sendOAMessageToUser(suiteKey, corpId, appId, "oa", Arrays.asList("manager8843", "0520526929734025", "16456261903649"),null,message);
        System.err.println("cost:"+(System.currentTimeMillis()-start));
        System.err.println(JSON.toJSONString(sr));
    }

}
