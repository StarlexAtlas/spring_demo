package online.starlex.spring.service;

import online.starlex.spring.dao.TestInfoDao;
import online.starlex.spring.entity.TestInfo;
import online.starlex.spring.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    TestInfoDao testInfoDao;

    /**
     * 登录
     * @param testId testID
     * @param password 密码（明文）
     * @return 错误代码
     */
    public ErrorCode login(int testId, String password){
        if(testInfoDao.existsByTestId(testId)){
            TestInfo testInfo = testInfoDao.findByTestId(testId);
            if(testInfo.getPassword().equals(password)){
                return ErrorCode.OK;
            } else {
                return ErrorCode.PASSWORD_WRONG;
            }
        } else {
            return ErrorCode.TEST_USER_NOT_FOUNT;
        }
    }

    /**
     * 获取信息，需要testId存在性检查
     * @param testId testID
     * @return info
     */
    public String getInfo(int testId){
        TestInfo testInfo = testInfoDao.findByTestId(testId);
        return testInfo.getTestInfo();
    }
}
