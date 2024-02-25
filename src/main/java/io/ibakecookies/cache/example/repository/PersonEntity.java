package io.ibakecookies.cache.example.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    private String id;
    private String name;
    private String firstName;
    private String lastName;
}
