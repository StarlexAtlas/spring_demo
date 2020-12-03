package online.starlex.spring.entity;

import org.json.JSONObject;

//与其他entity不同，这个entity只是为了封装返回数据，并使得返回数据容易解析
public class Model {
    private int code;
    private String msg;
    private JSONObject data;

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

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        JSONObject model = new JSONObject();
        model.put("code", this.code);
        model.put("msg", this.msg);
        model.put("data", this.data);
        return model.toString();
    }
}
