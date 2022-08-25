package com.example.citizenproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "citizen")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "is_citizen")
    private Boolean isCitizen;

    @Column(name = "name")
    private String name;

    @Column(name = "children")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Set<Citizen> children;

    @ManyToOne(fetch = FetchType.LAZY)
    private Citizen parent;

    @Column(name = "has_driving_license")
    private Boolean hasDrivingLicense;
/**
 {
 "isCitizen": true,
 "Name": "John Smith",
 "ID": 123456,
 "Children": {
 "Mike Smith": 123457,
 "Jessica Smith": 123458,
 "Sarah Smith": 123459
 },
 "hasDrivingLicense": true
 }
 */
}
