package eParking;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ApiFunction {
    public String WsApiFunc(String funcName, String param) {
        String result = "error Invoke";
        if (funcName == null || param == null || funcName == "" || param == "")
            return result;

        // 校验接口
        switch (funcName) {
            case "ADD_USER_ACCOUNT": {  // 管理登录用户接口
                result = this.addUserAccount(param);
                break;
            }
            case "MODIFY_USER_ACCOUNT": {  // 修改或删除管理员用户信息接口
                result = this.modifyUserAccount(param);
                break;
            }
            case "UPLOAD_PARKING_DATA": { // 进出车场/交易数据接口
                result = "Upload success";
                break;
            }
            case "GET_PAYMENT": {  // 第三方付费平台同步接口
                result = "finished pay";
                break;
            }
            default: {
                result = "error MsgType";
                break;
            }
        }

        return result;
    }

    private String addUserAccount(String param) {
        String result = "error paramester";

        if (param != null && param != "") {
            result = "Add user success";
        }

        return result;
    }

    private String modifyUserAccount(String param) {
        String result = "error paramester";

        if (param != null && param != "") {
            result = "Modify user success";
        }

        return result;
    }
}
