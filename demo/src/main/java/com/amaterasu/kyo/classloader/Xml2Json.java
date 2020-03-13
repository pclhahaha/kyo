package com.amaterasu.kyo.classloader;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-13 10:51
 **/
public class Xml2Json {

    @Test
    public void jacksonXml2Json() throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        Request request = new Request();
        request.setService("RouteService");
        request.setLang("zh-CN");
        request.setCode("SLK");
        Request.Body body = new Request.Body();
        Request.RouteRequest routeRequest = new Request.RouteRequest();
        routeRequest.setCheck_phoneNo("111");
        routeRequest.setMethod_type("1");
        routeRequest.setTracking_number("1111111111");
        routeRequest.setTracking_type("1");
        body.setRouteRequest(routeRequest);
        request.setBody(body);
        String xml = xmlMapper.writeValueAsString(request);
        System.out.println(xml);
        System.out.println(JSON.toJSONString(request));
    }

    String file = "package com.dianping.dzopen.gateway.server.core.nonstandard.invoker.util;\n" +
            "\n" +
            "import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;\n" +
            "\n" +
            "/**\n" +
            " * @description:\n" +
            " * @author: panchenlei\n" +
            " * @create: 2020-03-12 18:18\n" +
            " **/\n" +
            "public class Request {\n" +
            "\n" +
            "\n" +
            "    String service;\n" +
            "\n" +
            "    String lang;\n" +
            "\n" +
            "    String code;\n" +
            "\n" +
            "    Body Body;\n" +
            "\n" +
            "    @JacksonXmlProperty(isAttribute = true)\n" +
            "    public String getService() {\n" +
            "        return service;\n" +
            "    }\n" +
            "\n" +
            "    public void setService(String service) {\n" +
            "        this.service = service;\n" +
            "    }\n" +
            "\n" +
            "    @JacksonXmlProperty(isAttribute = true)\n" +
            "    public String getLang() {\n" +
            "        return lang;\n" +
            "    }\n" +
            "\n" +
            "    public void setLang(String lang) {\n" +
            "        this.lang = lang;\n" +
            "    }\n" +
            "\n" +
            "    @JacksonXmlProperty(localName = \"Head\")\n" +
            "    public String getCode() {\n" +
            "        return code;\n" +
            "    }\n" +
            "\n" +
            "    public void setCode(String code) {\n" +
            "        this.code = code;\n" +
            "    }\n" +
            "\n" +
            "    @JacksonXmlProperty(localName = \"Body\")\n" +
            "    public Body getBody() {\n" +
            "        return Body;\n" +
            "    }\n" +
            "\n" +
            "    public void setBody(Body body) {\n" +
            "        Body = body;\n" +
            "    }\n" +
            "\n" +
            "    public static class Body {\n" +
            "\n" +
            "\n" +
            "        RouteRequest RouteRequest;\n" +
            "\n" +
            "        @JacksonXmlProperty(localName = \"RouteRequest\")\n" +
            "        public RouteRequest getRouteRequest() {\n" +
            "            return RouteRequest;\n" +
            "        }\n" +
            "\n" +
            "        public void setRouteRequest(RouteRequest routeRequest) {\n" +
            "            RouteRequest = routeRequest;\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    public static class RouteRequest {\n" +
            "\n" +
            "\n" +
            "        String tracking_type;\n" +
            "\n" +
            "        String method_type;\n" +
            "\n" +
            "        String tracking_number;\n" +
            "\n" +
            "        String check_phoneNo;\n" +
            "\n" +
            "        @JacksonXmlProperty(isAttribute = true)\n" +
            "        public String getTracking_type() {\n" +
            "            return tracking_type;\n" +
            "        }\n" +
            "\n" +
            "        public void setTracking_type(String tracking_type) {\n" +
            "            this.tracking_type = tracking_type;\n" +
            "        }\n" +
            "\n" +
            "        @JacksonXmlProperty(isAttribute = true)\n" +
            "        public String getMethod_type() {\n" +
            "            return method_type;\n" +
            "        }\n" +
            "\n" +
            "        public void setMethod_type(String method_type) {\n" +
            "            this.method_type = method_type;\n" +
            "        }\n" +
            "\n" +
            "        @JacksonXmlProperty(isAttribute = true)\n" +
            "        public String getTracking_number() {\n" +
            "            return tracking_number;\n" +
            "        }\n" +
            "\n" +
            "        public void setTracking_number(String tracking_number) {\n" +
            "            this.tracking_number = tracking_number;\n" +
            "        }\n" +
            "\n" +
            "        @JacksonXmlProperty(isAttribute = true)\n" +
            "        public String getCheck_phoneNo() {\n" +
            "            return check_phoneNo;\n" +
            "        }\n" +
            "\n" +
            "        public void setCheck_phoneNo(String check_phoneNo) {\n" +
            "            this.check_phoneNo = check_phoneNo;\n" +
            "        }\n" +
            "    }\n" +
            "}\n";

    String json1 = "{\"body\":{\"routeRequest\":{\"check_phoneNo\":\"111\",\"method_type\":\"1\",\"tracking_number\":\"1111111111\",\"tracking_type\":\"1\"}},\"code\":\"SLK\",\"lang\":\"zh-CN\",\"service\":\"RouteService\"}\n";

    @Test
    public void loadClassFromFileThenConvertXml() throws IOException, ClassNotFoundException {
        JavaStringCompiler compiler = new JavaStringCompiler();
        Map<String, byte[]> javas = compiler.compile("Request.java", file);
        Class request = compiler.loadClass("com.dianping.dzopen.gateway.server.core.nonstandard.invoker.util.Request", javas);

        Object object = JSON.parseObject(json1, request);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(object);
        System.out.println(xml);

    }
}
