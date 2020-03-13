package com.amaterasu.kyo.classloader;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @description:
 * @author: panchenlei
 * @create: 2020-03-12 18:18
 **/
public class Request {


    String service;

    String lang;

    String code;

    Body Body;

    @JacksonXmlProperty(isAttribute = true)
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @JacksonXmlProperty(isAttribute = true)
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @JacksonXmlProperty(localName = "Head")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JacksonXmlProperty(localName = "Body")
    public Body getBody() {
        return Body;
    }

    public void setBody(Body body) {
        Body = body;
    }

    public static class Body {


        RouteRequest RouteRequest;

        @JacksonXmlProperty(localName = "RouteRequest")
        public RouteRequest getRouteRequest() {
            return RouteRequest;
        }

        public void setRouteRequest(RouteRequest routeRequest) {
            RouteRequest = routeRequest;
        }
    }

    public static class RouteRequest {


        String tracking_type;

        String method_type;

        String tracking_number;

        String check_phoneNo;

        @JacksonXmlProperty(isAttribute = true)
        public String getTracking_type() {
            return tracking_type;
        }

        public void setTracking_type(String tracking_type) {
            this.tracking_type = tracking_type;
        }

        @JacksonXmlProperty(isAttribute = true)
        public String getMethod_type() {
            return method_type;
        }

        public void setMethod_type(String method_type) {
            this.method_type = method_type;
        }

        @JacksonXmlProperty(isAttribute = true)
        public String getTracking_number() {
            return tracking_number;
        }

        public void setTracking_number(String tracking_number) {
            this.tracking_number = tracking_number;
        }

        @JacksonXmlProperty(isAttribute = true)
        public String getCheck_phoneNo() {
            return check_phoneNo;
        }

        public void setCheck_phoneNo(String check_phoneNo) {
            this.check_phoneNo = check_phoneNo;
        }
    }
}
