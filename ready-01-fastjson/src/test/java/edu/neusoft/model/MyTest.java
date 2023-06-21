package edu.neusoft.model;

import edu.neusoft.model.Student;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class MyTest {

    @Test
    public void testToJson()
    {
        Student student = new Student();
        student.setId(1);
        student.setName("Spice");
        student.setAge(20);
        String json = JSONObject.toJSONString(student);
        // {"age":20,"id":1,"name":"Spice"}
        System.out.println("把Student转换为Json"+json);
    }

    @Test
    public void testToObject() {
        String json = "{\"age\":20,\"id\":1,\"name\":\"Spice\"}";
        Student student  = JSONObject.parseObject(json,Student.class);
        System.out.println("Student="+student);
        //获取学生名字
        System.out.println(student.getName());
    }

    @Test
    //获取name的Key值
    public void testToAccessValue() {
        String json = "{\"age\":20,\"id\":1,\"name\":\"Spice\"}";

        //Json Object是一个map 通过get方法去值
        JSONObject jsonObject = JSONObject.parseObject(json);

        String name = jsonObject.getString("name");
        System.out.println("name=" +name);

    }



}
