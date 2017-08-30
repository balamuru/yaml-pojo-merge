package com.vgb.yamlpojomerge.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "com.foo.bar.jms")
public class MyJmsConfiguration {
    private Map<String, String> activemq = new HashMap<>();
    private Map<String, String> wmq = new HashMap<>();

    public Map<String, String> getActivemq() {
        return activemq;
    }

    public void setActivemq(Map<String, String> activemq) {
        this.activemq = activemq;
    }

    public Map<String, String> getWmq() {
        return wmq;
    }

    public void setWmq(Map<String, String> wmq) {
        this.wmq = wmq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyJmsConfiguration that = (MyJmsConfiguration) o;

        if (activemq != null ? !activemq.equals(that.activemq) : that.activemq != null) return false;
        return wmq != null ? wmq.equals(that.wmq) : that.wmq == null;
    }

    @Override
    public int hashCode() {
        int result = activemq != null ? activemq.hashCode() : 0;
        result = 31 * result + (wmq != null ? wmq.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MyJmsConfiguration{" +
                "activemq=" + activemq +
                ", wmq=" + wmq +
                '}';
    }
}