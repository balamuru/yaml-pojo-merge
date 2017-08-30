package com.vgb.yamlpojomerge.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "com.foo.bar.famcreds")
public class FamilyCredentials {
    private Credentials husband;
    private Credentials wife;

    public Credentials getHusband() {
        return husband;
    }

    public void setHusband(Credentials husband) {
        this.husband = husband;
    }

    public Credentials getWife() {
        return wife;
    }

    public void setWife(Credentials wife) {
        this.wife = wife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyCredentials that = (FamilyCredentials) o;

        if (husband != null ? !husband.equals(that.husband) : that.husband != null) return false;
        return wife != null ? wife.equals(that.wife) : that.wife == null;
    }

    @Override
    public int hashCode() {
        int result = husband != null ? husband.hashCode() : 0;
        result = 31 * result + (wife != null ? wife.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FamilyCredentials{" +
                "husband=" + husband +
                ", wife=" + wife +
                '}';
    }
}
