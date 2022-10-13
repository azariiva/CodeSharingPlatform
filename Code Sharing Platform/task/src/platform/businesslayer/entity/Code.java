package platform.businesslayer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import platform.support.formatter.DefaultDateFormatter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "codes")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Code {

    @Id
    @Column(name = "id", columnDefinition = "uuid")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "code", columnDefinition="nvarchar")
    private String code;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "time")
    private Long time;

    @Column(name = "views")
    private Integer views;

    @Column(name = "total_views")
    private int totalViews;

    public Long getTimeLeft() {
        if (time == null) {
            return null;
        }

        var created = date.toEpochSecond(ZoneOffset.UTC);
        var now = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        return time - (now - created);
    }

    public Integer getViewsLeft() {
        if (views == null) {
            return null;
        }

        return views - totalViews;
    }

    public String getDateString() {
        return DefaultDateFormatter.format(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Code code = (Code) o;
        return id != null && Objects.equals(id, code.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
