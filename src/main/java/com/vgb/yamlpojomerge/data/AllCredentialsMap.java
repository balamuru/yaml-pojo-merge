package com.vgb.yamlpojomerge.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "com.foo.bar.allcredsmap")
public class AllCredentialsMap {
    private Map<String, Credentials> credentials;

    public Map<String, Credentials> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, Credentials> credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllCredentialsMap that = (AllCredentialsMap) o;

        return credentials != null ? credentials.equals(that.credentials) : that.credentials == null;
    }

    @Override
    public int hashCode() {
        return credentials != null ? credentials.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AllCredentialsMap{" +
                "credentials=" + credentials +
                '}';
    }
}
