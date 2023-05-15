package com.example.okta.model;


import com.example.okta.auditable.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditable<String> {
    @Id
    private String id;
    private String name;
    private String locale;
    private String email;
    private String username;
    private String givenName;
    private String familyName;
    private Boolean isEmailVerified;
}
