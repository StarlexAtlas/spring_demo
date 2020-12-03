package online.starlex.spring.utils;

public enum ErrorCode {
    OK(0, "成功"),
    PASSWORD_WRONG(-1, "密码错误"),
    TEST_USER_NOT_FOUNT(-2, "用户不存在"),
    ;
    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
