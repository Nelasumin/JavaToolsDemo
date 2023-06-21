package edu.neusoft.test;


import com.azul.crs.client.Client;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.junit.Test;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpTest {


    /**
     * 这是一个Get请求
     * */
    @Test
    public void test01()
    {
        //api接口
        String url="https://restapi.amap.com/v3/ip?key=0113a13c88697dcea6a445584d535837&ip=42.52.87.220";
        //创建http对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建Get对象
        HttpGet get = new HttpGet(url);
        try
        {
            // 发情请求
            // CloseableHttpResponse:表示访问url后，对方给你返回的结果
            CloseableHttpResponse response = client.execute(get);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("访问地址后，得到结果内容："+result);
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Test
    public void test02()
    {
        // 创建Clent对象
        CloseableHttpClient client = HttpClients.createDefault();
        String url = "https://restapi.amap.com/v3/ip";
        //2:创建HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        // 创建   Post准备参数

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        //添加参数 BasicNameValuePair类，实现了NameValuesPair接口
        // BasicNameValuePair类
        params.add(new BasicNameValuePair("key","0113a13c88697dcea6a445584d535837"));
        params.add(new BasicNameValuePair("ip","42.52.87.220"));

        httpPost.setEntity(new UrlEncodedFormEntity(params));
        try {
            // 执行请求
            CloseableHttpResponse res = client.execute(httpPost);
            try {
                //读取数据
                String json = EntityUtils.toString(res.getEntity());
                System.out.println("json= "+json);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {

            }catch (Exception e)
            {
                try {
                    client.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }



    }


}
