package com.vgb.yamlpojomerge.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "com.foo.bar.allcreds")
public class AllCredentials {
    private List<Credentials> credentials;

    public List<Credentials> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credentials> credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllCredentials that = (AllCredentials) o;

        return credentials != null ? credentials.equals(that.credentials) : that.credentials == null;
    }

    @Override
    public int hashCode() {
        return credentials != null ? credentials.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AllCredentials{" +
                "credentials=" + credentials +
                '}';
    }
}
