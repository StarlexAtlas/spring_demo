package online.starlex.spring.controller;

import online.starlex.spring.entity.Model;
import online.starlex.spring.service.LoginService;
import online.starlex.spring.utils.ErrorCode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//这个注解可以让该controller下的所有方法允许跨域
@CrossOrigin
//Controller注解
@RestController
//请求映射注解，path即为请求地址（为整个controller添加时，即为添加了一个上层目录），method即为请求方法（用在方法前而不是controller类前）
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    LoginService loginService;

    @RequestMapping(path = "/test_url", method = RequestMethod.POST)
    public Model test(@RequestParam("test_id") int testId,
                      @RequestParam("password") String password) {
        Model model = new Model();
        //当该接口需要进行数据返回时，就需要准备这样一个容器，并将它添加到model中进行返回，方便前端进行数据解析
        JSONObject data = new JSONObject();
        /*
        上下两部分基本都是范例，每个方法实际不一样的是这个部分
        首先进行一次ErrorCode检查，这次检查主要是查看能不能进行实际操作，并且返回一个错误代码（也可能是OK）
        接着进行一次信息获取，把数据放到data中，需要注意的是，如果Error检查出错（不OK），就不能继续进行了，会导致服务器错误）
        */
        ErrorCode errorCode = loginService.login(testId, password);
        if (errorCode.getCode() == 0) {
            data.put("info", loginService.getInfo(testId));
        }

        model.setCode(errorCode.getCode());
        model.setMsg(errorCode.getMsg());
        model.setData(data);
        return model;
    }
}
