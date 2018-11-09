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

import eParking.ApiFunction;

public class SkyParkingWS {
  // 测试用例
  public String testWebService(String from) {
      String result = "Hello, world, from " + from + "Web Service test OK";
      System.out.println(result);
      return result;
  }

/*
<?xml version="1.0" encoding="UTF-8" ?>
<Request>
<Version>版本号</Version>
<MsgType>消息类型</MsgType>
<MsgSeq>消息序列号</MsgSeq>
<TimeStamp>时间戳</TimeStamp>
< Token >验证码</ Token >
< Body >请求报文体</Body >
</Request>
*/

  // 数据交互接口
  public String getWebMsg(String xml) {
    String result = "err msg";

    if (xml != null && xml.length() != 0) {
      try {

        // 读取并解析XML文档
        // SAXReader就是一个管道，用一个流的方式，把xml文件读出来
        //创建SAXReader对象
        // SAXReader saxReader = new SAXReader();
        //找到定义的xml文件,把里面的内容变成Document对象
        // Document document = reader.read(new File("User.xml")); //User.xml表示你要解析的xml文档
        // 解析xml字符串
        Document document = DocumentHelper.parseText(xml); // 将字符串转为XML;
        //获取根节点元素对象
        Element root = document.getRootElement();
        if (root.getName() != "Request") return result;

        //获取Version子节点(版本号)
        Element elVersion = root.element("Version");
        //获取MsgType子节点(消息类型)
        Element elMsgType = root.element("MsgType");
        //获取MsgSeq子节点(消息序列号)
        Element elMsgSeq = root.element("MsgSeq");
        //获取TimeStamp子节点(时间戳)
        Element elTimeStamp = root.element("TimeStamp");
        //获取Token子节点(验证码)
        Element elToken = root.element("Token");
        //获取Body子节点(请求报文体)
        Element elBody = root.element("Body");

        if (elVersion != null && elMsgType != null && elMsgSeq != null && elTimeStamp != null
                && elToken != null && elBody != null) {
          // 获取节点内容
          String strVersion = elVersion.getText();
          System.out.println("版本号：" + strVersion);
          String strMsgType = elMsgType.getText();
          System.out.println("消息类型：" + strMsgType);
          String strMsgSeq = elMsgSeq.getText();
          System.out.println("消息序列号：" + strMsgSeq);
          String strTimeStamp = elTimeStamp.getText();
          System.out.println("时间戳：" + strTimeStamp);
          String strToken = elToken.getText();
          System.out.println("验证码：" + strToken);
          String strBody = elBody.getText();
          System.out.println("请求报文体：" + strBody);

          // 检验节点内容是否为空
          if (strVersion == "" || strMsgType == "" || strMsgSeq == "" || strTimeStamp == ""
                  || strToken == "" || strBody == "") return result;

          // 校验版本
          if (!strVersion.equals("1.0.0.1")) return result = "error version";
          // 校验消息序列号
          // 校验时间戳
          // 校验验证码

          ApiFunction apifunc = new ApiFunction();
          result = apifunc.WsApiFunc(strMsgType, strBody);
        }
      } catch (DocumentException e) {
        e.printStackTrace();
      }
    }
    return result;
  }

}
