package com.cyc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyTest {

    /**
     * 请实现 urlencode 这个函数，对于传入的参数 hostUrl 和 params，能够返回正确的 encode 后的 url 结果
     * 以Python为例子，调用 urlencode("http://www.baidu.com/", {"a": "1", "b": "2"})
     * 返回结果是 http://www.baidu.com/?a=1&b=2
     */
    @Test
    public void test(){
        HashMap<String,String> params = new HashMap<String, String>();
        params.put("a","1");
        params.put("b","2");
        System.out.println(urlencde("http://www.baidu.com/",params));
    }
    public String urlencde(String hostUrl, HashMap<String,String> params){
        StringBuffer stringBuffer = new StringBuffer(hostUrl);
        Iterator iterator = params.entrySet().iterator();
        int i = 1;
        while(iterator.hasNext()){
            Map.Entry entry =(Map.Entry) iterator.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            if(i == 1){
                stringBuffer.append("?"+key+"="+value);
                i=0;
            }else{
                stringBuffer.append("&"+key+"="+value);
            }
        }
        return stringBuffer.toString();
    }
}
