package com.example.cruddemo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "beers")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;
    private Integer abv;
    private Integer ibu;
    private Integer target_fg;
    private Integer target_og;
    private Integer ebc;
    private Integer srm;
    private Integer ph;
    private Integer attenuation_level;
    private String volume;
    private String boil_volume;
    private String method;
    private String ingredients;
    private String food_pairing;
    private String brewers_tips;
    private String contributed_by;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Beer beer = (Beer) o;
        return getId() != null && Objects.equals(getId(), beer.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
