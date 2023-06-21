package edu.neusoft.model;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class TestJson {

    @Test
    public void test01()
    {
        Student student = new Student();
        student.setId(02);
        student.setName("Asahi");
        student.setAge(20);
        School school = new School();
        school.setName("NeuSoft");
        school.setAddress("大连甘井子街道");
        student.setSchool(school);
        String jsonString = JSONObject.toJSONString(student);
        System.out.println(jsonString);

    }

    @Test
    public void test02()
    {
        String json = "{\"age\":20,\"id\":2,\"name\":\"Asahi\",\"school\":{\"address\":\"大连甘井子街道\",\"name\":\"NeuSoft\"}}";
        Student student = JSONObject.parseObject(json,Student.class);
        System.out.println("Student=" + student.toString());
    }

    @Test
    public void test03(){
        String json = "{\"age\":20,\"id\":2,\"name\":\"Asahi\",\"school\":{\"address\":\"大连甘井子街道\",\"name\":\"NeuSoft\"}}";
        //取第一层
        JSONObject jsonObject = JSONObject.parseObject(json);
        //取第二层
        JSONObject school = jsonObject.getJSONObject("school");
        System.out.println(school);

        //获取学校名称中的school名字;
        String mystring = JSONObject.parseObject(json).getJSONObject("school").getString("address");
        System.out.println("String = " + mystring);
    }
}
