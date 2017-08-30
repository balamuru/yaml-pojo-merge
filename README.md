# Description:
This is a simple project that illustrates a limitation when merging yml segments across
different profiles and attempting to resolve to a POJO

eg. 
Consider the following POJO
```
public class Credentials {
    private String user;
    private String password;
}
```
This can be composed in following ways 
* a collection of Credential objects
* direct descriptive instances of Credential objects  

```
public class AllCredentials {
    private List<Credentials> credentials; //won't merge (will override instead) because spring doesn't know which original Credential list item to over-ride when an override value is supplied in the profile (for instance , if only one password is supplied, spring doesn't know whether to update list item 1 or 2 etc)
}

public class FamilyCredentials {
    private Credentials husband; //the corresponding yaml is determinate - and spring can determine exactly what field to update
    private Credentials wife;
} 
``` 

The corresponding representations in the default and profile specific YML files follows
```
com.foo.bar.allcreds:
  credentials:
    - user: bill
      password: bi123
    - user: hilary
      password: h123

com.foo.bar.famcreds:
  husband:
    user: bill
    password: bi123
  wife:
    user: hilary
    password: h123

---
spring.profiles: prod
com.foo.bar.allcreds:
  credentials:
    - password: monic@
    - password: my_em@ilz

com.foo.bar.famcreds:
  husband:
    password: monic@
  wife:
    password: my_em@ilz    
```

It is observed that in the case of List<Credentials>, Spring cannot determine which credential instance to update the password 
for (even if the user name is suppllied) since it is provided a list of items, and there is no guarantee
that all items are provided, or (even in order for that matter)

OTOH, the FamilyCredentials YAML resolves perfectly since the paths to the password fields are well formed and determinate.